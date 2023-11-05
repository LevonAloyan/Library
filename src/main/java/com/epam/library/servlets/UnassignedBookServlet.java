package com.epam.library.servlets;

import com.epam.library.model.Books;
import com.epam.library.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book/unassigned")
public class UnassignedBookServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> users = userManager.getAll();
        List<Books> assignedBooks = bookManager.getAllAssignedBooks();

        req.getSession().setAttribute("users", users);
        req.getSession().setAttribute("assignedBooks", assignedBooks);
        req.getRequestDispatcher("/WEB-INF/unAssign.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer selectedBook = Integer.valueOf(req.getParameter("bookId"));
        Books book = bookManager.getById(selectedBook);
        if (book != null) {
            bookManager.unAssign(book);
            List<Books> assignedBooks = bookManager.getAllAssignedBooks();
            req.getSession().setAttribute("assignedBooks", assignedBooks);
            req.setAttribute("successUnAssign", "Successfully unAssigned!");
            req.getRequestDispatcher("/WEB-INF/unAssign.jsp").include(req, resp);
        }
    }
}
