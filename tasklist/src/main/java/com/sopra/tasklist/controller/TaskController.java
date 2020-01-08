package com.sopra.tasklist.controller;


import com.sopra.tasklist.model.task.Task;
import com.sopra.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task add(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/{title}")
    public Task getOne(@PathVariable String title) {
        return taskRepository.findByTitle(title);
    }

    @GetMapping("/all")
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
