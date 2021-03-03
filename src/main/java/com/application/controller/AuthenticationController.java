package com.application.controller;

import com.application.model.request.SignInRequest;
import com.application.model.request.SignUpRequest;
import com.application.model.response.SignInResponse;
import com.application.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
//import com.application.repository.entity.User;
//import com.application.service.UserService;

import java.util.List;

@RestController
public class AuthenticationController {
/*
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/auth/signin")
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new SignInResponse(JwtTokenUtil.generateToken(userDetails));

    }

    @PostMapping("/api/auth/signup")
    public String signUp(@RequestBody SignUpRequest signUpRequest) throws Exception {


        return null;
    }

    public String signOut() throws Exception{
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
}
