package com.epam.library.servlets;

import com.epam.library.model.Book;
import com.epam.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/booklist")
public class BooksServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookManager.getAll();
        req.getSession().setAttribute("books", books);
        req.getRequestDispatcher("/WEB-INF/booklist.jsp").forward(req, resp);
    }
}
