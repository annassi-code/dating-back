package com.application.service;

import com.application.model.UserAuthentication;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException(" ta gueule");
        }

        return new UserAuthentication(user.get().getUsername(), user.get().getPassword());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveOrUpdate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username).get();
    }

}
