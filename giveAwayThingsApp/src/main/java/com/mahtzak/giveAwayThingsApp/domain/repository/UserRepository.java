package com.mahtzak.giveAwayThingsApp.domain.repository;


import com.mahtzak.giveAwayThingsApp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{


    //wyszukiwanie użytkownika po emailu
    User findFirstByEmail(String email);

    //wyszukiwanie użytkownika po nazwie użytkownika
    User findFirstByUsername(String username);
}
