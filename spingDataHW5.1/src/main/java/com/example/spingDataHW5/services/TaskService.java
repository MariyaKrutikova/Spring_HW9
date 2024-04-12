package com.example.spingDataHW5.services;

import com.example.spingDataHW5.models.Task;
import com.example.spingDataHW5.models.TaskStatus;
import com.example.spingDataHW5.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private  final TaskRepository taskRepository;

    /**
     * Узнать все задачи
     * @return список задач
     * */
    public List<Task> getALLTasks(){
        return taskRepository.findAll();
    }

    /**
     * Узнать задачу по ID
     * @return Task
     * */
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    /**
     * Изменить задачу
     * @return Task
     * */
    public Task changeTask(Long id, Task newTask){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(newTask.getDescription());
            task.setStatus(newTask.getStatus());
            task.setCreationDate(newTask.getCreationDate());
            task.setCreationDate(newTask.getCreationDate());
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * Удалить задачу
     * @return Task
     * */
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    /**
     * Добавить задачу
     * @return Task
     * */
    public Task addTask(Task task){
        task.setCreationDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    /**
     * Найти задачу по статусу
     * @return список задач
     * */
    public List<Task> findTackByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }
}
