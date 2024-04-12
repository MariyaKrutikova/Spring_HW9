package com.example.spingDataHW5.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;
}
