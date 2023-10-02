package com.epam.library.servlets;

import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends GenericServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userManager.getAll();
        req.getSession().setAttribute("users", users);

        List<Book> unassignedBooks = bookManager.getAllUnassignedBook();
        req.getSession().setAttribute("unassignedBooks", unassignedBooks);

        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userManager.getAll();
        req.getSession().setAttribute("users", users);

        List<Book> unassignedBooks = bookManager.getAllUnassignedBook();
        req.getSession().setAttribute("unassignedBooks", unassignedBooks);
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}
