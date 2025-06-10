package com.chronoforce.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chronoforce.project.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUserName(String username);
}