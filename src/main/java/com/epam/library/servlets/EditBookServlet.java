package com.epam.library.servlets;

import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editBooks")
public class EditBookServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookId = req.getParameter("bookId");

        Book book = bookManager.getById(Integer.valueOf(bookId));
        if (book != null) {

            req.setAttribute("bookToEdit", book);
            req.getRequestDispatcher("WEB-INF/editBooks.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        String authorName = req.getParameter("authorName");
        String bookId = req.getParameter("bookId");

        Book book = bookManager.getById(Integer.valueOf(bookId));
        if (book != null) {
            book.setBookName(bookName);
            book.setAuthorName(authorName);
            bookManager.update(book);
        }

        resp.sendRedirect("/allBooks");
}
}