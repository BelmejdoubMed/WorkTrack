package com.chronoforce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chronoforce.project.entity.WorkSchedule;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {
}