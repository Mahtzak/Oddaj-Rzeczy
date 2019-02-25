package com.mahtzak.giveAwayThingsApp.web.controllers;


import com.mahtzak.giveAwayThingsApp.domain.model.User;
import com.mahtzak.giveAwayThingsApp.domain.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomePageController {
    UserRepository userRepository;

    public HomePageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToMainSite(Model model, HttpServletRequest request){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findFirstByEmail(name);
        request.getSession().setAttribute("user", user);



        return "main-site";
    }


}
