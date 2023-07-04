package com.example.demo.project2.views;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtRequest {

    private  String email;

    private String password;
}
