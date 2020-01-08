package com.sopra.tasklist.repository;

import com.sopra.tasklist.model.task.Task;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TaskRepository extends ReactiveMongoRepository<Task, ObjectId> {//extends MongoRepository<Task, String> {

    public Mono<Task> findByTitle(String title);

}
