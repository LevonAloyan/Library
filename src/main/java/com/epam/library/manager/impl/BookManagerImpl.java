package com.epam.library.manager.impl;

import com.epam.library.db.DBConnectionProvider;
import com.epam.library.manager.BookManager;
import com.epam.library.manager.UserManager;
import com.epam.library.model.Book;
import com.epam.library.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("SqlResolve")
public class BookManagerImpl implements BookManager<Integer, Book> {

    private final UserManager<Integer, User> userManager = new UserManagerImpl();

    @Override
    public Book getById(Integer id) {
        String sql = "SELECT * FROM book  WHERE id = " + id;
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getBookFromResulSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        String sql = "SELECT * FROM book ";
        List<Book> books = new LinkedList<>();
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(getBookFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return books;
    }

    @Override
    public void save(Book book) {
        String saveBookQuery = "INSERT INTO book(book_name, author_name, user_id) VALUES(?,?,?)";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveBookQuery)) {
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setInt(3, book.getUserId().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        String updateBookQuery = "UPDATE book SET book_name=?, author_name=?, user_id=? WHERE id=?";
        if (book != null) {
            try (Connection connection = DBConnectionProvider.getInstance().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(updateBookQuery)) {
                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setString(2, book.getAuthorName());
                preparedStatement.setInt(3, book.getUserId().getId());
                preparedStatement.setInt(4, book.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer bookId) {
        String sql = "Delete from book where id = " + bookId;
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllUnassignedBooks() {
        List<Book> books = new ArrayList<>();
        String unassignedBooksQuery = "SELECT * FROM book where user_id is null";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(unassignedBooksQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(getBookFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getAllAssignedBooks() {
        List<Book> books = new ArrayList<>();
        String allAssignedBooks = "SELECT * FROM book where user_id is not null";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(allAssignedBooks)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(getBookFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void delete(Integer bookId, Integer userId) {
        String deleteBookQuery = "delete from book where id = ? AND user_id = ?";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteBookQuery)) {
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unAssign(Book book) {
        String unAssignBookQuery = "UPDATE book SET user_id = NULL WHERE id = ?";
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(unAssignBookQuery)) {
            preparedStatement.setInt(1, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getBookByUserId(Integer userId) {
        String bookByUserIdQuery = "SELECT * FROM book  WHERE user_id = " + userId;
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(bookByUserIdQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getBookFromResulSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getUsersAllBooks(Integer userId) {
        String usersAllBooksQuery = "SELECT id, book_name, author_name FROM Book WHERE user_id = ?";
        List<Book> books = new LinkedList<>();
        try (Connection connection = DBConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(usersAllBooksQuery)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(getBookFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return books;
    }

    private Book getBookFromResulSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setBookName(resultSet.getString("book_name"));
        book.setAuthorName(resultSet.getString("author_name"));
        book.setUserId(userManager.getById(resultSet.getInt("user_id")));
        return book;
    }
}
