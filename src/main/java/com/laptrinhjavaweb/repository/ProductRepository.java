package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    //them san pham
    public void addProduct(Product product);

    //sua san pham
    public void editProduct(Product product);

    // Xoa san pham
    public void deleteProduct(Product product);

    // xoa san pham
    public void deleteProduct(Integer idProduct);

    // lay id san pham
    public Product getIdProduct(Integer id);

    // lay danh sach san pham
    public List<Product> getAllProduct();

    // tim kiem san pham
    public List<Product> searchProduct(String search);

    // lay danh sach tu danh muc
    public List<Product> getProductByCategory(Integer idCategory);

    // lay danh sach san pham tu hang san xuat
    public List<Product> getProductByBrand(Integer idBrand);

    // phan trang
    public List<Product> loadProductPage(String page);




}
