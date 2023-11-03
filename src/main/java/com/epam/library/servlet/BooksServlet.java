package com.epam.library.servlet;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BooksServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books=bookManager.getAll();
        req.setAttribute("allBooks",books);
        req.getRequestDispatcher("bookList.jsp").forward(req,resp);
    }
}
