package com.example.dirc.service;

import com.example.dirc.integration.PersonSearcherApi;
import com.example.dirc.model.Person;
import com.example.dirc.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo repo;
    private final PersonSearcherApi personSearcherApi;

    public List<Person> getAll() {
        return repo.getAll();
    }

    public List<Person> getByNickName(String nickName) {
        return repo.getByNickName(nickName);
    }

    public Person getByDepa(String depa, Boolean isOnlyMySystem) {
        return isOnlyMySystem != null && isOnlyMySystem
                ? repo.getByDepa(depa)
                : personSearcherApi.searchByNickname(depa);
    }
}
