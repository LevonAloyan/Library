package com.epam.library.controller;

import com.epam.library.manager.impl.UserManagerImpl;
import com.epam.library.model.User;
import com.epam.library.model.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/register")
public class RegisterController {

    protected final UserManagerImpl userManager;

    RegisterController(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    @GetMapping
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute User user, Model model, String password, String confirmPassword) throws IOException {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("passwordMatchError", "Password did not match with confirm password");
            return "register";
        }

        userManager.save(user);

        return "redirect:/";
    }

}
