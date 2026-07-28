package com.example.dirc.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MessageRequest {
    private final MessageDto message;
    private final Error error;
}
