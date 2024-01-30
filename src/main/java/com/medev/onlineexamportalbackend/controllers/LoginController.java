package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.LoginDTO;
import com.medev.onlineexamportalbackend.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController <T> {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    // TODO fix return to entity T
    @PostMapping
    public String loginUser(@RequestBody LoginDTO loginDTO){
        return loginService.LoginUser(loginDTO);
    }
}
