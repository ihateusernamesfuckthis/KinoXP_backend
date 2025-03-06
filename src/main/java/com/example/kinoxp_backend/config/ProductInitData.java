package com.example.kinoxp_backend.config;

import com.example.kinoxp_backend.model.kiosk.Product;
import com.example.kinoxp_backend.repository.kiosk.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductInitData implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create and save products for the cinema kiosk
        Product product1 = new Product();
        product1.setName("Popcorn (Stor)");
        product1.setPrice(59.99);
        product1.setCategory("snacks");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Popcorn (Mellem)");
        product2.setPrice(49.99);
        product2.setCategory("snacks");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Popcorn (Lille)");
        product3.setPrice(39.99);
        product3.setCategory("snacks");
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setName("Coca-Cola (0.5L)");
        product4.setPrice(34.99);
        product4.setCategory("drinks");
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setName("Fanta (0.5L)");
        product5.setPrice(34.99);
        product5.setCategory("drinks");
        productRepository.save(product5);

        Product product6 = new Product();
        product6.setName("Sprite (0.5L)");
        product6.setPrice(34.99);
        product6.setCategory("drinks");
        productRepository.save(product6);

        Product product7 = new Product();
        product7.setName("M&M's Peanut (100g)");
        product7.setPrice(29.99);
        product7.setCategory("chocolate");
        productRepository.save(product7);

        Product product8 = new Product();
        product8.setName("M&M's Chokolade (100g)");
        product8.setPrice(29.99);
        product8.setCategory("chocolate");
        productRepository.save(product8);

        Product product9 = new Product();
        product9.setName("Skittles (100g)");
        product9.setPrice(24.99);
        product9.setCategory("candy");
        productRepository.save(product9);

        Product product10 = new Product();
        product10.setName("Marabou Mælkechokolade (200g)");
        product10.setPrice(39.99);
        product10.setCategory("chocolate");
        productRepository.save(product10);

        Product product11 = new Product();
        product11.setName("Haribo Matador Mix (300g)");
        product11.setPrice(49.99);
        product11.setCategory("candy");
        productRepository.save(product11);

        Product product12 = new Product();
        product12.setName("Nachos med Ost & Salsa");
        product12.setPrice(69.99);
        product12.setCategory("snacks");
        productRepository.save(product12);
    }
}
