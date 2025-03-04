package com.example.kinoxp_backend.repository.kiosk;

import com.example.kinoxp_backend.model.kiosk.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
