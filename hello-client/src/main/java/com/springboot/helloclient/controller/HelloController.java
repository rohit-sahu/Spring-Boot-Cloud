package com.springboot.helloclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello/client")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get")
    public String hello() {
        String url = "http://hello-server/hello/server";
        return restTemplate.getForObject(url, String.class);
    }
}
