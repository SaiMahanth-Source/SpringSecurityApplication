package org.mahanth.springsecurityapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class config {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        httpSecurity.csrf(customizer -> customizer.disable());
//        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//        //httpSecurity.formLogin(Customizer.withDefaults());
//        /*
//         This is for browser which is default, and also we can disable it to continue using api test with postman
//         */
//        httpSecurity.httpBasic(Customizer.withDefaults()); // this is for rest access
//        httpSecurity.sessionManagement(sessionManagement ->
//                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////        /*
////        We cannot log in from our browser is because for every request we need to pass the login credentials because it
////        will create new session for every request, and we can test using the postman and in order to work this in browser
////        we need to disable the formlogin and the pop-up widow which we get is from httpBasic
////         */
//
//        return httpSecurity.build();

        return httpSecurity.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                //.formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build(); // Here we are using builder pattern because return type is HttpSecurity for the methods
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails userDetails1 = User.withDefaultPasswordEncoder()
//                .username("maneesha")
//                .password("124091@Maneesha")
//                .roles("USER")
//                .build();
//
//        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
//                .username("alpha")
//                .password("124091@alpha")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // Default no password encrypter
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(11));
        /*
        To verify the password after bcrypting using bcrypt encoder from the database
         */

        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder(11);
    }
}
