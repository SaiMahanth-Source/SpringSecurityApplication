package org.mahanth.springsecurityapplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /*
    http://localhost:8080/login?logout for logout form and also spring maintains the session as well
    httpServletRequest.getSession().getId() to get the session I'd generated
     */
    @GetMapping("/")
    public ResponseEntity<String> greet(HttpServletRequest httpServletRequest){

//        return new ResponseEntity<>("Welcome to the home page ", HttpStatus.OK);
        return new ResponseEntity<>("Welcome to the home page " + httpServletRequest.getSession().getId(), HttpStatus.OK);
    }
}
