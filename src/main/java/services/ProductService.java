package services;

import entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  // Gère automatiquement les transactions
public class ProductService {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Product p) {
        Session session = sessionFactory.getCurrentSession();
        session.save(p);
    }

    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product", Product.class).getResultList();
    }
}
