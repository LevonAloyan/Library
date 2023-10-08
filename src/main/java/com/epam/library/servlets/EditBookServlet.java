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

        String bookIdStr = req.getParameter("id");

        if (bookIdStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);

                Book book = bookManager.getById(bookId);
                if (book != null) {

                    req.setAttribute("book", book);
                    req.getRequestDispatcher("/editBook.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("/bookNotFound.jsp");
                }
            } catch (NumberFormatException e) {

                resp.sendRedirect("/invalidBookId.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIdStr = req.getParameter("id");

        if (bookIdStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);

                Book book = bookManager.getById(bookId);

                if (book != null) {
                    String newName = req.getParameter("newName");
                    String newAuthor = req.getParameter("newAuthor");

                    book.setBookName(newName);
                    book.setAuthorName(newAuthor);
                    bookManager.update(book);

                    resp.sendRedirect("/editBook.jsp");
                } else {
                    resp.sendRedirect("/error_404.jsp");
                }
            } catch (NumberFormatException e) {
                resp.sendRedirect("/error_404.jsp");
            }
        }
    }
}