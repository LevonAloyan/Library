package com.epam.library.servlets;

import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class ShowUsersListServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users =  userManager.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/usersList").forward(req,resp);

    }
}
