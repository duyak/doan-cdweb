package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.Product;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.server.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service(value = "productServer")
@Transactional
public class ProductServerImpl implements ProductServer {

    @Autowired
    private ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        product.setActiveFlag(1);
        product.setCreateDate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        productRepository.addProduct(product);

    }

    @Override
    public void editProduct(Product product) {
        product.setUpdateDate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        productRepository.editProduct(product);

    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productRepository.deleteProduct(idProduct);

    }

    @Override
    public Product getIdProduct(Integer id) {

        return productRepository.getIdProduct(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public List<Product> searchProduct(String search) {
        return productRepository.searchProduct(search);
    }


    @Override
    public List<Product> getProductByCategory(Integer idCategory) {
        return productRepository.getProductByCategory(idCategory);
    }

    @Override
    public List<Product> getProductByBrand(Integer idBrand) {
        return productRepository.getProductByCategory(idBrand);
    }

    @Override
    public List<Product> loadProductPage(String page) {
        return productRepository.loadProductPage(page);
    }
}
