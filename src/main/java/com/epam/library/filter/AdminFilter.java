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

@WebFilter(urlPatterns = {"/add-book", "/assign", "/book/edit", "/user/edit", "/book/remove", "/user/remove", "/users"})
public class AdminFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || user.getUserRole() != ADMIN) {
            response.sendRedirect("/");
        } else {
            chain.doFilter(request, response);
        }
    }
}