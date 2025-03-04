package com.example.kinoxp_backend.repository.kiosk;

import com.example.kinoxp_backend.model.kiosk.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
