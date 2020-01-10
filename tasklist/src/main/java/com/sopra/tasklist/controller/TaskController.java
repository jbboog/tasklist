package com.sopra.tasklist.controller;


import com.sopra.tasklist.model.task.Task;
import com.sopra.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Task> add(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{title}")
    public Mono<Task> getOne(@PathVariable String title) {
        return taskRepository.findByTitle(title);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public Flux<Task> getAll() {
        return taskRepository.findAll();
    }
}
