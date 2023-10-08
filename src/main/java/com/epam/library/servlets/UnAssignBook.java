package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/unAssignBook")
public class UnAssignBook extends GenericServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookIdStr = req.getParameter("bookId");
        if (bookIdStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);
                Book book = bookManager.getById(bookId);

                if (book != null) {
                    book.setUserId(0);
                    bookManager.update(book);
                    resp.sendRedirect("/assignedBooks.jsp");
                } else {
                    resp.sendRedirect("/error_404.jsp");
                }
            } catch (NumberFormatException e) {
                resp.sendRedirect("/error_404.jsp");
            }
        }
    }

}
