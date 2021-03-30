package com.application.model.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class SignInRequestDto {
    private String login;
    private String password;
}
