package com.epam.library.manager.impl;

import com.epam.library.db.DBConnectionProvider;
import com.epam.library.manager.BookManager;
import com.epam.library.manager.UserManager;
import com.epam.library.model.Book;
import com.epam.library.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements BookManager<Integer, Book> {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final UserManager<Integer, User> userManager = new UserManagerImpl();

    @Override
    public Book getById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthorName(resultSet.getString("author_name"));
                book.setUserId(userManager.getById(resultSet.getInt("user_id")));

                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books");
            books = bookList(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void save(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books(book_name, author_name, user_id) VALUES(?,?,?)");
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setInt(3, book.getUserId().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books(book_name, author_name) VALUES(?, ?)");
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getBookName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAssignBooks() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM books where user_id is not null");
            books = bookList(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getMyAssignBooks(int userId) {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM books where user_id=?");
            preparedStatement.setInt(1, userId);
            books = bookList(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


    @Override
    public void update(Book book) {
        if (book != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE books SET book_name=?, author_name=?, user_id=? WHERE id=?"
                );
                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setString(2, book.getAuthorName());

                if (book.getUserId() == null) {
                    preparedStatement.setNull(3, Types.INTEGER);

                } else {
                    preparedStatement.setInt(3, book.getUserId().getId());
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
        connection = DBConnectionProvider.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books where id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllUnassignedBook() {
        connection = DBConnectionProvider.getInstance().getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where user_id is null");
            books = bookList(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    private List<Book> bookList(PreparedStatement ps) throws SQLException {
        ResultSet resultSet = ps.executeQuery();
        List<Book> books = new ArrayList<>();

        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setBookName(resultSet.getString("book_name"));
            book.setAuthorName(resultSet.getString("author_name"));
            book.setUserId(userManager.getById(resultSet.getInt("user_id")));
            books.add(book);
        }
        return books;
    }
}
