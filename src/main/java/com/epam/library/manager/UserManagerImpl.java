package com.epam.library.manager;

import com.epam.library.db.DbConnectionProvider;
import com.epam.library.model.User;
import com.epam.library.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserManagerImpl implements UserManager<Integer, User> {
    private Connection connection;
    @Override
    public User getById(Integer integer) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {
        connection= DbConnectionProvider.getInstance().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO user(name, last_name,email, password, user_role) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setObject(5,user.getRole());
            int execute=preparedStatement.executeUpdate();
            System.out.println(execute);
            System.out.println(execute);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Integer entity) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        connection=DbConnectionProvider.getInstance().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM user where email=? and password=?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                User user=new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole((UserRole) resultSet.getObject("user_role"));
                return user;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(String.format("Given user with email: %s not found",email,password));
        }
        return null;
    }
}
