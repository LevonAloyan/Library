package com.epam.library.controller;

import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.Book;
import com.epam.library.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/assign")
public class AssignBookController {

    private final UserManagerImpl userManager;
    private final BookManagerImpl bookManager;

    public AssignBookController(UserManagerImpl userManager, BookManagerImpl bookManager) {
        this.userManager = userManager;
        this.bookManager = bookManager;
    }

    @GetMapping
    public String showAssignPage(Model model) {
        List<User> users = userManager.getAll();
        model.addAttribute("users", users);

        List<Book> unassignedBooks = bookManager.getAllUnassignedBooks();
        model.addAttribute("unassignedBooks", unassignedBooks);

        return "assign";
    }

    @PostMapping
    public String assignBook(@RequestParam(name = "selectedUser") Integer selectedUser,
                             @RequestParam(name = "selectedBook") Integer selectedBook,
                             Model model) {
        User user = userManager.getById(selectedUser);
        if (user != null) {
            Book book = bookManager.getById(selectedBook);
            if (book != null && book.getUserId() == 0) {
                book.setUserId(selectedUser);
                bookManager.update(book);
                List<Book> unassignedBooks = bookManager.getAllUnassignedBooks();
                model.addAttribute("unassignedBooks", unassignedBooks);
                model.addAttribute("successAssign", "Successfully assigned!");
            }
        }
        return "assign";
    }
}