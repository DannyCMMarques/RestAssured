package com.danny.restassured.demo.support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipanteBatalhaRequestDTO {
   
    @Builder.Default
    private Long batalha = 1L;

    @Builder.Default
    private String nomeUsuario = "João Silva";

    @Builder.Default
    private String personagem = "Naruto Uzumaki" ;

    @Builder.Default
    private Integer playerOrder = 1;

    @Builder.Default
    private Boolean vencedor = false;
}
