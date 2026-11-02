package com.example.dirc.controller;

import com.example.dirc.model.Person;
import com.example.dirc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search")
@RequiredArgsConstructor
public class PersonSearchController {
    private final PersonService service;

    @GetMapping("/all")
    public List<Person> getAll() {
        return service.getAll();
    }

    @GetMapping("/by-nickname")
    public List<Person> getByNickName() {
        return service.getAll();
    }

    @GetMapping("/by-depa")
    public List<Person> getByDepa() {
        return service.getAll();
    }
}
