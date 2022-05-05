package com.cricinfo.livescore.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationRequest {
    private String username;
    @Email( message = "Not a valid email" )
    @NotBlank( message = "Email Required" )
    private String email;
    @NotBlank( message = "Password Required" )
    private String password;
}
