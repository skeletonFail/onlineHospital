package com.onlinehospital.services;

import com.onlinehospital.dto.UserRequest;
import com.onlinehospital.entities.patient_info_schema.users.RoleEntity;
import com.onlinehospital.entities.patient_info_schema.users.UserEntity;
import com.onlinehospital.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Async(value = "taskExecutor")
    public CompletableFuture<String> addUser(UserRequest request) {
        if (request != null) {
            if (!userRepository.existsByUsername(request.getUsername())) {
                List<RoleEntity> roles = roleService.getRoles(request.getRoles());
                UserEntity user = new UserEntity();
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                user.setUsername(request.getUsername());
                user.setRoles(roles);
                userRepository.save(user);
                return CompletableFuture.completedFuture("SAVED");
            } else throw new EntityExistsException();
        } else throw new NullPointerException();
    }



}
