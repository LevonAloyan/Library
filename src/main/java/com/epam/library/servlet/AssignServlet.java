package com.epam.library.servlet;

import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/assign")
public class AssignServlet extends GenericServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int selectedBook = Integer.valueOf(req.getParameter("selectedBook"));
        int selectedUser = Integer.valueOf(req.getParameter("selectedUser"));

        User user=userManager.getById(selectedBook);
        if(user != null){
            Book book=bookManager.getById(selectedBook);
            if(book != null && book.getUserId() == 0){
                book.setUserId(selectedUser);
                bookManager.update(book);

                req.setAttribute("successAssign","Successfully assigned !");
                req.getRequestDispatcher("/admin").forward(req,resp);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin").forward(req,resp);
    }
}
