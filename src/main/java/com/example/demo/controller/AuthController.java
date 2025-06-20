package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Tag(name = "인증 API", description = "로그인 및 인증 관련 API")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Operation(summary = "로그인", description = "username과 password를 입력받아 JWT 토큰을 반환합니다.")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if ("daegon".equals(request.getUsername()) && "Geometic7!".equals(request.getPassword())) {

            System.out.println("############ chk 1");

            String token = JwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } else {

            System.out.println("############ chk 2");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}