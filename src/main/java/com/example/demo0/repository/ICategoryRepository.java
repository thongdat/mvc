package com.example.demo0.repository;

import com.example.demo0.model.Category;
import com.example.demo0.model.Product;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
