package com.mlodovico.course.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123");
        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhone());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testUserEquals() {
        User user1 = new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123");
        User user2 = new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123");
        User user3 = new User(2L, "Jane Doe", "jane.doe@example.com", "0987654321", "password456");

        assertTrue(user1.equals(user2));
        assertFalse(user1.equals(user3));
    }

    @Test
    public void testUserHashCode() {
        User user1 = new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123");
        User user2 = new User(1L, "John Doe", "john.doe@example.com", "1234567890", "password123");

        assertEquals(user1.hashCode(), user2.hashCode());
    }
}