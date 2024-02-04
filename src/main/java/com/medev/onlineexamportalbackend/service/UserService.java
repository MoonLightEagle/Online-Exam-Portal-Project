package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.CreateUserRequest;
import com.medev.onlineexamportalbackend.dto.UpdateUserRequest;
import com.medev.onlineexamportalbackend.entity.User;
import com.medev.onlineexamportalbackend.mapper.UserMapper;
import com.medev.onlineexamportalbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest createUserRequest) {
        return userRepository.save(userMapper.mapToUser(createUserRequest));
    }

    public void updateUser(Long id, UpdateUserRequest updateUserRequest) {
        userRepository.save(userMapper.mapToUser(getUserById(id),updateUserRequest));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
