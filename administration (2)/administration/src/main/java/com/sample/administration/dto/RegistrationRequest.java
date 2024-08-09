package com.sample.administration.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private String username;
    private String password;
}
