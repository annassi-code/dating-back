package com.application.controller;

import com.application.model.request.SignInRequestDto;
import com.application.model.request.SignUpRequestDto;
import com.application.model.response.SignInResponse;
import com.application.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
=======
import org.springframework.http.MediaType;

>>>>>>> c785f471edb45ef8e58b3c6658c338ade09209a1
import org.springframework.web.bind.annotation.*;
//import com.application.repository.entity.User;
//import com.application.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthenticationController {
/*
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/api/auth/signin")
<<<<<<< HEAD
    public SignInResponse signIn(@RequestBody @Valid SignInRequestDto signInRequestDto) {
=======
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest){
>>>>>>> c785f471edb45ef8e58b3c6658c338ade09209a1
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequestDto.getLogin(), signInRequestDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new SignInResponse(JwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal()));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/auth/signup")
<<<<<<< HEAD
    public String signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto) throws Exception {
=======
    public String signUp(@RequestBody SignUpRequest signUpRequest) throws Exception {
>>>>>>> c785f471edb45ef8e58b3c6658c338ade09209a1

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
<<<<<<< HEAD
=======

    @GetMapping("/restricted")
    public String restricted() {
        return "new alae ";
    }
*/

    /*-----------------------------------------------------------------------------------------------------*/
    @RequestMapping(path = {"/unsecured"})
    public String noSecuredEndpoint(){
        return "This is an unsecured endpoint payload";
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }
    @RequestMapping("/admin")
    public String adminSecuredEndpoint(){
        return "This is an ADMIN endpoint payload";
    }
    @RequestMapping("/user")
    public String userSecuredEndpoint(){
        return "This is an USER endpoint payload";
    }
>>>>>>> c785f471edb45ef8e58b3c6658c338ade09209a1
}
