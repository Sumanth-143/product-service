package com.example.productservice.dto;

import java.sql.Timestamp;

public class ErrorResponse {

    public Timestamp timestamp;
    public String message;

    public ErrorResponse(Timestamp timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
