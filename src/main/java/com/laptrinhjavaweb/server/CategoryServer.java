package com.laptrinhjavaweb.server;

import com.laptrinhjavaweb.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServer {

    List<Category> getAllCategory();

    Category getCategoryById(Integer categoryId);

//    void deleteCategory(Category category);

    void addCategoryId(Category category);

    void editCategory(Category category);

    void deleteCategory(Category category);

}
