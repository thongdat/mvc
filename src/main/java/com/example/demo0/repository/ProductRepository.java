package com.example.demo0.repository;

import com.example.demo0.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();
    private final String DELETE_BY_ID = "call delete_by_id(?);";

    static {
        productList.add(new Product("1", "a", 123332312, "good", "a"));
        productList.add(new Product("2", "b", 123332444, "normal", "b"));
        productList.add(new Product("3", "c", 12333312, "bad", "c"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();


        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                    "from product\n" +
                    "order by name asc;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String productor = resultSet.getString("productor");
                Product product = new Product(id, name, price, description, productor);
                productList.add(product);
            }

        }catch (SQLException e){
            System.out.println("Loi Querry");
        }

        return productList;


    }

    @Override
    public void save(Product product) {
        try(Connection connection = BaseRepository.getConnectDB();){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id,name,price,description,productor) values(?,?,?,?,?);");
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getProductor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
    public boolean delete(String id) {
        try (Connection connection = BaseRepository.getConnectDB()) {
            CallableStatement callableStatement = connection.prepareCall(DELETE_BY_ID);
            callableStatement.setString(1, id);
            int effectRow = callableStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("Lỗi query: " + e.getMessage());
            return false;
        }
    }

}

