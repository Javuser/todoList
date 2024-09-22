package com.example.todolistdbt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "task")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime date;
    private String text;
    private String author;
    private Boolean status = Boolean.FALSE;
}
