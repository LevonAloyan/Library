package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/unAssingnBook")
public class UnAssignBookServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        Book book = bookManager.getById(Integer.valueOf(bookId));
        if (book != null && book.getUserId() != 0){
            book.setId(0);
            bookManager.update(book);
            req.setAttribute("unassignSuccess", "Successfully Unassigned!");
        }else {
            req.setAttribute("unassignError", "Book is already unassigned or does not exist!");
        }
        req.getRequestDispatcher("/WEB-INF/assignedbooks.jsp");
    }
}
