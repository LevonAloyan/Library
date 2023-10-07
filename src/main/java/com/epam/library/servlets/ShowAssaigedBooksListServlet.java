package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllAssignedBooks")

public class ShowAssaigedBooksListServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> assignedBooks =  bookManager.getAllAssignedBook();
        req.setAttribute("assignedBooks", assignedBooks);
        req.getRequestDispatcher("/WEB-INF/showAssignedBooksList.jsp").forward(req,resp);

    }
}
