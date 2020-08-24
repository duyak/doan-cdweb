package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.entity.Product;
import com.laptrinhjavaweb.repository.ProductRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);

    }

    @Override
    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);

    }

    @Override
    public void deleteProduct(Product product) {


    }

    @Override
    public void deleteProduct(Integer idProduct) {
        Session session = sessionFactory.openSession();
        Product product = (Product) session.get(Product.class, idProduct);
        product.setId(idProduct);
        product.setActiveFlag(0);
        session.saveOrUpdate(product);
        session.flush();
        session.close();

    }


    @Override
    public Product getIdProduct(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAllProduct() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> list = session.createQuery("FROM Product").list();
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> searchProduct(String search) {
        Session session = sessionFactory.getCurrentSession();
        List<Product> list = session.createQuery("FROM Product WHERE name LIKE '%" + search +
                "%' OR quantity LIKE '%" + search + "%' OR description LIKE '%" + search + "%' OR uniBrief LIKE '%" +
                search + "%' OR price LIKE '%" + search + "%'").list();
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProductByCategory(Integer idCategory) {
        Session session = sessionFactory.getCurrentSession();
        List<Product> list = session.createQuery("FROM Product WHERE categoryId.id = '" + idCategory + "'").list();

        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProductByBrand(Integer idBrand) {
        Session session = sessionFactory.getCurrentSession();
        List<Product> list = session.createQuery("FROM Product WHERE brandId.id = '" + idBrand + "'").list();

        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> loadProductPage(String page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Product");
        int result = 0;
        if (page.equals("1")) {
            result = 0;
        } else {
            String temp = String.valueOf(page) + "0";
            result = Integer.parseInt(temp) - 10;
        }
        query.setFirstResult(result);
        query.setMaxResults(10);
        return query.list();
    }
}
