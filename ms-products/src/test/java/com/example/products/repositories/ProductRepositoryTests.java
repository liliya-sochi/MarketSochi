package com.example.products.repositories;

import com.example.products.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void initDBTest() {
        List<Product> productList = productRepository.findAll();
        Assertions.assertEquals(8, productList.size());
    }
}