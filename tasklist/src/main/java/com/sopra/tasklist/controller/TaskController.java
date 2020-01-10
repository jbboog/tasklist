package com.sopra.tasklist.controller;

import com.sopra.tasklist.model.task.Task;
import com.sopra.tasklist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Task> add(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping("/all")
    public Flux<Task> getAll() {
        return taskService.findAll();
    }

    @GetMapping("/{title}")
    public Flux<Task> getOne(@PathVariable String title) {
        return taskService.findByTitle(title);
    }

    @GetMapping
    public Flux<Task> findByDescription(@RequestParam String description) {
        return taskService.findByDescription(description);
    }

//    @PostMapping
//    public Mono<Task> update(@RequestBody Task task, @RequestParam String entry) {
//        return  taskService.updateTask(task, entry);
//    }
}
