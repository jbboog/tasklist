package com.sopra.tasklist;

import com.sopra.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasklistApplication implements CommandLineRunner {

	@Autowired
	TaskRepository taskRepository;

	public static void main(String[] args) {

		SpringApplication.run(TasklistApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

	}
}
