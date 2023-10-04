package com.epam.library.servlets;

import com.epam.library.manager.BookManager;
import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-book")
public class AddBookServlet extends HttpServlet {
    BookManager<Integer, Book> bookManager = new BookManagerImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String bookName = req.getParameter("bookName");
        String authorName = req.getParameter("authorName");

        Book book = Book.builder()
                .bookName(bookName)
                .authorName(authorName)
                .userId(user.getId())
                .build();

        bookManager.save(book);

        req.setAttribute("bookAddingMsg"," Book has been added to the library..");
        resp.sendRedirect("/my-account/admin");

    }

}
