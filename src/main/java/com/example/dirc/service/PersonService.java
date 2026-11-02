package com.example.dirc.service;

import com.example.dirc.model.Person;
import com.example.dirc.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo repo;

    public List<Person> getAll() {
        return repo.getAll();
    }

    public Person getByNickName(String nickName) {
        repo.getByNickName(nickName);
    }

    public Person getByDepa(String depa) {
        repo.getByDepa(depa);
    }
}
