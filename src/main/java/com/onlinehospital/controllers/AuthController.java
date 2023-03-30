package com.onlinehospital.controllers;

import com.onlinehospital.dto.UserRequest;
import com.onlinehospital.security.jwt.JwtUtil;
import com.onlinehospital.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid UserRequest request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        String result = "UNSAVED";
        try {
            result = userService.addUser(request).get();
        } catch (ExecutionException | InterruptedException exc) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody @Valid UserRequest request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword());

            authenticationManager.authenticate(authenticationToken);
            return new ResponseEntity<>(jwtUtil.generateTokenByUsername(request.getUsername()), HttpStatus.OK);
        } catch (AuthenticationException exc) {
            return new ResponseEntity<>("Invalidate email or password", HttpStatus.NOT_FOUND);
        }
    }


}
