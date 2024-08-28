package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.UUID;

public class ErrorResponse {
    private String id;
    private String message;
    private LocalDateTime generatedAt;

    public ErrorResponse(String message) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.generatedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}
