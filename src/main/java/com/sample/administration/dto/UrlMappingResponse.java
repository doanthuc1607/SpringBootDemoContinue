package com.sample.administration.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlMappingResponse {
    private int id;
    private String originalLink;
    private String shortLink;

}
