package com.fit.service;

import com.fit.entity.User;
import com.fit.modal.request.LoginRequestDTO;
import com.fit.modal.request.RefreshTokenRequest;
import com.fit.modal.response.LoginResponseDTO;
import com.fit.repository.UserRepository;
import com.fit.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtils jwtUtils;

    public LoginResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getIdentifier(), request.getPassword())
        );

        User user = userRepository.findByUsername(request.getIdentifier())
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));
        return LoginResponseDTO.builder()
                .accessToken(jwtUtils.generateToken(user))
                .refreshToken(jwtUtils.generateRefreshToken(user))
                .username(user.getUsername())
                .build();
    }

    public LoginResponseDTO refreshToken(RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();
        String username = jwtUtils.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (jwtUtils.isTokenValid(refreshToken, user)) {
            return LoginResponseDTO.builder()
                    .accessToken(jwtUtils.generateToken(user))
                    .refreshToken(refreshToken)
                    .username(user.getUsername())
                    .build();
        }
        throw new RuntimeException("Refresh token đã hết hạn hoặc không hợp lệ");
    }
}