package com.epam.library.servlets;

import com.epam.library.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editUser")
public class EditUserServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User selectedUser = userManager.getById(userId);
        req.setAttribute("user", selectedUser);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/userEdit.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(userManager.getById(userId).getPassword());

        userManager.update(user);

        resp.sendRedirect("/showAllUsers");
    }
}
