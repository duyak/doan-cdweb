package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.repository.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "categoryDao")
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> getAllCategory() {
        Session session = sessionFactory.openSession();
        List<Category> categories = session.createCriteria(Category.class).list();
        System.out.println("------------List if Category");
        System.out.println(categories);
        session.flush();
        session.close();
        return categories;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        Session session = sessionFactory.openSession();
        Category category = (Category) session.get(Category.class, categoryId);
        session.close();
        return category;
    }

    @Override
    public void addCategoryId(Category category) {
        Session session = sessionFactory.openSession();
        session.save(category);
    }

    @Override
    public void editCategory(Category category) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(category);
        session.flush();
        session.close();

    }

    @Override
    public void deleteCategory(Category category) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(category);
        System.out.println(category);
        session.flush();
        session.close();

    }
}
