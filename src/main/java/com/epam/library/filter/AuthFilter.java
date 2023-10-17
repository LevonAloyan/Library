package com.epam.library.filter;

import com.epam.library.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.library.model.UserRole.ADMIN;
import static com.epam.library.model.UserRole.USER;

@WebFilter(urlPatterns = "/my-account/*")
public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getUserRole().equals(USER)) {
            req.getRequestDispatcher("/userDashboard.jsp").forward(req, res);
        } else if (user.getUserRole().equals(ADMIN)) {
            req.getRequestDispatcher("/adminDashboard.jsp").forward(req, res);
        } else {
            res.sendRedirect("/");
        }
    }
}