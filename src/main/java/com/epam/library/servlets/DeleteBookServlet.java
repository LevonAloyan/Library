package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteBooks")
public class DeleteBookServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
            bookManager.delete(bookId);
            resp.sendRedirect("/allBooks");
        }

    }






