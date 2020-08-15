package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.entity.ProductLineEntity;
import com.laptrinhjavaweb.repository.ProductLineRepository;
import com.laptrinhjavaweb.server.ProductLineServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("productLineServer")
public class ProductLineServerImpl implements ProductLineServer {

    @Autowired
    private ProductLineRepository productLineRepository;

    @Override
    public List<ProductLineEntity> findByBrand(int brandId) {
        return productLineRepository.findByBrand(brandId);
    }

    @Override
    public void addProductLine(ProductLine productLine) {
        productLine.setCreateDate(new Date());
        productLine.setCreateUpdate(new Date());
        productLineRepository.addProductLine(productLine);

    }
}
