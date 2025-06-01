package com.ndungutse.tms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @GetMapping
    public ResponseEntity<List<?>> getAllTasks() {
        return new ResponseEntity<List<?>>(new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable("id") String id) {
        Map<String, Object> newTask = new HashMap<>();
        newTask.put("id", "sdfkd-34rewr-43rer453");
        newTask.put("description", "Description");
        return new ResponseEntity<>("Task id: " + id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Map<String, Object> taskRequest) {
        Map<String, Object> newTask = new HashMap<>();
        newTask.put("id", "sdfkd-34rewr-43rer453");
        newTask.put("description", "Description");
        return new ResponseEntity<>("Task Created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") String id, @RequestBody Map<String, Object> taskRequest) {
        Map<String, Object> task = new HashMap<>();
        task.put(id, id);
        task.put("description", "Description");
        return new ResponseEntity<>(taskRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Task deleted successfully");
        response.put("id", id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
