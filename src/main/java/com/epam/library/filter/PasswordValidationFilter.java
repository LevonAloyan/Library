package com.epam.library.filter;

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
public class PasswordValidationFilter extends HttpFilter {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF8");
        String password = req.getParameter("password");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("passwordErrMsg", "Invalid password format. Please try again! ");
            req.getRequestDispatcher("/registerPage").forward(req, res);
        }
    }
}
