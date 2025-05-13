package com.danny.restassured.demo.support.domain.personagem;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonagemRequest {

    @Builder.Default
    private String nome = "Tsu";

    @Builder.Default
    private Long idade = 55L;

    @Builder.Default
    private String aldeia = "Konoha";

    @Builder.Default
    private String especialidade = "NINJUTSU";

}
