package com.epam.library.servlets;

import com.epam.library.manager.UserManager;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private UserManager<Integer, User> userManager;

    public DeleteUserServlet() {
        userManager = new UserManagerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("id");

        if (userIdStr != null) {
            try {
                int userId = Integer.parseInt(userIdStr);

                User user = userManager.getById(userId);
                if (user != null) {
                    req.setAttribute("user", user);

                    req.getRequestDispatcher("/deleteUser.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("/error_404.jsp");
                }
            } catch (NumberFormatException e) {
                resp.sendRedirect("/error_404.jsp");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("id");

        if (userIdStr != null) {
            try {
                int userId = Integer.parseInt(userIdStr);

                userManager.delete(userId);
                resp.sendRedirect("/deleteUser.jsp");

            } catch (NumberFormatException e) {
                resp.sendRedirect("/error_404.jsp");
            }
        }
    }
}