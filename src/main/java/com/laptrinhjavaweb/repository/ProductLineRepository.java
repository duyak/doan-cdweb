package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.entity.ProductLineEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductLineRepository {

    public List<ProductLineEntity> findByBrand(int brandId);

    public void addProductLine(ProductLine productLine);


}
