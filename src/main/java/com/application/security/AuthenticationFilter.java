package com.application.security;


//import com.application.service.UserService;
import com.application.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                    securityContext.setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }*/
}
