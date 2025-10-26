package test;

import org.junit.jupiter.api.Test;

import entities.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testProductPrice() {
        Product p = new Product();
        p.setPrice(100.0);
        assertTrue(p.getPrice() > 0, "Le prix doit être positif");
    }
}
