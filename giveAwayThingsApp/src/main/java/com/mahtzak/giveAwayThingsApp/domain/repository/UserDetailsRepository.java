package com.mahtzak.giveAwayThingsApp.domain.repository;

import com.mahtzak.giveAwayThingsApp.domain.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository <UserDetails,Long> {


}
