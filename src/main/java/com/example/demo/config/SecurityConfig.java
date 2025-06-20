package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())               // 🚫 CSRF 비활성화 (람다 방식)
                .formLogin(form -> form.disable())          // 🚫 기본 로그인 페이지 비활성화
                .httpBasic(basic -> basic.disable())        // 🚫 Basic 인증 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/**",
                                "/api/noAuth/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**"
                        ).permitAll()                                // 로그인 관련 API는 허용
                        .anyRequest().authenticated()                // 나머지는 인증 필요
                )
                .addFilterBefore(new JwtAuthenticationFilter(new JwtUtil()), UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }
}