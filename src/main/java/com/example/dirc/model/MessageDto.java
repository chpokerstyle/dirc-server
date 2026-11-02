package com.example.dirc.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

// TODO Заполнить ответы в ошибках при пустых полях
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    @NotEmpty
    private UUID id;
    @NotEmpty
    private String producer;
    @NotEmpty
    private String consumer;
    @NotEmpty
    private String payload;

    public String hostOfSender() {
        return getHost(producer);
    }

    public String hostOfRecipientMsg() {
        return getHost(consumer);
    }

    private String getHost(String address) {
        return address.substring(address.indexOf("@") + 1);
    }

}
