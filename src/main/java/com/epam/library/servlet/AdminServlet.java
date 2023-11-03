package com.epam.library.servlet;

import com.epam.library.manager.BookManager;
import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.manager.UserManager;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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

        List<Book> books = bookManager.getAllUnassignedBook();
        req.getSession().setAttribute("unassignedBooks", books);

        req.getRequestDispatcher("/adminPage").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userManager.getAll();
        req.getSession().setAttribute("users", users);

        List<Book> books = bookManager.getAllUnassignedBook();
        req.getSession().setAttribute("unassignedBooks", books);

        req.getRequestDispatcher("/adminPage").forward(req,resp);
    }
}
