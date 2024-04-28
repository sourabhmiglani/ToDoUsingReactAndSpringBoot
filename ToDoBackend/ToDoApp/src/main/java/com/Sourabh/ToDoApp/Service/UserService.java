package com.Sourabh.ToDoApp.Service;

import com.Sourabh.ToDoApp.Dto.SignupRequest;
import com.Sourabh.ToDoApp.Entity.User;
import com.Sourabh.ToDoApp.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void signup(SignupRequest request) {
        // Create a new user entity and save it to the database
        User user = new User(request.getUsername(), request.getPassword(),request.getEmail());
        userRepository.save(user);
    }
}
