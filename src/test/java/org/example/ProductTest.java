package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void builderCreatesProduct() {
        Product product = new Product.Builder()
                .id(1)
                .name("Christoffer")
                .category("Person")
                .rating(10)
                .build();

        assertEquals(1, product.getId());
        assertEquals("Christoffer", product.getName());
        assertEquals("Person", product.getCategory());
        assertEquals(10, product.getRating());
    }

    @Test
    void builderThrowsExceptionWhenIdIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product.Builder()
                    .id(0)
                    .name("Christoffer")
                    .category("Person")
                    .rating(10)
                    .build();
        });
    }

    @Test
    void builderThrowsExceptionWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product.Builder()
                    .id(1)
                    .name("")
                    .category("Person")
                    .rating(10)
                    .build();
        });
    }

    @Test
    void builderThrowsExceptionWhenCategoryIsMissing() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product.Builder()
                    .id(1)
                    .name("Christoffer")
                    .rating(10)
                    .build();
        });
    }

    @Test
    void builderThrowsExceptionWhenRatingIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product.Builder()
                    .id(1)
                    .name("Christoffer")
                    .category("Person")
                    .rating(11)
                    .build();
        });
    }

    @Test
    void builderThrowsExceptionWhenFieldsAreMissing() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Product.Builder().build()
        );
    }
}
