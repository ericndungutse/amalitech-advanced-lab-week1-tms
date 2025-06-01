package com.ndungutse.tms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndungutse.tms.model.Task;
import com.ndungutse.tms.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "Task Management", description = "Operations related to task management")
public class TaskController {
    private static final TaskService taskService = new TaskService();
    private static final Logger logger = Logger.getLogger(TaskController.class.getName());

    @GetMapping
    @Operation(summary = "Get All Tasks", description = "Retrieve all tasks in the system")
    public ResponseEntity<List<Task>> getAllTasks() {
        logger.info("Fetching all tasks");
        List<Task> tasks = taskService.getAllTasks();
        logger.info("Total tasks retrieved: " + tasks.size());
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID", description = "Retrieve a task by its unique identifier")
    public ResponseEntity<?> getTaskById(@PathVariable("id") String id) {
        logger.info("Fetching task with ID: " + id);
        Optional<Task> task = taskService.getTaskById(UUID.fromString(id.toString()));
        if (task != null) {
            logger.info("Task found: " + task.get().getTitle());
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Create a new task", description = "Add a new task to the system")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = Task.class)))
    public ResponseEntity<Task> createTask(@RequestBody Task taskRequest) {
        logger.info("Creating a new task with title: " + taskRequest.getTitle());
        Task task = taskService.createTask(taskRequest);
        logger.info("Creating new task: " + task.getTitle());
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing task", description = "Modify an existing task by its unique identifier")
    public ResponseEntity<?> updateTask(@PathVariable("id") String id, @RequestBody Map<String, Object> taskRequest) {
        Map<String, Object> task = new HashMap<>();
        task.put(id, id);
        task.put("description", "Description");
        return new ResponseEntity<>(taskRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task", description = "Remove a task from the system by its unique identifier")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Task deleted successfully");
        response.put("id", id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
