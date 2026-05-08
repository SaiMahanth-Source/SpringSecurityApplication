package org.mahanth.springsecurityapplication.service;

import org.mahanth.springsecurityapplication.model.User;
import org.mahanth.springsecurityapplication.model.UserPrinciple;
import org.mahanth.springsecurityapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(username);

        if(user == null) {
            throw new UsernameNotFoundException("User Not Found" + username);
        }

//        System.out.println(user);
        return new UserPrinciple(user);
    }
}
