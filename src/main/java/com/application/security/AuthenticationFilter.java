package com.application.security;


//import com.application.service.UserService;
import com.application.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
<<<<<<< HEAD
import org.springframework.boot.context.annotation.Configurations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
=======

>>>>>>> c785f471edb45ef8e58b3c6658c338ade09209a1
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

public class AuthenticationFilter  {

//    @Autowired
//    UserService userService;

    @Value("${jwt.header}")
    private String TOKEN_HEADER;

/*
  //  @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String header = request.getHeader(TOKEN_HEADER);

        if (header != null && securityContext.getAuthentication() == null){
            String token = header.substring("Bearer ".length());
            String username = JwtTokenUtil.getUserNameFromToken(token);

            if (username != null) {
                UserDetails userDetails = new UserDetailsImpl("d","d","d");// userService.loadUserByUsername(username);
                if (JwtTokenUtil.isTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // After setting the Authentication in the context, we specify that the current user is authenticated.
                    // So it passes the Spring Security Configurations successfully.
                    securityContext.setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }*/
}
