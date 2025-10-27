package com.chatapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for simplicity (not for production)
            .csrf(csrf -> csrf.disable())

            // Allow all endpoints
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/**", "/chat/**", "/ws/**", "/topic/**", "/app/**").permitAll()
                .anyRequest().permitAll()
            )

            // Disable login form
            .formLogin(login -> login.disable())
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
