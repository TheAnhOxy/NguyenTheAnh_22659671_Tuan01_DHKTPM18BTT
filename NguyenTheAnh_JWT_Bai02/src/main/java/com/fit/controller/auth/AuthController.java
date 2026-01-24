package com.fit.controller.auth;

import com.fit.modal.request.LoginRequestDTO;
import com.fit.modal.request.RefreshTokenRequest;
import com.fit.modal.response.ApiResponse;
import com.fit.modal.response.LoginResponseDTO;
import com.fit.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> authenticate(@RequestBody LoginRequestDTO request) {
        LoginResponseDTO loginData = service.login(request);

        return ResponseEntity.ok(ApiResponse.builder()
                .status(200)
                .message("Đăng nhập thành công")
                .data(loginData)
                .build());
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        LoginResponseDTO refreshData = service.refreshToken(request);

        return ResponseEntity.ok(ApiResponse.builder()
                .status(200)
                .message("Lấy token mới thành công")
                .data(refreshData)
                .build());
    }
}