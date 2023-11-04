package com.epam.library.manager.impl;

import com.epam.library.db.DBConnectionProvider;
import com.epam.library.manager.BookManager;
import com.epam.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("bookManager")
public class BookManagerImpl implements BookManager<Integer, Book> {
    @Autowired
    private DBConnectionProvider dbConnectionProvider;

    private Connection connection;

    @Override
    public Book getById(Integer id) {
        connection = dbConnectionProvider.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(resultSet.getInt("user_id"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        connection = dbConnectionProvider.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(resultSet.getInt("user_id"));
                book.setUserId(resultSet.getInt("user_id"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void save(Book book) {
        connection = dbConnectionProvider.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books(book_name, author_name, user_id) VALUES(?,?,?)");
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setInt(3, book.getUserId());
            int execute = preparedStatement.executeUpdate();
            System.out.println(execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        if (book != null) {
            connection = dbConnectionProvider.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE books SET book_name=?, author_name=?, user_id=? WHERE id=?"
                );
                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setString(2, book.getAuthorName());
                if (book.getUserId() == 0) {
                    preparedStatement.setNull(3, book.getUserId());
                } else {
                    preparedStatement.setInt(3, book.getUserId());
                }
                preparedStatement.setInt(4, book.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        connection = dbConnectionProvider.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books where id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void unassign(Book book) {
        connection = dbConnectionProvider.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE books SET user_id = NULL WHERE id = ?;");
            statement.setInt(1, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllUnassignedBook() {
        connection = dbConnectionProvider.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where user_id is null");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(resultSet.getInt("user_id"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getAllAssignedBook() {
        connection = dbConnectionProvider.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where user_id is not null");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(resultSet.getInt("user_id"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
