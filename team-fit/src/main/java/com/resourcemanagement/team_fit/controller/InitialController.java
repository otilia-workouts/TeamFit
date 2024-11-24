package com.resourcemanagement.team_fit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitialController {
    @GetMapping("/")
    public @ResponseBody String index() {
        return "Web Development Project Team Fit ☻!";
    }
}
