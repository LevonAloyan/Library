package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editBook")
public class EditBookServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        Book selectedBook= bookManager.getById(bookId);
        req.setAttribute("book", selectedBook);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bookEdit.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));

        String bookName = req.getParameter("name");
        String authorName = req.getParameter("authorName");
        int userId = Integer.parseInt(req.getParameter("userId"));

        Book book = new Book();
        book.setId(bookId);
        book.setBookName(bookName);
        book.setAuthorName(authorName);
        book.setUserId(userId);

        bookManager.update(book);

        resp.sendRedirect("/books");
    }
}
