package com.epam.library.servlets;

import com.epam.library.manager.BookManager;
import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private BookManager<Integer, Book> bookManager;

    public DeleteBookServlet() {
        bookManager = new BookManagerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIdStr = req.getParameter("id");

        if (bookIdStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);
                Book book = bookManager.getById(bookId);

                if (book != null) {
                    req.setAttribute("book", book);

                    req.getRequestDispatcher("/deleteBook.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("/error_404.jsp");
                }
            } catch (NumberFormatException e) {
                resp.sendRedirect("/error_404.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookIdStr = req.getParameter("id");

        if (bookIdStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);
                bookManager.delete(bookId);

                resp.sendRedirect("/deleteBook.jsp");
            } catch (NumberFormatException e) {
                resp.sendRedirect("/error_404.jsp");
            }
        }
    }

}
