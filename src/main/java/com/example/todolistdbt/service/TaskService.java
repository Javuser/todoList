package com.example.todolistdbt.service;

import com.example.todolistdbt.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task save(Task task);
    void deleteById(Long taskId);

    Task changeText(Long id, String text);
    void updateStatus(Long id);
}
