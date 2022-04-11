package com.aston.mihail.dao;

import com.aston.mihail.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoIm {

    public Optional<User> findByLogin(String login) throws SQLException {
        final String sql = "select * from users where login=?";
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                User user = new User(login, resultSet.getBytes("password"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean insertUser(User user) {
        final String sqlCheck = "SELECT login from users where login = ?";
        final String sqlInsert = "INSERT INTO users (login, password) VALUES (?,?)";
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement statement1 = connection.prepareStatement(sqlCheck);
             PreparedStatement statement2 = connection.prepareStatement(sqlInsert)) {

            statement1.setString(1, user.getLogin());
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next()) {
                return false;
            } else {
                statement2.setString(1, user.getLogin());
                statement2.setBytes(2, user.getPassword());
                statement2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean isValid(final String login, final byte[] password) {
        final String sql = "SELECT login, pass from users where login = ? and pass = ?";
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, login);
            statement.setBytes(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public Optional<User> findBypass(String pass) throws SQLException {
//        return Optional.empty();
//    }
}
