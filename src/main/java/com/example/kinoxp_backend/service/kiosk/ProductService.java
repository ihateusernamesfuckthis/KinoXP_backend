package com.example.kinoxp_backend.service.kiosk;

import com.example.kinoxp_backend.model.kiosk.Product;
import com.example.kinoxp_backend.repository.kiosk.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // OBS: kan kun få det til at virke ved at bruge wrapper datatypen Optional??
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }
}
