package com.example.demo0.repository;

import com.example.demo0.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("1", "a", 123332312, "good", "a"));
        productList.add(new Product("2", "b", 123332444, "normal", "b"));
        productList.add(new Product("3", "c", 12333312, "bad", "c"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }
    @Override
    public Product findById(String id) {

        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        Product existing = findById(product.getId());
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setProductor(product.getProductor());
        }
    }

    @Override
    public void delete(String id) {
        productList.removeIf(p -> p.getId().equals(id));
    }
}

