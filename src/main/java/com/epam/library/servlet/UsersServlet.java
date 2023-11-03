package com.epam.library.servlet;

import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usersServlet")
public class UsersServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userManager.getAll();
        req.setAttribute("allUsers",allUsers);
        req.getRequestDispatcher("/usersPage").forward(req,resp);
    }
}
