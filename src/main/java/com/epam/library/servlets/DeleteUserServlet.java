package com.epam.library.servlets;

import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUsers")
public class DeleteUserServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");

        if (userId != null && !userId.isEmpty()) {
            userManager.delete(Integer.valueOf(userId));
            resp.sendRedirect("/deleteUser");
        }
    }

}