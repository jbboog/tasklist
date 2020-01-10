package com.sopra.tasklist.repository;

import com.sopra.tasklist.model.task.Task;
import com.sopra.tasklist.model.task.TaskStatus;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface TaskRepository extends ReactiveMongoRepository<Task, ObjectId> {

    Flux<Task> findByTitleIgnoreCase(String title);

    Flux<Task> findByStatus(TaskStatus status);

    Flux<Task> findByDescriptionIgnoreCaseContaining(String query);

    Flux<Task> findByDeadline(LocalDate deadline);

//    Flux<Task> findAllOrderByDeadlineDesc();

//    Dit hebben we nodig voor pagination, maar dit is wel echt vaag
//    Page<Task> findAll(PageRequest deadline);
}
