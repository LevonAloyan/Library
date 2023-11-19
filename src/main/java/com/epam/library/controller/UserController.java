package com.epam.library.controller;


import com.epam.library.manager.impl.BookManagerImpl;
import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    protected final UserManagerImpl  userManager;
    protected final BookManagerImpl bookManager;

    UserController(UserManagerImpl userManager, BookManagerImpl bookManager) {
        this.userManager = userManager;
        this.bookManager = bookManager;
    }


    @GetMapping("/all")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userManager.getAll());
        return "showAllUsers";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("userId") int userId, Model model) {
        User user = userManager.getById(userId);
        model.addAttribute("user", user);
        return "editUser";
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam("userId") int userId) {
        userManager.removeById(userId);
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String updateUser(@RequestParam("userId") int userId,
                             @RequestParam("name") String name,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email) {
        User user = User.builder()
                .id(userId)
                .name(name)
                .lastName(lastName)
                .email(email)
                .password(userManager.getById(userId).getPassword())
                .build();

        userManager.update(user);
        return "redirect:/users";
    }
}
