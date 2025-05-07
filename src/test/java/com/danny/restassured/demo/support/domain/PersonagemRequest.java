package com.danny.restassured.demo.support.domain;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PersonagemRequest {
 
    @Builder.Default
    private String nome = "Naruto Uzumaki" ;

    @Builder.Default
    private Long idade = 16L;

    @Builder.Default
    private String aldeia = "Konoha";

    @Builder.Default
    private String especialidade ="NINJUTSU";

}
