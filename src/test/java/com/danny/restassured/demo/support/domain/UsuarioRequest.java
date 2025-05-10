package com.danny.restassured.demo.support.domain;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UsuarioRequest {

    @Builder.Default
    private String nome = "danielly";

    @Builder.Default
    private String email = "dannymarques@example.com";

    @Builder.Default
    private String senha = "senhaForte123";
}
