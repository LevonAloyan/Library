package com.epam.library.servlets;

import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.manager.impl.UserManagerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/my-account/admin")
public class AdminServlet extends GenericServlet {

    public AdminServlet() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        userManager = context.getBean("userManager", UserManagerImpl.class);
        bookManager = context.getBean("bookManager", BookManagerImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userManager.getAll());
        req.setAttribute("books", bookManager.getAll());

        req.getRequestDispatcher("/WEB-INF/adminDashboard.jsp").forward(req, resp);
    }

}
