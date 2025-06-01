package com.ndungutse.tms.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime createdAt;

    public Task(String title, String description, Boolean completed, LocalDateTime createdAt) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
