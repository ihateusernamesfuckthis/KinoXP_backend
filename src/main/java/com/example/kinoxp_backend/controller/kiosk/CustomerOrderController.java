package com.example.kinoxp_backend.controller.kiosk;


import com.example.kinoxp_backend.model.kiosk.CustomerOrder;
import com.example.kinoxp_backend.model.kiosk.OrderItem;
import com.example.kinoxp_backend.model.kiosk.Product;
import com.example.kinoxp_backend.repository.kiosk.CustomerOrderRepository;
import com.example.kinoxp_backend.repository.kiosk.ProductRepository;
import com.example.kinoxp_backend.service.kiosk.CustomerOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;
    private final CustomerOrderRepository orderRepository;
    private final ProductRepository productRepository;

    public CustomerOrderController(CustomerOrderService customerOrderService, CustomerOrderRepository orderRepository,
                                   ProductRepository productRepository) {
        this.customerOrderService = customerOrderService;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return customerOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getOrderById(@PathVariable int id) {
        Optional<CustomerOrder> order = customerOrderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder order) {

        double calculatedTotalPrice = order.getItems().stream()
                .mapToDouble(OrderItem::getSubTotal)
                .sum();  // 🟢 Summerer alle subtotaler

        System.out.println("TotalPrice fra frontend: " + order.getTotalPrice());
        System.out.println("Beregnet totalPrice i backend: " + calculatedTotalPrice);

        if (order.getTotalPrice() != calculatedTotalPrice) {
            System.out.println("⚠️ Advarsel: TotalPrice fra frontend matcher ikke beregningen i backend!");
        }

        for (OrderItem item : order.getItems()) {
            item.setOrder(order);

            if (item.getProduct() == null || item.getProduct().getId() == 0) {
                throw new RuntimeException("Produkt mangler eller har ugyldigt ID");
            }

            // 🟢 Hent produktet fra databasen for at sikre, at det er en gyldig entitet
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Produkt ikke fundet med ID: " + item.getProduct().getId()));

            item.setProduct(product);
        }
        order.setTotalPrice(calculatedTotalPrice);

        CustomerOrder savedOrder = orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
