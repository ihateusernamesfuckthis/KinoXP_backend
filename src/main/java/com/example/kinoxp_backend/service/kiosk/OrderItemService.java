package com.example.kinoxp_backend.service.kiosk;

import com.example.kinoxp_backend.model.kiosk.OrderItem;
import com.example.kinoxp_backend.repository.kiosk.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(int id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItemById(int id){
        orderItemRepository.deleteById(id);
    }

}
