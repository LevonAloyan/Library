package com.epam.library.manager.impl;

import com.epam.library.db.DBConnectionProvider;
import com.epam.library.manager.UserManager;
import com.epam.library.model.User;
import com.epam.library.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import static com.epam.library.model.UserRole.USER;

@SuppressWarnings("SqlResolve")
public class UserManagerImpl implements UserManager<Integer, User> {

    @Override
    public User getById(Integer id) {
        String getUserQuery = "SELECT * FROM users WHERE id = " + id;
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(getUserQuery)) {
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return getUserFromResulSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        String getUsersQuery = "SELECT * FROM  users where user_role = 'USER'";
        List<User> users = new LinkedList<>();
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(getUsersQuery)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                users.add(getUserFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public void save(User user) {
        String saveUserQuery = "INSERT INTO users(name, last_name, email, password, confirm_password, user_role) VALUES(?,?,?,?,?,CAST(? AS user_role))";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveUserQuery)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getConfirmPassword());
            preparedStatement.setString(6, USER.name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String updateUserQuery = "Update users SET name = ?, last_name = ?, email = ? WHERE id = ?";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(updateUserQuery, Statement.RETURN_GENERATED_KEYS)) {
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
        String deleteUserQuery = "DELETE FROM users WHERE id = " + id;
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(deleteUserQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        String checkUserCredQuery = "SELECT * FROM users where email=? and password=?";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(checkUserCredQuery)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return getUserFromResulSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Given user with email: %s and password %s not found", email, password));
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        String getUserByEmail = "SELECT * FROM users WHERE email = ?";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(getUserByEmail)) {
            ps.setString(1, email);
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
    public void removeById(Integer userId) {
        String removeUserById = "delete from users where id = " + userId;
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(removeUserById)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUserFromResulSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
        return user;
    }

}
