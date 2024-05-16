package com.example.todolistdbt.service;

import com.example.todolistdbt.entity.Task;
import com.example.todolistdbt.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long taskId) {
        taskRepository.deleteById(taskId);
    }
    @Transactional
    @Override
    public Task changeText(Long id, String text) {
        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        task.setText(text);
        taskRepository.updateById(id, text);
        return task;
    }

    @Override
    public void updateStatus(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(task.getStatus().equals(Boolean.FALSE)) {
            task.setStatus(Boolean.TRUE);
        }
        taskRepository.save(task);
    }
}
