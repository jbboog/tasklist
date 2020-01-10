package com.sopra.tasklist.service;

import com.sopra.tasklist.model.task.Task;
import com.sopra.tasklist.model.task.TaskStatus;
import com.sopra.tasklist.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService implements ITaskService {

    private final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Mono<Task> addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Mono<Task> updateTask(Task task, String entry) {

        return findById(task.getId()).map(t -> updateHelper(t, entry));
        //return null;
//        return taskRepository.save(taskRepository.findById(taskId));
        // find and save should work

    }

    private Task updateHelper(Task task, String title) {
        return task.setTitle(title);
    }
    @Override
    public Mono<Task> findById(ObjectId id) {
        return taskRepository.findById(id);
    }

    @Override
    public Flux<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Flux<Task> findByTitle(String title) {
        return taskRepository.findByTitleIgnoreCase(title);
    }

    @Override
    public Flux<Task> findByDescription(String query) {
        return taskRepository.findByDescriptionIgnoreCaseContaining(query);
    }

    @Override
    public Flux<Task> findByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Flux<Task> sortByDeadline() {
//        deze repo method werkt niet omdat er geen order zit op Localdate.
//        return taskRepository.findAllOrderByDeadlineDesc();
        return null;
    }

}
