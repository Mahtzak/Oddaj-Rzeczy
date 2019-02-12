package com.mahtzak.giveAwayThingsApp.web.controllers;


import com.mahtzak.giveAwayThingsApp.domain.model.User;
import com.mahtzak.giveAwayThingsApp.domain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login-form";
    }
}
