package com.spring.app.spring.app.domain.entity;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime now;
    private String message;
    private String description;

    public ErrorDetails(LocalDateTime now, String message, String description) {
        this.now = now;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
