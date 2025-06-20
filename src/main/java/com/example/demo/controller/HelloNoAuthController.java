package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hello No Auth API", description = "간단한 인사 API")
@RestController
@RequestMapping("/api/noAuth")
public class HelloNoAuthController {

    @Operation(summary = "Hello 메시지 반환", description = "DAEGON에게 인사합니다.")
    @GetMapping("/helloNoAuth")
    public String helloNoAuth() {
        return "helloNoAuth, DAEGON!";
    }
}
