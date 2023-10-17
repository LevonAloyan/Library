package com.epam.library.filter;

import com.epam.library.manager.UserManager;
import com.epam.library.manager.impl.UserManagerImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebFilter(value = "/register")
public class UsernameValidationFilter extends HttpFilter {
    private UserManager userManager = new UserManagerImpl();
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF8");
        String email = req.getParameter("email");
        Matcher matcher = pattern.matcher(email);
        if (userManager.getByEmail(email) != null) {
            req.setAttribute("usernameExistsErr", "Oops !!! Username already exists . ");
            req.getRequestDispatcher("/registerPage").forward(req, res);
        } else if (matcher.matches()) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("emailFormatErr", "Invalid email format . ");
            req.getRequestDispatcher("/registerPage").forward(req, res);
        }
    }
}
