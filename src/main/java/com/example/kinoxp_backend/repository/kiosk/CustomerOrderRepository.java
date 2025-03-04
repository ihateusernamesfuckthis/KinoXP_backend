package com.example.kinoxp_backend.repository.kiosk;

import com.example.kinoxp_backend.model.kiosk.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
}
