package com.example.products.services;

import com.example.products.entities.ProductDto;
import com.example.products.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

@SpringBootTest(classes = ProductService.class)
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        ProductDto product = new ProductDto();
        product.setTitle("Nuts");
        product.setPrice(10);
        product.setId(99L);
        Mockito
                .doReturn(Optional.of(product))
                .when(productRepository)
                .findById(99L);
        ProductDto p = productService.findProductDtoById(99L).get();
        Mockito.verify(productRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(99L));
        Assertions.assertEquals("Nuts", p.getTitle());
    }
}
