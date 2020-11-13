package com.application.config;

import com.application.security.AuthenticationFilter;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringWebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //     http.headers().frameOptions().sameOrigin();

        // +> Basic authentication
        /*
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        */

        // +> JWT authentication

        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);


        // +> OAUTH 2 authentication
        /*http
                .authorizeRequests().antMatchers(HttpMethod.GET, "/users").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
        */
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }
}
