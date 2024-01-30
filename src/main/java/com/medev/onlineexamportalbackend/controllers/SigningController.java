package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.SigningDTO;
import com.medev.onlineexamportalbackend.service.SigningService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signing")
public class SigningController {
    private final SigningService signingService;

    public SigningController(SigningService signingService) {
        this.signingService = signingService;
    }

    @PostMapping
    public void postNewUser(@RequestBody SigningDTO signingDTO){
        signingService.postNewUser(signingDTO);
    }
}
