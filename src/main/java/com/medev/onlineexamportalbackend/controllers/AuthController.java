package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.CreateUserRequest;
import com.medev.onlineexamportalbackend.dto.UpdateUserRequest;
import com.medev.onlineexamportalbackend.entity.User;
import com.medev.onlineexamportalbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class AuthController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(CreateUserRequest createUserRequest, HttpServletRequest request) {
        String csrfToken = request.getAttribute(CsrfToken.class.getName()).toString();

        return userService.createUser(createUserRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        userService.updateUser(id, updateUserRequest);
    }
}
