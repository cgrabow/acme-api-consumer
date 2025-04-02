package com.acme.login;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String email;
    private String firstName;
    private String lastName;
    private Boolean newsletterOptIn;
    private OffsetDateTime createdAt;
    private String username;
    private String accessToken;
    private int expiresIn;
    private String refreshToken;

}
