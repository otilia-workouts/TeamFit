package com.resourcemanagement.team_fit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitialController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Web Development Project Team Fit ☻!");
        return  "index";
    }

    @GetMapping("/home")
    public String addProj(Model model) {
        model.addAttribute("addProj", "Adăugare proect: ");
        return "menu";
    }
}
