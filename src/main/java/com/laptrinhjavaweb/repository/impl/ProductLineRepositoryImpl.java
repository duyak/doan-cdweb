package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.entity.ProductLineEntity;
import com.laptrinhjavaweb.repository.ProductLineRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository("productlineDAO")
public class ProductLineRepositoryImpl implements ProductLineRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    @Override
    public List<ProductLineEntity> findByBrand(int brandId) {
        List<ProductLineEntity> productLineEntities = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            productLineEntities = session.createQuery("SELECT pl.id as id,"
                    + "pl.name as name " + "FROM ProductLine pl "
                    + "WHERE brandId.id = :brandId")
                    .setInteger("brandId", brandId)
                    .setResultTransformer(Transformers.aliasToBean(ProductLineEntity.class)).list();

            transaction.commit();

        } catch (Exception e) {
            productLineEntities = null;
            if (transaction != null) {
                transaction.rollback();
            }


        } finally {
            session.close();


        }
        return productLineEntities;
    }

    @Override
    public void addProductLine(ProductLine productLine) {
        Session session = sessionFactory.openSession();
        session.save(productLine);
        session.close();

    }
}
