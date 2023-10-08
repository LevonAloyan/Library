package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteBook")
public class DeleteBookServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIdStr = req.getParameter("id");

        if (bookIdStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);
                Book bookToDelete = bookManager.getById(bookId);
                if (bookToDelete != null) {
                    bookManager.delete(bookId);

                    resp.sendRedirect("/deleteBook.jsp");
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
        doGet(req,resp);
    }
}
