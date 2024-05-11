package com.atahan.repository;

import com.atahan.entity.Category;
import com.atahan.utility.Repository;

public class CategoryRepo extends Repository<Category,Long> {
    public CategoryRepo() {
        super(new Category());
    }
    public CategoryRepo(Category entity) {
        super(entity);
    }
}
