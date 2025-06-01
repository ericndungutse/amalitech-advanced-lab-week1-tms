package com.ndungutse.tms.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ndungutse.tms.model.Task;
import com.ndungutse.tms.repository.TasksRepository;

public class TaskService {
    public Task createTask(Task task) {
        task.setId(UUID.randomUUID());
        return TasksRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return TasksRepository.findAll();
    }

    public Optional<Task> getTaskById(UUID id) {
        return TasksRepository.findById(id);
    }

    public Optional<Task> updateTask(UUID id, Task updatedTask) {
        return TasksRepository.findById(id)
                .map(existing -> {
                    updatedTask.setId(id);
                    return TasksRepository.update(id, updatedTask);
                });
    }

    public boolean deleteTask(UUID id) {
        return TasksRepository.delete(id);
    }

}
