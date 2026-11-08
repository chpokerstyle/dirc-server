package com.example.dirc.model;

import lombok.Data;

@Data
public class MessageRequest {
    private final Message message;
    private final Error error;

    public MessageRequest(Message message) {
        this.message = message;
        this.error = null;
    }

    public MessageRequest(Message message, Error error) {
        this.message = message;
        this.error = error;
    }
}
