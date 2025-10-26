package serv;

import entities.Product;
import entities.Category;
import services.ProductService;
import services.CategoryService;
 import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));

        Category category = categoryService.findAll().stream()
                .filter(c -> c.getId().equals(categoryId))
                .findFirst()
                .orElse(null);

        if (category != null) {
            Product product = new Product(name, price, new Date(), category);
            productService.create(product);
        }

        response.sendRedirect("products");
    }
}
