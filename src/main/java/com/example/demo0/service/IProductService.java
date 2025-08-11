package com.example.demo0.service;

import com.example.demo0.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
}
