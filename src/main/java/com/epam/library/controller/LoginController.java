package com.epam.library.controller;

import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {

    protected final UserManagerImpl userManager;

    LoginController(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    @GetMapping
    protected String showLoginPage() {
        return "login";
    }

    @PostMapping
    protected String processLogin(@ModelAttribute("user") User user, Model model) {
        if (user != null) {
            user = userManager.getByEmailAndPassword(user.getEmail(), user.getPassword());
            model.addAttribute("user", user);
            return "redirect:/my-account/adminPage";
        } else {
            model.addAttribute("loginError", "The email and password you entered is not correct.");
            return "login";
        }
    }
}
