package com.fit.modal.request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String identifier;
    private String password;
}