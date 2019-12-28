package com.springboot.helloserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/server")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
