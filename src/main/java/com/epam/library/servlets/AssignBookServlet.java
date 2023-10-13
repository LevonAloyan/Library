package com.epam.library.servlets;

import com.epam.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/assign_books")
public class AssignBookServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> assignBooks = bookManager.getAssignBooks();

        req.setAttribute("assignBooks", assignBooks);
        req.getRequestDispatcher("/WEB-INF/assignedbooks.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bookId = req.getParameter("book_id");

        Book book = bookManager.getById(Integer.valueOf(bookId));
        if (book != null) {
            book.setUserId(null);
            bookManager.update(book);
        }

        resp.sendRedirect("/assign_books");
    }
}
