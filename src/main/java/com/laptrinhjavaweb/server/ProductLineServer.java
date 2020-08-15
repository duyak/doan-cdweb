package com.laptrinhjavaweb.server;

import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.entity.ProductLineEntity;

import java.util.List;

public interface ProductLineServer {

    public List<ProductLineEntity> findByBrand(int brandId);


    public void addProductLine(ProductLine productLine);

}
