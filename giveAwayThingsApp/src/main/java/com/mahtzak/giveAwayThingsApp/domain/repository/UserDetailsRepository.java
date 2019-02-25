package com.mahtzak.giveAwayThingsApp.domain.repository;

import com.mahtzak.giveAwayThingsApp.domain.model.User;
import com.mahtzak.giveAwayThingsApp.domain.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDetailsRepository extends JpaRepository <UserDetails,Long> {

    UserDetails findFirstByUser(User user);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,
    value="update user_details ud set first_name=?1, last_name=?2, " +
            "address = ?3, phone_number = ?4 where user_id = ?5")
    void updateUserDetailsFromForm(String firstName, String lastName,
                                   String address, String phoneNumber, Long id);

}
