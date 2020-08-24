package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.server.CategoryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service(value = "categoryService")
public class CategoryServerImpl implements CategoryServer {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.getCategoryById(categoryId);
    }

    @Override
    public void addCategoryId(Category category) {
        category.setCreateDate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        category.setUpdateDate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        category.setActiveFlag(1);
        categoryRepository.addCategoryId(category);

    }

    @Override
    public void editCategory(Category category) {
        category.setUpdateDate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        categoryRepository.editCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        category.setActiveFlag(0);
        categoryRepository.deleteCategory(category);

    }


}
