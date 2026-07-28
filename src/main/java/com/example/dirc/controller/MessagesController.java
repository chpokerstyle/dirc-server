package com.example.dirc.controller;

import com.example.dirc.model.MessageDto;
import com.example.dirc.model.MessageRequest;
import com.example.dirc.model.MessageResponse;
import com.example.dirc.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/msg")
@RequiredArgsConstructor
public class MessagesController {
    private final MessagesService service;

    @PostMapping
    public ResponseEntity<MessageResponse> send(@RequestBody MessageRequest request) {
        return ResponseEntity.ok(service.send(request));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> receiving(@RequestBody MessageRequest request) {
        return ResponseEntity.ok(service.receiving(request));
    }

    @GetMapping
    public void test() {
        service.send(new MessageRequest(
                MessageDto.builder()
                        .recipientMsg("получатель@irc.com")
                        .senderMsg("отправитель@irc.com")
                        .payload("Ты пидор!")
                        .build(),
                null));
    }
}
