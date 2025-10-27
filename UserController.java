package com.chatapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register user
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully";
    }

    // Login user
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> u = userRepository.findByUsername(user.getUsername());
        if(u.isPresent() && u.get().getPassword().equals(user.getPassword())) {
            return u.get().getUsername(); // Return username for frontend
        } else {
            return "fail";
        }
    }
}
