package com.mahtzak.giveAwayThingsApp.core;

import com.mahtzak.giveAwayThingsApp.domain.model.User;
import com.mahtzak.giveAwayThingsApp.domain.model.UserDetails;
import com.mahtzak.giveAwayThingsApp.domain.model.UserRole;
import com.mahtzak.giveAwayThingsApp.domain.repository.UserDetailsRepository;
import com.mahtzak.giveAwayThingsApp.domain.repository.UserRepository;
import com.mahtzak.giveAwayThingsApp.domain.repository.UserRoleRepository;
import com.mahtzak.giveAwayThingsApp.web.dtos.RegistrationFormDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class RegistrationService {

    PasswordEncoder passwordEncoder;
    UserRepository  userRepository;
    UserRoleRepository userRoleRepository;
    UserDetailsRepository userDetailsRepository;

    public RegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                               UserRoleRepository userRoleRepository, UserDetailsRepository userDetailsRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    public boolean register (RegistrationFormDTO form){
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        //szyfrowanie hasla
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        //zapisujemy do bazy danych, dzieki zapisaniu usera mozemy go ustawic w innych tabelach gdzie wystepuje...
        user = userRepository.save(user);

        //tworzenie user_role dla usera
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");
        userRole.setUser(user);
        userRoleRepository.save(userRole);

        //tworzenie szczegolow uzytkownika dla danego usera
        /*UserDetails userDetails = new UserDetails();
        userDetails.setUser(user);
        userDetailsRepository.save(userDetails);*/


        return true;
    }
}
