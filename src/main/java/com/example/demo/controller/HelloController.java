package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Hello API", description = "간단한 인사 API")
@RestController
@RequestMapping("/api")
public class HelloController {

    @Operation(summary = "Hello 메시지 반환", description = "DAEGON에게 인사합니다.")
    @GetMapping("/hello")
    public String hello() {
        return "Hello, DAEGON!";
    }
}
