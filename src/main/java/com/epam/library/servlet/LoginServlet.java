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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserManager<Integer, User> userManager;
    public LoginServlet(){
        userManager=new UserManagerImpl();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        String email=req.getParameter("email");
        String password=req.getParameter("password");

        User user=userManager.getByEmailAndPassword(email,password);
        if(user !=null){
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/dashboard").forward(req,resp);
        }
        else{
            req.setAttribute("loginError","The email and password you entered is incorrect");
            req.getRequestDispatcher("/").forward(req,resp);
        }
    }
}
