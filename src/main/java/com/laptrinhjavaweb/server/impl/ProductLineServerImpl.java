package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.repository.ProductLineRepository;
import com.laptrinhjavaweb.server.ProductLineServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service(value = "productLineServer")
public class ProductLineServerImpl implements ProductLineServer {

    @Autowired
    private ProductLineRepository productLineRepository;

    @Override
    public List<ProductLine> getAllProductLines() {
        return productLineRepository.getAllProductLines();
    }

    @Override
    public ProductLine getProductLineById(Integer productLineId) {
        return productLineRepository.getProductLineById(productLineId);
    }

    @Override
    public void addProductLine(ProductLine productLine) {
        productLine.setCreateDate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        productLine.setCreateUpdate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        productLineRepository.addProductLine(productLine);

    }

    @Override
    public void editProductLine(ProductLine productLine) {
        productLineRepository.editProductLine(productLine);

    }

    @Override
    public void deleteProductLine(ProductLine productLine) {
        productLineRepository.addProductLine(productLine);

    }

    @Override
    public List<ProductLine> getProductLineByBrand(Integer brandId) {
        return productLineRepository.getProductLineByBrand(brandId);
    }


}
