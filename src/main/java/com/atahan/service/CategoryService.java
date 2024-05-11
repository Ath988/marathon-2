package com.atahan.service;

import com.atahan.entity.Category;
import com.atahan.repository.CategoryRepo;

import java.util.List;

public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService() {
        this.categoryRepo = new CategoryRepo();
    }
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }
    public List<Category> categoryList() {
        return categoryRepo.findAll();
    }

}
