package com.danny.restassured.demo.support.api;


import static io.restassured.RestAssured.*;

import com.danny.restassured.demo.support.domain.PersonagemRequest;

import io.restassured.response.Response;

public class PersonagemApi {

    private static final String BASE_PERSONAGENS = "api/v1/personagens";

    public Response criarPersonagem(PersonagemRequest personagemRequest) {
        return given()
            .body(personagemRequest)
        .when()
            .post(BASE_PERSONAGENS);
            
    }
}
