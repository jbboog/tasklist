package com.sopra.tasklist.repository;

import com.sopra.tasklist.model.task.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

    public Task findByTitle(String title);

}
