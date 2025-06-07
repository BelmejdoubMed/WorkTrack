package com.chronoforce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chronoforce.project.entity.WorkSchedule;
import com.chronoforce.project.repository.WorkScheduleRepository;

@Service
public class WorkScheduleService {
    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    public List<WorkSchedule> findAll() {
        return workScheduleRepository.findAll();
    }

    public WorkSchedule findById(int id) {
        return workScheduleRepository.findById(id).orElse(null);
    }

    public WorkSchedule save(WorkSchedule workSchedule) {
        return workScheduleRepository.save(workSchedule);
    }

    public WorkSchedule update(int id, WorkSchedule workSchedule) {
        workSchedule.setId(id);
        return workScheduleRepository.save(workSchedule);
    }

    public void delete(int id) {
        workScheduleRepository.deleteById(id);
    }
}