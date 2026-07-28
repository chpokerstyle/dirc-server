package com.example.dirc.service;

import com.example.dirc.model.MessageRequest;
import com.example.dirc.model.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagesService {
    private final Sender sender;

    public MessageResponse send(MessageRequest request) {
        return sender.send(request);
    }

    public MessageResponse receiving(MessageRequest request) {
        request.getMessage()
    }
}
