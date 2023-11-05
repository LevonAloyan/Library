package com.epam.library.servlets;

import com.epam.library.manager.BookManager;
import com.epam.library.manager.UserManager;
import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.Books;
import com.epam.library.model.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServlet;

public class GenericServlet extends HttpServlet {
    protected UserManager<Integer, Users> userManager;
    protected BookManager<Integer, Books> bookManager;

    GenericServlet() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        userManager = context.getBean("userManager", UserManagerImpl.class);
        bookManager = context.getBean("bookManager", BookManagerImpl.class);
    }
}
