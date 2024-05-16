package com.example.todolistdbt.repository;

import com.example.todolistdbt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Query("update Task t set t.text = :text where t.id = :id")
    void updateById(Long id, String text);
}
