package com.mlodovico.course.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void testCategoryCreation() {
        Category category = new Category(1L, "Electronics");
        assertEquals(1L, category.getId());
        assertEquals("Electronics", category.getName());
    }

    @Test
    public void testCategoryEquals() {
        Category category1 = new Category(1L, "Electronics");
        Category category2 = new Category(1L, "Electronics");
        Category category3 = new Category(2L, "Books");

        assertTrue(category1.equals(category2));
        assertFalse(category1.equals(category3));
    }

    @Test
    public void testCategoryHashCode() {
        Category category1 = new Category(1L, "Electronics");
        Category category2 = new Category(1L, "Electronics");

        assertEquals(category1.hashCode(), category2.hashCode());
    }
}