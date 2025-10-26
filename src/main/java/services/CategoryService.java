package services;

import entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  // Spring gère les transactions
public class CategoryService {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Category c) {
        Session session = sessionFactory.getCurrentSession();
        session.save(c);
    }

    public List<Category> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category", Category.class).getResultList();
    }
}
