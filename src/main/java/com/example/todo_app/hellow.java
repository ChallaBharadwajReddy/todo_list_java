package com.example.todo_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellow {
    @GetMapping(path = "/hellow")
    public String say_hellow(){
        return "hellow!";
    }
}
