package com.epam.library.manager.impl;

import com.epam.library.db.DbConnectionProvider;
import com.epam.library.manager.BookManager;
import com.epam.library.model.Book;
import com.epam.library.model.User;
import com.epam.library.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements BookManager<Integer, Book> {
    Connection connection;

    @Override
    public Book getById(Integer id) {
        connection=DbConnectionProvider.getInstance().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM book WHERE id =?");
            preparedStatement.setInt(1,id);

            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                Book book=new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(resultSet.getInt("user_id"));
                return book;
            }
        }

        catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        connection= DbConnectionProvider.getInstance().getConnection();
        List<Book> books=new ArrayList<>();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM book");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Book book=new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(resultSet.getInt("user_id"));
                books.add(book);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public void save(Book book) {
        connection= DbConnectionProvider.getInstance().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO book(book_name, author_name, user_id) VALUES(?,?,?)");
            preparedStatement.setString(1,book.getBookName());
            preparedStatement.setString(2,book.getAuthorName());
            preparedStatement.setInt(3,book.getUserId());

            int execute=preparedStatement.executeUpdate();
            System.out.println(execute);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
       if(book != null){
           connection=DbConnectionProvider.getInstance().getConnection();
           try{
               PreparedStatement preparedStatement=connection.prepareStatement(
                       "UPDATE book SET book_name=?, author_name=?,user_id=? WHERE id=?"
               );
               preparedStatement.setString(1,book.getBookName());
               preparedStatement.setString(2, book.getAuthorName());
               preparedStatement.setInt(3,book.getUserId());
               preparedStatement.setInt(4,book.getId());
               preparedStatement.executeUpdate();
           }
           catch (SQLException ex){
               ex.printStackTrace();
           }
       }
    }

    @Override
    public void delete(Integer id) {
        connection=DbConnectionProvider.getInstance().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM book WHERE id=?;");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllUnassignedBook() {
        List<Book> books=new ArrayList<>();
        connection= DbConnectionProvider.getInstance().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM book where user_id is null ");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Book book=new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(resultSet.getInt("user_id"));
                books.add(book);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return books;
    }
}
