package com.example.dirc.model;

import lombok.Data;

@Data
public class MessageResponse {
    private Message message;
    private Error error;
    private boolean success;
}
