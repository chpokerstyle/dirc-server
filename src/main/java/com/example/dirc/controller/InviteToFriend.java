package com.example.dirc.controller;

import com.example.dirc.model.InviteResponse;
import com.example.dirc.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("friend/invite")
public class InviteToFriend {

    @GetMapping
    public List<Person> getAllInvite(){
        return null;
    }


    public InviteResponse invite(@RequestParam String deba)
}
