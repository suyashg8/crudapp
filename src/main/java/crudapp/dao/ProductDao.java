package crudapp.dao;


import crudapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional
    public void createProduct(Product product)
    {
        this.hibernateTemplate.save(product);
    }

    public List<Product> getAllProducts()
    {
        List<Product> products=this.hibernateTemplate.loadAll(Product.class);
        return products;
    }
    @Transactional
    public void deleteProduct(int pid)
    {
        Product p=this.hibernateTemplate.load(Product.class,pid);
        this.hibernateTemplate.delete(p);
    }

    public Product getProduct(int pid)
    {
        return this.hibernateTemplate.get(Product.class,pid);
    }
}
