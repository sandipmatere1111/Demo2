package com.example.demo.project2.views;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    private String jwtToken;

    private String userName;
}
