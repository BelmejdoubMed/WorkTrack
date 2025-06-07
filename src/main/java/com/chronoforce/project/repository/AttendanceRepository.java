package com.chronoforce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chronoforce.project.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
}