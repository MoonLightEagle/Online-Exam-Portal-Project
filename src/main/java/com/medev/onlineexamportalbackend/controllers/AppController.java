package com.medev.onlineexamportalbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/home")
    public String viewHomePage(){
        return "index";
    }
}