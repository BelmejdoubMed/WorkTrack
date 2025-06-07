package com.chronoforce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chronoforce.project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}