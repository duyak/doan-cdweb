package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ProductLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductLineRepository {

//    public ProductLine findByNameProductLine(String name);

    List<ProductLine> getAllProductLines();

    ProductLine getProductLineById(Integer productLineId);

    void addProductLine(ProductLine productLine);

    void editProductLine(ProductLine productLine);

    void deleteProductLine(ProductLine productLine);

    List<ProductLine> getProductLineByBrand(Integer brandId);




}
