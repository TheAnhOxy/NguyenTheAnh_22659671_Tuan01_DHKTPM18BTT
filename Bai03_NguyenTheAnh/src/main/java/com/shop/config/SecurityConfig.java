package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Quan trọng nhất: Tắt CSRF để Form POST chạy được
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/order/**", "/WEB-INF/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}