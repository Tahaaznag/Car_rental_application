package com.pfaprojet.Location_Agence.repository;

import com.pfaprojet.Location_Agence.entity.User;
import com.pfaprojet.Location_Agence.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findFirstByEmail(String email);

    User findByUserRole(UserRole userRole);
}
