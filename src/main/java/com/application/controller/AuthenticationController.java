package com.application.controller;

import com.application.model.request.SignInRequest;
import com.application.model.request.SignUpRequest;
import com.application.model.response.SignInResponse;
import com.application.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.application.repository.entity.User;
import com.application.service.UserService;

import java.util.List;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/signin")
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return new SignInResponse(JwtTokenUtil.generateToken(userDetails));
        } catch (Exception e) {
            throw new Exception("USER_DISABLED", e);
        }
    }

    @PostMapping("/api/signup")
    public SingUpResponse signUp(@RequestBody SignUpRequest signUpRequest) throws Exception {

        return null;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public int saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getId();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "new alae ";
    }
}
