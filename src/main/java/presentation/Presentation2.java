package presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import entities.Product;
import entities.Category;
import services.ProductService;
import services.CategoryService;
import util.HibernateConfig;

import java.util.Date;

public class Presentation2 {

    public static void main(String[] args) {
        // Créer le contexte Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        // Récupérer les services Spring
        ProductService productService = context.getBean(ProductService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);

        // Créer et sauvegarder une catégorie
        Category category1 = new Category();
        category1.setName("Categorie 1");
        categoryService.create(category1);
        System.out.println("Categorie sauvegardée : " + category1.getName());

        // Créer et sauvegarder un produit
        Product product1 = new Product();
        product1.setName("Produit 1");
        product1.setPrice(100.0);
        product1.setCreationDate(new Date()); // date du jour
        product1.setCategory(category1); // lier le produit à la catégorie

        productService.create(product1);
        System.out.println("Produit sauvegardé : " + product1.getName() + " | Catégorie : " + product1.getCategory().getName());
    }
}
