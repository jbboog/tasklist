package com.sopra.tasklist.service;

import com.sopra.tasklist.model.task.Task;
import com.sopra.tasklist.model.task.TaskStatus;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITaskService {

    Mono<Task> addTask(Task task);

    Mono<Task> updateTask(Task task, String entry);

    Mono<Task> findById(ObjectId id);

    Flux<Task> findAll();

    Flux<Task> findByTitle(String title);

    Flux<Task> findByDescription(String query);

    Flux<Task> findByStatus(TaskStatus status);

    Flux<Task> sortByDeadline();

}
