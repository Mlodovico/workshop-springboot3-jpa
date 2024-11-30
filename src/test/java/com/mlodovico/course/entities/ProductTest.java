package com.mlodovico.course.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");
        assertEquals(1L, product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals("High-end gaming laptop", product.getDescription());
        assertEquals(1500.0, product.getPrice());
        assertEquals("imgUrl", product.getImgUrl());
    }

    @Test
    public void testProductEquals() {
        Product product1 = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");
        Product product2 = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");
        Product product3 = new Product(2L, "Smartphone", "Latest model smartphone", 800.0, "imgUrl2");

        assertTrue(product1.equals(product2));
        assertFalse(product1.equals(product3));
    }

    @Test
    public void testProductHashCode() {
        Product product1 = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");
        Product product2 = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");

        assertEquals(product1.hashCode(), product2.hashCode());
    }
}