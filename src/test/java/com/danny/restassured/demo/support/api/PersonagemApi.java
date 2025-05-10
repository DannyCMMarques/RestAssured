
package com.danny.restassured.demo.support.api;

import com.danny.restassured.demo.support.config.helper.RequestHelper;
import com.danny.restassured.demo.support.domain.personagem.PersonagemRequest;

import io.restassured.response.Response;

public class PersonagemApi {

    private static final String BASE_PERSONAGENS = "/v1/personagens";

    public Response criarPersonagem(PersonagemRequest personagemRequest) {
        return RequestHelper.withAuth()
                .body(personagemRequest)
                .when()
                .post(BASE_PERSONAGENS);
    }

    public Response deletarPersonagem(Long personagemId) {
        return RequestHelper.withAuth()
                .pathParam("id", personagemId)
                .when()
                .delete(BASE_PERSONAGENS + "/{id}");
    }

    public Response buscarPersonagem(Long personagemId) {
        return RequestHelper.withAuth()
                .pathParam("id", personagemId)
                .when()
                .get(BASE_PERSONAGENS + "/{id}");
    }

    public Response atualizarPersonagem(Long personagemId, PersonagemRequest personagemRequest) {
        return RequestHelper.withAuth()
                .pathParam("id", personagemId)
                .body(personagemRequest)
                .when()
                .put(BASE_PERSONAGENS + "/{id}");
    }

    public Response buscarTodosPersonagens() {
        return RequestHelper.withAuth()
                .when()
                .get(BASE_PERSONAGENS);
    }
}
