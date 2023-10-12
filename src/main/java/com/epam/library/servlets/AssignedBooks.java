package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/assignedbooks")
public class AssignedBooks extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> assignedbooks = bookManager.getAllUnassignedBook();
        req.setAttribute("assignedbooks", assignedbooks);
        req.getRequestDispatcher("/WEB-INF/assignedBooks.jsp").forward(req, resp);
    }
}
