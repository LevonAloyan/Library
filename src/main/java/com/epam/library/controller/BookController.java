package com.epam.library.controller;


import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.Book;
import com.epam.library.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {


    private final BookManagerImpl bookManager;
    private final UserManagerImpl userManager;


    public BookController(BookManagerImpl bookManager, UserManagerImpl userManager) {
        this.bookManager = bookManager;
        this.userManager = userManager;
    }

    @GetMapping
    public String showForm() {
        return "adminDashboard";
    }

    @GetMapping("/all")
    public String showAllBooks(Model model) {
        model.addAttribute("users", userManager.getAll());
        model.addAttribute("books", bookManager.getAll());
        return "showAllBooks";
    }


    @GetMapping("/remove")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookManager.delete(bookId);
        return "redirect:/books";
    }


    @GetMapping("/edit")
    public String showEditForm(@RequestParam("bookId") int bookId, Model model) {
        Book book = bookManager.getById(bookId);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book,
                          Model model) {

        User user = (User) model.getAttribute("user");

        bookManager.save(book);

        model.addAttribute("bookAddingMsg", "Book has been added to the library.");
        model.addAttribute("user", user);

        return "adminDashboard";
    }

//    @PostMapping("/edit")
//    public String editBook(@RequestParam("bookId") int bookId,
//                           @RequestParam("bookName") String bookName,
//                           @RequestParam("authorName") String authorName) {
//        Book book = Book.builder()
//                .id(bookId)
//                .bookName(bookName)
//                .authorName(authorName)
//                .build();
//        bookManager.update(book);
//        return "redirect:/books";
//    }

}
