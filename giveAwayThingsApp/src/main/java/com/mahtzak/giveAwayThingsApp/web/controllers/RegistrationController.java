package com.mahtzak.giveAwayThingsApp.web.controllers;


import com.mahtzak.giveAwayThingsApp.core.RegistrationService;
import com.mahtzak.giveAwayThingsApp.domain.model.User;
import com.mahtzak.giveAwayThingsApp.domain.repository.UserRepository;
import com.mahtzak.giveAwayThingsApp.web.dtos.RegistrationFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    UserRepository userRepository;
    RegistrationService registrationService;

    public RegistrationController(UserRepository userRepository, RegistrationService registrationService) {
        this.userRepository = userRepository;
        this.registrationService = registrationService;
    }

    @GetMapping
    public String goToRegistration(Model model){
        model.addAttribute("user", new RegistrationFormDTO());
        return "register-form";
    }

    @PostMapping
    public String registerUser(@ModelAttribute(name="user") @Valid RegistrationFormDTO user,
                               BindingResult result) {

        if(result.hasErrors()){
            return "register-form";
        }
        User userByEmail = userRepository.findFirstByEmail(user.getEmail());
        User userByUsername = userRepository.findFirstByUsername(user.getUsername());

        if (userByEmail != null || userByUsername != null ||
                !user.getPassword().equals(user.getConfirmedPassword())) {
            if (userByEmail != null) {
                result.rejectValue("email", null,
                        "Podany email już istnieje w bazie");
            }
            if (userByUsername != null) {
                result.rejectValue("username", null,
                        "Podana nazwa użytkownika jest już zajęta");
            }
            if (!user.getPassword().equals(user.getConfirmedPassword())) {
                result.rejectValue("confirmedPassword", null,
                        "Nie powtórzono poprawnie hasła");
            }
            return "register-form";
        }

        boolean success = registrationService.register(user);
        if (success) {
            return "redirect:/login";
        } else {
            result.rejectValue("email", null, "Coś poszło nie tak. Spróbuj ponownie");
            return "register-form";
        }
    }

    }
