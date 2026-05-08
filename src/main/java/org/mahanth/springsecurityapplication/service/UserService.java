package org.mahanth.springsecurityapplication.service;

import org.mahanth.springsecurityapplication.model.User;
import org.mahanth.springsecurityapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder ;

    public User UserRegister(User user){

        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        return userRepo.save(user);
    }
}
