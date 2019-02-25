package com.mahtzak.giveAwayThingsApp.web.controllers;


import com.mahtzak.giveAwayThingsApp.domain.model.User;
import com.mahtzak.giveAwayThingsApp.domain.model.UserDetails;
import com.mahtzak.giveAwayThingsApp.domain.repository.UserDetailsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user/details")
public class UserDetailsController {

    UserDetailsRepository userDetailsRepository;

    public UserDetailsController(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @GetMapping
    public String goToDetailsForm(Model model, HttpSession session){

        UserDetails userDetails = userDetailsRepository.findFirstByUser((User)session.getAttribute("user"));
        if (userDetails != null) {
            model.addAttribute("userDetails", userDetails);
        } else {
            model.addAttribute("userDetails", new UserDetails());
        }
        return "user-details-form";
    }

    @PostMapping
    public String editUserDetails(@ModelAttribute(name="userDetails") @Valid UserDetails userDetails,
                                  BindingResult result,
                                  @SessionAttribute(name = "user") User user){
        if (result.hasErrors()){
            return "user-details-form";
        }

        UserDetails existingDetails = userDetailsRepository.findFirstByUser(user);
        if (existingDetails == null){
            userDetails.setUser(user);
            userDetails.setBags(0);
            userDetails.setFundraisers(0);
            userDetails.setOrganisations(0);
            userDetailsRepository.save(userDetails);
        }else {
            userDetailsRepository.updateUserDetailsFromForm(userDetails.getFirstName(),
                    userDetails.getLastName(),userDetails.getAddress(),
                    userDetails.getPhoneNumber(),user.getId());
        }
       return "main-site";
    }
}
