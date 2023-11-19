package com.epam.library.manager.impl;

import com.epam.library.db.DBProvider;
import com.epam.library.manager.UserManager;
import com.epam.library.model.User;
import com.epam.library.model.UserRole;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Component("userManager")
public class UserManagerImpl implements UserManager<Integer, User> {

    private final DBProvider dbProvider;

    public UserManagerImpl(DBProvider dbProvider) {
        this.dbProvider = dbProvider;
    }

    @Override
    public void save(User user) {
        try (Connection connection = dbProvider.dataSource().getConnection()) {
            if (!userTableExists(connection, "users")) {
                createUsersTable(connection);
            }
            String sql = "INSERT INTO users (name, last_name, email, password, user_role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, UserRole.ADMIN.toString());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public User getById(Integer id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return getUserFromResulSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        List<User> users = new LinkedList<>();
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                User user = getUserFromResulSet(resultSet);
                if (user != null) {
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public void update(User user) {
        String sql = "Update users set name = ?,last_name = ?,email = ? WHERE id = ?";
        try {
            Connection connection = dbProvider.dataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM users WHERE id = " + id;
        try {
            Connection connection = dbProvider.dataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        try {
            Connection connection = dbProvider.dataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getUserFromResulSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            Connection connection = dbProvider.dataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getUserFromResulSet(rs);
            } else {
                System.out.println("No User found with email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeById(Integer userId) {
        String sql = "delete from users where id = " + userId;
        try {
            Connection connection = dbProvider.dataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean userTableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName, null);
        return resultSet.next();
    }

    private void createUsersTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "last_name VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL," +
                "password VARCHAR(255) NOT NULL," +
                "user_role VARCHAR(255) NOT NULL" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        }
    }

    private User getUserFromResulSet(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .lastName(resultSet.getString("last_name"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .userRole(UserRole.valueOf(resultSet.getString("user_role")))
                .build();
    }
}
