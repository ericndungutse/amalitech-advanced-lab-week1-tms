package com.ndungutse.tms.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.ndungutse.tms.model.Task;

public class TasksRepository {
    private static final Map<UUID, Task> tasks = new HashMap<>();

    // Create or Save Task
    public static Task save(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    // Get all tasks
    public static List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    // Get task by ID
    public static Optional<Task> findById(UUID id) {
        return Optional.ofNullable(tasks.get(id));
    }

    // Update task
    public static Task update(UUID id, Task updatedTask) {
        tasks.put(id, updatedTask);
        return updatedTask;
    }

    public static boolean delete(UUID id) {
        return tasks.remove(id) != null;
    }

}
