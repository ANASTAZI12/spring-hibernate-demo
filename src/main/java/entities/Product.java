package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @ManyToOne
    private Category category;

    // Constructeur par défaut requis par JPA
    public Product() {}

    // Constructeur pratique pour créer un produit avec catégorie et date
    public Product(String name, double price, Date creationDate, Category category) {
        this.name = name;
        this.price = price;
        this.creationDate = creationDate;
        this.category = category;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
