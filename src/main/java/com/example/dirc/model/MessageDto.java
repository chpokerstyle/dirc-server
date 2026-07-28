package com.example.dirc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID uuid;
    @NotEmpty
    private String senderMsg;
    @NotEmpty
    private String recipientMsg;
    @NotEmpty
    private String payload;
}
