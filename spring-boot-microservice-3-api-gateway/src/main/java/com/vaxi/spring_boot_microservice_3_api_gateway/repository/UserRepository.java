package com.vaxi.spring_boot_microservice_3_api_gateway.repository;

import com.vaxi.spring_boot_microservice_3_api_gateway.model.User;
import com.vaxi.spring_boot_microservice_3_api_gateway.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findAll();

    @Query("UPDATE User SET role=:role WHERE username=:username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);

}