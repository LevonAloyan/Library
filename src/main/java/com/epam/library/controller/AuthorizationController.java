package com.epam.library.controller;


import com.epam.library.model.User;
import com.epam.library.model.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/my-account")
public class AuthorizationController {


    @GetMapping
    public String redirectToDashboard(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            if (user.getUserRole().equals(UserRole.USER)) {
                return "redirect:/userPage";
            } else if (user.getUserRole().equals(UserRole.ADMIN)) {
                return "redirect:/adminPage";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String showUserDashboard() {
        return "userDashboard";
    }

    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String showAdminDashboard() {
        return "adminDashboard";
    }


}
