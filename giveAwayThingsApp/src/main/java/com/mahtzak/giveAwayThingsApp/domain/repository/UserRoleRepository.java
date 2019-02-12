package com.mahtzak.giveAwayThingsApp.domain.repository;

import com.mahtzak.giveAwayThingsApp.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
