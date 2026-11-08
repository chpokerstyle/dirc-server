package com.example.dirc.integration;

import com.example.dirc.model.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface SenderService {

    @PostExchange("http://localhost:8080/msg")
    void send(@RequestBody Message body);


}
