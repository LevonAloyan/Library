package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/add")
public class AddBookServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addBookInDB").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("book_name");
        String authorName = req.getParameter("author_name");
        Book book = new Book();
        book.setBookName(name);
        book.setAuthorName(authorName);
        bookManager.addBook(book);

        resp.sendRedirect("/admin");
    }
}
