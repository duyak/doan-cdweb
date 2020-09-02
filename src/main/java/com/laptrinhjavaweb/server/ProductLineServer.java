package com.laptrinhjavaweb.server;

import com.laptrinhjavaweb.entity.ProductLine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductLineServer {
    List<ProductLine> getAllProductLines();

    ProductLine getProductLineById(Integer productLineId);

    void addProductLine(ProductLine productLine);

    void editProductLine(ProductLine productLine);

    void deleteProductLine(ProductLine productLine);

    List<ProductLine> getProductLineByBrand(Integer brandId);



}
