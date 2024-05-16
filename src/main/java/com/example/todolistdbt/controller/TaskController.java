package com.example.todolistdbt.controller;

import com.example.todolistdbt.entity.Task;
import com.example.todolistdbt.service.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/")
    public List<Task> getAll(){
        return taskService.findAll();
    }

    @PostMapping("/")
    public Task create(@RequestBody Task task) {
        task.setDate(LocalDateTime.now());
        return taskService.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        taskService.deleteById(id);
    }

    @PostMapping("/update/{id}")
    public void updateByIdAndText(@PathVariable("id") Long id, @RequestParam String text) {
        taskService.changeText(id, text);
    }

    @PostMapping("/updateStatus/{id}")
    public void updateStatus(@PathVariable("id") Long id) {
        taskService.updateStatus(id);
    }
}
