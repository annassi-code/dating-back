package com.application.service;

import com.application.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.application.repository.UserRepository;
import com.application.repository.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("ta gueule"));

        return new UserDetailsImpl(user.getEmail(), user.getUsername(), user.getPassword());
    }

    public List<User> getAllUsers() {
        return
                userRepository.findAll();
    }

    public boolean isEmailExisting(String email){
        return userRepository.existsUserByEmail(email);
    }

    public User isUsernameExisting(String username) {
        return userRepository.findByEmail(username).get();
    }

    public void saveOrUpdate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
