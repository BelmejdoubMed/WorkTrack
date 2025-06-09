package com.chronoforce.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.chronoforce.project.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<UserDetails> findByUserName(String username);
}