package com.epam.library.filter;

import com.epam.library.model.User;
import com.epam.library.model.UserRole;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin")
public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getUserRole() == UserRole.ADMIN) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/error_403");
        }
    }
}
