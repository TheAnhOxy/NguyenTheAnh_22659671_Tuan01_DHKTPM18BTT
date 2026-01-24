package com.fit.modal.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginResponseDTO {
    private String accessToken;
    private String refreshToken;
    private String username;
}