package com.example.kinoxp_backend.controller.kiosk;


import com.example.kinoxp_backend.model.kiosk.CustomerOrder;
import com.example.kinoxp_backend.service.kiosk.CustomerOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
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
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return customerOrderService.saveOrder(order);
    }
}
