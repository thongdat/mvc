package com.example.demo0.service;

import com.example.demo0.model.Product;
import com.example.demo0.repository.IProductRepository;
import com.example.demo0.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}

