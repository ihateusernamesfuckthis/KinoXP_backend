package com.example.kinoxp_backend.service.kiosk;

import com.example.kinoxp_backend.model.kiosk.CustomerOrder;
import com.example.kinoxp_backend.repository.kiosk.CustomerOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService (CustomerOrderRepository customerOrderRepository){
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    public Optional<CustomerOrder> getOrderById(int id) {
        return customerOrderRepository.findById(id);
    }

    public CustomerOrder saveOrder(CustomerOrder order) {
        return customerOrderRepository.save(order);
    }

    public void deleteOrder(int id){
        customerOrderRepository.deleteById(id);
    }
}
