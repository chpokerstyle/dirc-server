package com.example.dirc.service;

import com.example.dirc.model.MessageRequest;
import com.example.dirc.model.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * Sender отправляет сообщения на другие сервера (в децентрализованном стиле)
 */
@Component
@RequiredArgsConstructor
public class Sender {
    private static final String HTTP = "http://";
    private static final String API_MSG = "api/msg";

    private final RestClient client;

    private String host;

    public MessageRequest send(@RequestBody MessageRequest request) {
        return RestClient.builder()
                .baseUrl(HTTP + this.host + API_MSG)
                .build()
                .post()
                .body(request)
                .retrieve()
                .body(MessageRequest.class);
    }

    public Sender host(String host){
        this.host = host;
        return this;
    }
}
