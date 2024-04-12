package com.example.spingDataHW5.controllers;


import com.example.spingDataHW5.models.Task;
import com.example.spingDataHW5.models.TaskStatus;
import com.example.spingDataHW5.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/serviceA")
@AllArgsConstructor
public class TaskController {
    private  final TaskService taskService;

    /**
     * Посмотеть все задачи
     * @return список всех задач
     * */
    @GetMapping("/tasks")
    public List<Task> getAllTask(){
        return taskService.getALLTasks();
    }

    /**
     * Добавить задачу
     * @return Task
     * */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

     /**
     * Найти задачу по статусу
     *  @return список задач
     * */
    @GetMapping("/tasks/status/{status}")
    public List<Task> findTaskByStatus(@PathVariable TaskStatus status){
        return taskService.findTackByStatus(status);
    }

    /**
     * Изменить задачу
     * @return Task
     * */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.changeTask(id, task);
    }

    /**
     * Удалить задачу по ID
     * @return Task
     * */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
