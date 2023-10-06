package com.epam.library.servlets;

import com.epam.library.manager.UserManager;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.library.model.UserRole.ADMIN;
import static com.epam.library.model.UserRole.USER;

@WebServlet("/login")
public class LoginServlet extends GenericServlet {

    private UserManager<Integer, User> userManager;

    public LoginServlet() {
        userManager = new UserManagerImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userManager.getByEmailAndPassword(email, password);
        if (user != null){
            req.getSession().setAttribute("user", user);
            if (user.getUserRole() == ADMIN){
                req.getRequestDispatcher("/admin").forward(req, resp);
            }else if (user.getUserRole() == USER) {
                req.getRequestDispatcher("/dashboard").forward(req, resp);
            }
        }else {
            req.setAttribute("loginError","The email and password you entered is not correct.");
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
