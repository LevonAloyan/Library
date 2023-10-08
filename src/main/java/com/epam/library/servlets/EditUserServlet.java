package com.epam.library.servlets;

import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editUser")
public class EditUserServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");

        if (userId != null) {
            userManager.getById(Integer.valueOf(userId));

            User userToEdit = userManager.getById(Integer.valueOf(userId));
            if (userToEdit != null) {
                req.getSession().setAttribute("user", userToEdit);
                req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("error_404");
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("id");

        if (userIdStr != null) {
            try {
                int userId = Integer.parseInt(userIdStr);
                User user = userManager.getById(userId);

                if (user != null) {
                    String newName = req.getParameter("newName");
                    String newLastName = req.getParameter("newLastName");

                    user.setName(newName);
                    user.setLastName(newLastName);
                    userManager.update(user);

                    resp.sendRedirect("/allUsers.jsp");
                } else {
                    resp.sendRedirect("/error_404.jsp");
                }
            } catch (NumberFormatException e) {
                resp.sendRedirect("/error_404.jsp");
            }
        }
    }
}
