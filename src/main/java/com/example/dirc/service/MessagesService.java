package com.example.dirc.service;

import com.example.dirc.integration.Sender;
import com.example.dirc.model.Message;
import com.example.dirc.model.MessageRequest;
import com.example.dirc.model.MessageResponse;
import com.example.dirc.repo.MessagesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagesService {
    private final Sender sender;
    private final MessagesRepo messagesRepo;

    public MessageRequest send(MessageRequest request) {
        return sender
                .host(request.getMessage().hostOfRecipientMsg())
                .send(request);
    }

    public MessageResponse receiving(MessageRequest request) {
        messagesRepo.save(request.getMessage());
        return null;
    }

    public List<Message> getMessagesWithUser(String user) {
        var me = "dima@volok.ru";
        return messagesRepo.getMessagesWithUser(user, me);
    }
}
