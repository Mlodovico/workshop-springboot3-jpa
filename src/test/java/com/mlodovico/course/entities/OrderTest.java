package com.mlodovico.course.entities;

import com.mlodovico.course.entities.enums.OrderStatus;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderCreation() {
        User user = new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123");
        Order order = new Order(1L, Instant.now(), OrderStatus.PAID, user);
        assertEquals(1L, order.getId());
        assertNotNull(order.getMoment());
        assertEquals(OrderStatus.PAID, order.getOrderStatus());
        assertEquals(user, order.getClienId());
    }

    @Test
    public void testOrderEquals() {
        User user = new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123");
        Order order1 = new Order(1L, Instant.now(), OrderStatus.PAID, user);
        Order order2 = new Order(1L, Instant.now(), OrderStatus.PAID, user);
        Order order3 = new Order(2L, Instant.now(), OrderStatus.WAITING_PAYMENT, user);

        assertTrue(order1.equals(order2));
        assertFalse(order1.equals(order3));
    }
}