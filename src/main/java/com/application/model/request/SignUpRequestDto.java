package com.application.model.request;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequestDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
