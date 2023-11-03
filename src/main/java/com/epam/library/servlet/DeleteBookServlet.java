package com.epam.library.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBooks")
public class DeleteBookServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId=req.getParameter("bookId");
        if(bookId!=null && !bookId.isEmpty()){
            bookManager.delete(Integer.valueOf(bookId));
        }
        resp.sendRedirect("/book");
    }
}
