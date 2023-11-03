package com.epam.library.servlet;

import com.epam.library.manager.UserManager;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.library.model.UserRole.ADMIN;
import static com.epam.library.model.UserRole.USER;


@WebServlet("/login")
public class LoginServlet extends GenericServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        String email=req.getParameter("email");
        String password=req.getParameter("password");

        User user=userManager.getByEmailAndPassword(email,password);
        if(user !=null){
            req.getSession().setAttribute("user",user);

            if(user.getRole()==ADMIN){
                resp.sendRedirect("/admin");
                // req.getRequestDispatcher("/admin").forward(req,resp);
            }
            else if (user.getRole()==USER) {
                req.getRequestDispatcher("/dashboard").forward(req,resp);
            }
        }
        else{
            req.setAttribute("loginError","The email and password you entered is incorrect");
            req.getRequestDispatcher("/").forward(req,resp);
        }
    }
}
