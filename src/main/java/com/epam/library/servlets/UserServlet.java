package com.epam.library.servlets;

import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class UserServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        User byEmail = userManager.getByEmail(user.getEmail());

        if (byEmail != null) {
            List<Book> myAssignBooks = bookManager.getMyAssignBooks(byEmail.getId());
            req.getSession().setAttribute("myAssignedBooks", myAssignBooks);
            req.getRequestDispatcher("/WEB-INF/userdashboard.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/WEB-INF/userdashboard.jsp").forward(req, resp);
    }
}
