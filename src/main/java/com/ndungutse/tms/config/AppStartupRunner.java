package com.ndungutse.tms.config;

import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ndungutse.tms.model.Task;
import com.ndungutse.tms.repository.TasksRepository;

@Component
public class AppStartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Override
    public void run(String... args) {
        logger.info("Starting to insert 10 unique tasks at startup...");

        Task task1 = new Task();
        task1.setId(UUID.randomUUID());
        task1.setTitle("Write project proposal");
        task1.setDescription("Draft the initial project proposal document.");
        task1.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task1);
        logger.info("Saved Task 1: {}", task1.getTitle());

        Task task2 = new Task();
        task2.setId(UUID.randomUUID());
        task2.setTitle("Design database schema");
        task2.setDescription("Create ER diagrams and table structures.");
        task2.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task2);
        logger.info("Saved Task 2: {}", task2.getTitle());

        Task task3 = new Task();
        task3.setId(UUID.randomUUID());
        task3.setTitle("Setup development environment");
        task3.setDescription("Install required software and tools.");
        task3.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task3);
        logger.info("Saved Task 3: {}", task3.getTitle());

        Task task4 = new Task();
        task4.setId(UUID.randomUUID());
        task4.setTitle("Implement authentication");
        task4.setDescription("Develop login and registration features.");
        task4.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task4);
        logger.info("Saved Task 4: {}", task4.getTitle());

        Task task5 = new Task();
        task5.setId(UUID.randomUUID());
        task5.setTitle("Create REST API");
        task5.setDescription("Build API endpoints for tasks management.");
        task5.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task5);
        logger.info("Saved Task 5: {}", task5.getTitle());

        Task task6 = new Task();
        task6.setId(UUID.randomUUID());
        task6.setTitle("Write unit tests");
        task6.setDescription("Ensure code quality with JUnit tests.");
        task6.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task6);
        logger.info("Saved Task 6: {}", task6.getTitle());

        Task task7 = new Task();
        task7.setId(UUID.randomUUID());
        task7.setTitle("Prepare deployment");
        task7.setDescription("Configure servers and deployment pipeline.");
        task7.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task7);
        logger.info("Saved Task 7: {}", task7.getTitle());

        Task task8 = new Task();
        task8.setId(UUID.randomUUID());
        task8.setTitle("Conduct user training");
        task8.setDescription("Organize sessions to train end users.");
        task8.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task8);
        logger.info("Saved Task 8: {}", task8.getTitle());

        Task task9 = new Task();
        task9.setId(UUID.randomUUID());
        task9.setTitle("Gather feedback");
        task9.setDescription("Collect feedback after user acceptance testing.");
        task9.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task9);
        logger.info("Saved Task 9: {}", task9.getTitle());

        Task task10 = new Task();
        task10.setId(UUID.randomUUID());
        task10.setTitle("Plan next sprint");
        task10.setDescription("Define goals and tasks for upcoming sprint.");
        task10.setCreatedAt(LocalDateTime.now());
        TasksRepository.save(task10);
        logger.info("Saved Task 10: {}", task10.getTitle());

        logger.info("✅ Successfully inserted 10 unique tasks at startup.");
    }
}
