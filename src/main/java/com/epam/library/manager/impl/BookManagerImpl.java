package com.epam.library.manager.impl;

import com.epam.library.db.DBProvider;
import com.epam.library.manager.BookManager;
import com.epam.library.model.Book;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component("bookManager")
public class BookManagerImpl implements BookManager<Integer, Book> {

    private final DBProvider dbProvider;

    public BookManagerImpl(DBProvider dbProvider) {
        this.dbProvider = dbProvider;
    }


    @Override
    public Book getById(Integer id) {
        String sql = "SELECT * FROM books  WHERE id = " + id;
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return getBooksFromResulSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Book> getAll() {
        String sql = "SELECT * FROM books";
        List<Book> books = new LinkedList<>();
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Book book = getBooksFromResulSet(resultSet);
                if (book != null) {
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return books;
    }

    @Override
    public void save(Book book) {
        try (Connection connection = dbProvider.dataSource().getConnection()) {
            if (!bookTableExists(connection, "books")) {
                createBooksTable(connection);
            }
            String sql = "INSERT INTO books (book_name, author_name) VALUES(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, book.getBookName());
                ps.setString(2, book.getAuthorName());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Book book) {
        if (book != null) {
            try {
                try (Connection connection = dbProvider.dataSource().getConnection()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE books SET book_name=?, author_name=?, user_id=? WHERE id=?"
                    );
                    preparedStatement.setString(1, book.getBookName());
                    preparedStatement.setString(2, book.getAuthorName());
                    preparedStatement.setInt(3, book.getUserId());
                    preparedStatement.setInt(4, book.getId());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(Integer bookId) {
        String sql = "Delete from books where id = " + bookId;
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Book> getAllUnassignedBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = dbProvider.dataSource().getConnection()) {
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
    public List<Book> getAllAssignedBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = dbProvider.dataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where user_id is not null");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                books.add(getBooksFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void delete(Integer bookId, Integer userId) {
        String sql = "delete from books where id = ? AND user_id = ?";
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, bookId);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unAssign(Book book) {
        String sql = "UPDATE books SET user_id = NULL WHERE id = ?";
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getByUserId(Integer userId) {
        String sql = "SELECT * FROM books  WHERE user_id = " + userId;
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return getBooksFromResulSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Book> getUserAllBooks(Integer userId) {
        String sql = "SELECT book_name, author_name FROM books WHERE user_id = ?";
        List<Book> books = new LinkedList<>();
        try (Connection connection = dbProvider.dataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                books.add(getBooksFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return books;
    }


    private boolean bookTableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName, null);
        return resultSet.next();
    }


    private void createBooksTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE books (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "book_name VARCHAR(255) NOT NULL," +
                "author_name VARCHAR(255) NOT NULL," +
                "user_id INT" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        }
    }


    private Book getBooksFromResulSet(ResultSet resultSet) throws SQLException {
        return Book.builder()
                .id(resultSet.getInt("id"))
                .bookName(resultSet.getString("book_name"))
                .authorName(resultSet.getString("author_name"))
                .build();
    }
}
