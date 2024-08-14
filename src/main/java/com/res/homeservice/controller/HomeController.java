package com.res.homeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
    private final RestTemplate restTemplate;
    private final String serviceUrl;

    @Autowired
    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.serviceUrl = "http://gateway-server";
    }

    @GetMapping("/test")
    public String test() {
        String customerInfo = restTemplate.getForObject(serviceUrl + "/info", String.class);
        return "test: " + customerInfo;
    }
}
