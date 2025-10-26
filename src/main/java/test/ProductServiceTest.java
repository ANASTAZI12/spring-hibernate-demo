package test;

import entities.Category;
import entities.Product;
import services.CategoryService;
import services.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;


public class ProductServiceTest {

    private static CategoryService categoryService;
    private static ProductService productService;
    private static Category testCategory;

    @BeforeAll
    public static void init() {
        categoryService = new CategoryService();
        productService = new ProductService();
        testCategory = new Category("Electronique");
        categoryService.create(testCategory);
    }

    @Test
    public void testCreateProduct() {
        Product p = new Product("PC Portable", 1200.0, new Date(), testCategory);
        productService.create(p);
        assertNotNull(p.getId());
    }

    @Test
    public void testFindAllProducts() {
        List<Product> list = productService.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
    }
}
