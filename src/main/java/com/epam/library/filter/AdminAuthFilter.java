package com.epam.library.filter;

import com.epam.library.model.UserRole;
import com.epam.library.model.Users;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/add-book", "/assign", "/book/edit", "/user/edit", "/book/remove", "/user/remove", "/users"})
public class AdminAuthFilter extends HttpFilter {


    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        Users user = (Users) request.getSession().getAttribute("user");

        if (user != null || user.getUserRole() == UserRole.ADMIN) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("/error_403");
        }
    }
}