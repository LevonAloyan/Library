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
@RequestMapping("/book/unassigned")
public class UnassignedBookController {
    private final UserManagerImpl userManager;
    private final BookManagerImpl bookManager;

    public UnassignedBookController(UserManagerImpl userManager, BookManagerImpl bookManager) {
        this.userManager = userManager;
        this.bookManager = bookManager;
    }

    @GetMapping
    public String showUnassignedBooks(Model model) {
        List<User> users = userManager.getAll();
        List<Book> assignedBooks = bookManager.getAllAssignedBooks();

        model.addAttribute("users", users);
        model.addAttribute("assignedBooks", assignedBooks);

        return "unAssign";
    }

    @PostMapping
    public String unassignedBook(@RequestParam(name = "bookId") Integer bookId, Model model) {
        if (bookId != null) {
            Book book = bookManager.getById(bookId);
            if (book != null) {
                bookManager.unAssign(book);
                List<Book> assignedBooks = bookManager.getAllAssignedBooks();
                model.addAttribute("assignedBooks", assignedBooks);
                model.addAttribute("successUnAssign", "Successfully unAssigned!");
            }
        }
        return "unAssign";
    }
}
