package com.example.demo0.repository;

import com.example.demo0.model.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);

    Product findById(String id);
    void update(Product product);
    boolean delete(String id);
}


