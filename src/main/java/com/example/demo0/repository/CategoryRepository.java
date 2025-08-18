package com.example.demo0.repository;

import com.example.demo0.model.Category;
import com.example.demo0.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements  ICategoryRepository {
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM category";

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id, name));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn category: " + e.getMessage());
        }

        return categories;
    }

}
