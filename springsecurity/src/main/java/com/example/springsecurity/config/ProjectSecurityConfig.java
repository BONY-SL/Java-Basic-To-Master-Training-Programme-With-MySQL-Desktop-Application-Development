package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// for the method level Security
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)

public class ProjectSecurityConfig {

    // If you're testing login in browser and want the Spring login form:
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/v1/auth/register", "/api/v1/test").permitAll()
//                        .requestMatchers("/api/v1/account").hasAuthority("USER")
//                )
//                .formLogin(Customizer.withDefaults()) // shows login form
//                .httpBasic(Customizer.withDefaults()); // optional
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/register", "/api/v1/test").permitAll()
                        .requestMatchers("/api/v1/account").authenticated()
                )
                .formLogin(Customizer.withDefaults()) // shows login form
                .httpBasic(Customizer.withDefaults()); // optional

        return http.build();
    }

    // If you're building an API (Angular frontend), and don’t need form login:
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/v1/auth/register", "/api/v1/test").permitAll()
//                        .requestMatchers("/api/v1/account").hasAuthority("USER")
//                )
//                .httpBasic(Customizer.withDefaults()); // only basic auth
//
//        return http.build();
//    }
}
