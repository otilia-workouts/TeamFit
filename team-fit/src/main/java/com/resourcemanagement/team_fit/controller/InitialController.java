package com.resourcemanagement.team_fit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {
    @GetMapping("/")
    public String index() {
        return "Web Development Project Team Fit ☻!";
    }
}
