package com.sample.administration.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    private String username;
    private String password;
}