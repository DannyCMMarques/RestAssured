package com.danny.restassured.demo.support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    @Builder.Default
    private String email = "joao.silva@example.com";
    @Builder.Default
    private String senha = "senhaSecreta123";

}
