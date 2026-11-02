package com.example.dirc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MessageRequest {
    private final MessageDto message;
    private final Error error;

    public MessageRequest(MessageDto message) {
        this.message = message;
        this.error = null;
    }

    public MessageRequest(MessageDto message, Error error) {
        this.message = message;
        this.error = error;
    }
}
