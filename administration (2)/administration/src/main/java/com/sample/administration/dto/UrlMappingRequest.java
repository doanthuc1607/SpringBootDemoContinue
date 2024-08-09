package com.sample.administration.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlMappingRequest {
    private String originalLink;
}
