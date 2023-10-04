package com.epam.library.filter;

import com.epam.library.model.User;
import com.epam.library.model.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/add-book", "/assign", "/book/edit", "/user/edit", "/book/remove", "/user/remove", "/users"})
public class AdminFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        User user = (User) req.getSession().getAttribute("user");

        if (user == null || user.getUserRole() != UserRole.ADMIN) {
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect("/");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


}