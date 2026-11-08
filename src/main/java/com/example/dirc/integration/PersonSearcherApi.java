package com.example.dirc.integration;

import com.example.dirc.model.Person;
import com.example.dirc.utils.DebaUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class PersonSearcherApi {
    private static final String HTTP = "http://";
    private static final String API_SEARCH = "api/search/by-depa?deba=";

    public Person searchByNickname(String deba) {
        return RestClient.builder()
                .baseUrl(HTTP + DebaUtils.getHost(deba) + API_SEARCH + deba)
                .build()
                .get()
                .retrieve()
                .body(Person.class);
    }
}
