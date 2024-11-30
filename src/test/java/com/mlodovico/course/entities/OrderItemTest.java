package com.mlodovico.course.entities;

import com.mlodovico.course.entities.enums.OrderStatus;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

//    @Test
//    public void testOrderItemCreation() {
//        Product product = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");
//        Order order = new Order(1L, Instant.now(), OrderStatus.PAID, new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123"));
//        OrderItem orderItem = new OrderItem(order, product, 2, 1500.0);
//
//        assertEquals(order, orderItem.getOrder());
//        assertEquals(product, orderItem.getProduct());
//        assertEquals(2, orderItem.getQuantity());
//        assertEquals(1500.0, orderItem.getPrice());
//    }
//
//    @Test
//    public void testOrderItemEquals() {
//        Product product = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");
//        Order order = new Order(1L, Instant.now(), OrderStatus.PAID, new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123"));
//        OrderItem orderItem1 = new OrderItem(order, product, 2, 1500.0);
//        OrderItem orderItem2 = new OrderItem(order, product, 2, 1500.0);
//        OrderItem orderItem3 = new OrderItem(order, product, 3, 1500.0);
//
//        assertTrue(orderItem1.equals(orderItem2));
//        assertFalse(orderItem1.equals(orderItem3));
//    }
//
//    @Test
//    public void testOrderItemHashCode() {
//        Product product = new Product(1L, "Laptop", "High-end gaming laptop", 1500.0, "imgUrl");
//        Order order = new Order(1L, Instant.now(), OrderStatus.PAID, new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123"));
//        OrderItem orderItem1 = new OrderItem(order, product, 2, 1500.0);
//        OrderItem orderItem2 = new OrderItem(order, product, 2, 1500.0);
//
//        assertEquals(orderItem1.hashCode(), orderItem2.hashCode());
//    }
}