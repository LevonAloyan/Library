package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editBook")
public class EditBookServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");

        Book book = bookManager.getById(Integer.valueOf(bookId));
        if (book != null) {
            req.setAttribute("bookToEdit", book);
            req.getRequestDispatcher("/WEB-INF/editBook.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bookId = req.getParameter("book_id");
        String bookName = req.getParameter("book_name");
        String authorName = req.getParameter("author_name");

        Book book = bookManager.getById(Integer.valueOf(bookId));
        if (book != null) {
            book.setBookName(bookName);
            book.setAuthorName(authorName);
            bookManager.update(book);
        }

        resp.sendRedirect("/books");
    }
}
