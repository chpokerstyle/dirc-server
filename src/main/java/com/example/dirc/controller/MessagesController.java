package com.example.dirc.controller;

import com.example.dirc.model.MessageDto;
import com.example.dirc.model.MessageRequest;
import com.example.dirc.model.MessageResponse;
import com.example.dirc.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO IRC-20 Перевести на соккет
@RestController
@RequestMapping("/api/msg") @RequiredArgsConstructor
public class MessagesController {
    private final MessagesService service;

    /**
     * Отправка сообщения
     * @param request
     * @return
     */
    @PostMapping("/send")
    public ResponseEntity<MessageRequest> send(@RequestBody MessageRequest request) {
        return ResponseEntity.ok(service.send(request));
    }

    /**
     * Получение сообщения
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<MessageResponse> receiving(@RequestBody MessageRequest request) {
        return ResponseEntity.ok(service.receiving(request));
    }

    /**
     * Вывод сообщения из диалога с пользователем
     * @param user
     * @return
     */
    @GetMapping
    public List<MessageDto> getMessagesWithUser(@RequestParam String user) {
        return service.getMessagesWithUser(user);
    }

    @GetMapping("/test")
    public void test() {
        service.send(new MessageRequest(
                MessageDto.builder()
                        .consumer("получатель@irc.com")
                        .producer("отправитель@irc.com")
                        .payload("Ты пидор!")
                        .build()));
    }
}
