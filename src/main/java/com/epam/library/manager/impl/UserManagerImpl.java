package com.epam.library.manager.impl;

import com.epam.library.db.DBConnectionProvider;
import com.epam.library.manager.UserManager;
import com.epam.library.model.User;
import com.epam.library.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager<Integer, User> {

    private static final Connection CONNECTION = DBConnectionProvider.getInstance().getConnection();


    @Override
    public User getById(Integer id) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM users where id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO users(name, last_name, email, password) VALUES(?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            int execute = preparedStatement.executeUpdate();
            System.out.println(execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement ps = CONNECTION.prepareStatement("UPDATE users SET name=?, last_name=?, email=? where id=?;");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("DELETE FROM users where id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {

        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM users where email=? and password=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Given user with email: %s and password %s not found", email, password));
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM users where email=?");
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
