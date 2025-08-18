package com.example.demo0.service;

import com.example.demo0.model.Category;
import com.example.demo0.repository.CategoryRepository;
import com.example.demo0.repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryRepository {
    private ICategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
