package com.epam.library.servlets;


import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.model.Books;
import com.epam.library.model.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/my-account/user")
public class UserServlet extends GenericServlet {

    public UserServlet() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        bookManager = context.getBean("bookManager", BookManagerImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Users user = (Users) req.getSession().getAttribute("user");
        List<Books> userAllBooks = bookManager.getUserAllBooks(user.getId());
        req.getSession().setAttribute("userAllBooks", userAllBooks);
        req.getRequestDispatcher("/WEB-INF/userDashboard.jsp").forward(req, resp);
    }
}


