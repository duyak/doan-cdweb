package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.repository.BrandRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "brandDao")
public class BrandRepositoryImpl implements BrandRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Brand> getAllBrands() {
        // Reading the records from the table
        Session session = sessionFactory.openSession();
        List<Brand> brands = session.createCriteria(Brand.class).list();
        System.out.println("------List of Brands------");
        System.out.println(brands);
        // session.flush is used for clear cache in the session
        session.flush();
        // it will close the particular session after completing the process
        session.close();
        return brands;
    }

    @Override
    public Brand getBrandById(Integer brandId) {
        // Reading the records from the table
        Session session = sessionFactory.openSession();
        // select * from Brand where isbn=i
        Brand brand = (Brand) session.get(Brand.class, brandId);
        session.close();
        return brand;
    }

    @Override
    public void deleteBrand(Brand brand) {
        Session session = sessionFactory.openSession();
//        Brand brand = (Brand) session.get(Brand.class, brandId);
        session.saveOrUpdate(brand);
        System.out.println(brand);
        session.flush();
        // close the session
        session.close();


    }

    @Override
    public void addBrandId(Brand brand) {
        Session session = sessionFactory.openSession();
        session.save(brand);
        session.close();

    }

    @Override
    public void editBrand(Brand brand) {
        Session session = sessionFactory.openSession();
        session.update(brand);
        session.flush();
        session.close();

    }

    @Override
    public void deleteBrand(Integer brandId) {
        Session session = sessionFactory.openSession();
        Brand brand = (Brand) session.get(Brand.class, brandId);
        brand.setId(brandId);
        brand.setActiveFlag(0);
        brand.setStatus(0);
        brand.getUpdateDate();
        session.saveOrUpdate(brand);
        session.flush();
        session.close();


    }
}
