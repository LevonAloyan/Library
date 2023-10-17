package com.epam.library.servlets;

import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/edit")
public class EditUserServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = userManager.getById(userId);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastName");
        String email = req.getParameter("email");
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(userManager.getById(userId).getPassword());
        user.setConfirmPassword(userManager.getById(userId).getConfirmPassword());
        user.setUserRole(userManager.getById(userId).getUserRole());
        userManager.update(user);
        resp.sendRedirect("/users");
    }
}