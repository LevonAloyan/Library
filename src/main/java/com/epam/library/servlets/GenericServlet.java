package com.epam.library.servlets;

import com.epam.library.config.AppConfig;
import com.epam.library.manager.BookManager;
import com.epam.library.manager.UserManager;
import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.Book;
import com.epam.library.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class GenericServlet extends HttpServlet {

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    protected UserManager<Integer, User> userManager;
    protected BookManager<Integer, Book> bookManager;

    public GenericServlet() {
        userManager = context.getBean(UserManagerImpl.class);
        bookManager = context.getBean(BookManagerImpl.class);

    }
}
