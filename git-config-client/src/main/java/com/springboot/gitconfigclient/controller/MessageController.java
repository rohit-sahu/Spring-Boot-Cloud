package com.springboot.gitconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api")
public class MessageController {

    @Value("${message: Default}")
    private String message;

    @GetMapping("/message")
    public String getConfigMessage() {
        return message;
    }
}
