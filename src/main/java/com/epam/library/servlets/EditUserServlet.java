package com.epam.library.servlets;

import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editUsers")
public class EditUserServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");

        User user = userManager.getById(Integer.valueOf(userId));
        if (user != null) {
            req.setAttribute("userToEdit", user);
            req.getRequestDispatcher("/WEB-INF/editUser.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
       String userId= req.getParameter("userId");

       User user = userManager.getById(Integer.valueOf(userId));
       if(user !=null){
           user.setName(name);
           user.setLastName(lastName);
           user.setEmail(email);
           userManager.update(user);
       }

       resp.sendRedirect("/users");
    }
}
