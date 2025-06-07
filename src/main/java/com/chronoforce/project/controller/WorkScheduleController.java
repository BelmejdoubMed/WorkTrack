package com.chronoforce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chronoforce.project.entity.WorkSchedule;
import com.chronoforce.project.service.WorkScheduleService;

@RestController
@RequestMapping("/workschedules")
public class WorkScheduleController {

    @Autowired
    private WorkScheduleService workScheduleService;

    @GetMapping
    public List<WorkSchedule> getAllWorkSchedules() {
        return workScheduleService.findAll();
    }

    @GetMapping("/{id}")
    public WorkSchedule getWorkScheduleById(@PathVariable int id) {
        return workScheduleService.findById(id);
    }

    @PostMapping
    public WorkSchedule createWorkSchedule(@RequestBody WorkSchedule workSchedule) {
        return workScheduleService.save(workSchedule);
    }

    @PutMapping("/{id}")
    public WorkSchedule updateWorkSchedule(@PathVariable int id, @RequestBody WorkSchedule workSchedule) {
        workSchedule.setId(id);
        return workScheduleService.save(workSchedule);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkSchedule(@PathVariable int id) {
        workScheduleService.delete(id);
    }
}