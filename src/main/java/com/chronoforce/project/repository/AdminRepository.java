package com.chronoforce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chronoforce.project.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}