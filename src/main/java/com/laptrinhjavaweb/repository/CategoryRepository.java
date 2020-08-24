package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.entity.ProductLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    List<Category> getAllCategory();

    Category getCategoryById(Integer categoryId);

    void deleteCategory(Category category);

    void addCategoryId(Category category);

    void editCategory(Category category);

//    void deleteCategory(Integer categoryId);
}
