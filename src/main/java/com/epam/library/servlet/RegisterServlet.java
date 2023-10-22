package com.epam.library.servlet;

import com.epam.library.manager.UserManager;
import com.epam.library.manager.UserManagerImpl;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    public UserManager userManager;

    public RegisterServlet(){
        userManager=new UserManagerImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            req.setAttribute("passwordMatchError", "Password did not match with confirm password");
            req.getRequestDispatcher("/registerPage").forward(req, resp);
            return;
        }

        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setConfirmPassword(confirmPassword);

        userManager.save(user);

        req.getRequestDispatcher("/").forward(req,resp);
    }

}
