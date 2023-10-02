package com.epam.library.servlets;

import com.epam.library.manager.BookManager;
import com.epam.library.manager.BookManagerImpl;
import com.epam.library.manager.UserManager;
import com.epam.library.manager.UserManagerImpl;
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
public class AdminServlet extends HttpServlet {
    private BookManager bookManager;
    private UserManager<Integer, User> userManager;

    public AdminServlet() {
        bookManager = new BookManagerImpl();
        userManager = new UserManagerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookManager.getAll();
        List<User> users = userManager.getAll();

        req.setAttribute("books", books);
        req.setAttribute("users", users);

        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}