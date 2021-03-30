package com.application.controller;

import com.application.model.request.SignInRequestDto;
import com.application.model.request.SignUpRequestDto;
import com.application.model.response.SignInResponse;
import com.application.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.application.repository.entity.User;
import com.application.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/api/auth/signin")
    public SignInResponse signIn(@RequestBody @Valid SignInRequestDto signInRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequestDto.getLogin(), signInRequestDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new SignInResponse(JwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal()));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/auth/signup")
    public String signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto) throws Exception {

        if(userService.isUsernameExisting(signUpRequestDto)){
            // +> add a new user in DataBase.
            userService.saveOrUpdate(.map(signUpRequestDto));

            // +> send e-mail to the user to validate

        }
        return null;
    }

    public String signOut() throws Exception {
        return null;
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }
}
