package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "로그인 요청 DTO")
public class LoginRequest {
    @Schema(description = "사용자 아이디", example = "daegon")
    private String username;
    @Schema(description = "비밀번호", example = "1234")
    private String password;
}
