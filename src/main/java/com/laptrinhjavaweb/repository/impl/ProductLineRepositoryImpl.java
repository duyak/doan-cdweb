package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.repository.ProductLineRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "productLineDao")
public class ProductLineRepositoryImpl implements ProductLineRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ProductLine> getAllProductLines() {
        Session session = sessionFactory.getCurrentSession();
        List<ProductLine> list = session.createQuery("FROM ProductLine").list();
        return list;
    }

    @Override
    public ProductLine getProductLineById(Integer productLineId) {
        Session session = sessionFactory.getCurrentSession();
        ProductLine productLine = (ProductLine) session.get(ProductLine.class, productLineId);
        return productLine;
    }

    @Override
    public void addProductLine(ProductLine productLine) {
        Session session = sessionFactory.getCurrentSession();
        session.save(productLine);

    }

    @Override
    public void editProductLine(ProductLine productLine) {
        Session session = sessionFactory.getCurrentSession();
        session.update(productLine);

    }

    @Override
    public void deleteProductLine(ProductLine productLine) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(productLine);


    }

    /*Lấy danh sách productline tu brand
     * @Param idBrand
     *
     * */
    @SuppressWarnings("unchecked")
    public List<ProductLine> getProductLineByBrand(Integer brandId){
        Session session = sessionFactory.getCurrentSession();
        List<ProductLine> list = session.createQuery("FROM ProductLine WHERE brandId.id = '" + brandId + "'").list();
        return list;
    }



}
