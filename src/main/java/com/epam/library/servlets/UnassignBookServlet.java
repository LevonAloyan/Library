package com.epam.library.servlets;

import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/unassignBook")
public class UnassignBookServlet extends GenericServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       int bookId = Integer.parseInt(req.getParameter("bookId"));
       Book book = new Book();
       book.setId(bookId);
       bookManager.unassign(book);

        resp.sendRedirect("/showAllAssignedBooks");

    }


}
