package com.aston.mihail.dao;

import com.aston.mihail.model.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerDaoIm {

    public List<Owner> getOwners() {
        final String sql = "SELECT * from owners";
        List<Owner> ownerList = new ArrayList<>();
        try (Connection connection = DataSourceFactory.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            Owner owner = null;
            while (resultSet.next()) {
                owner = new Owner();
                owner.setName(resultSet.getString("name"));
                owner.setSurName("surname");
                owner.setEmail("email");
                owner.setPhone("phone");
                ownerList.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerList;
    }

    public void deleteOwnerById (int id) {
        final String sql = "DELETE from owners where id=(?)";
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOwner(Owner owner) {
        final String sql = "INSERT INTO owners (name, surname, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection connection = DataSourceFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, owner.getName());
            statement.setString(2, owner.getSurName());
            statement.setString(3, owner.getEmail());
            statement.setString(4, owner.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
