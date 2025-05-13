package com.danny.restassured.demo.support.api;

import com.danny.restassured.demo.support.config.helper.RequestHelper;
import com.danny.restassured.demo.support.domain.ParticipanteBatalhaRequestDTO;

import io.restassured.response.Response;

public class ParticipanteBatalhaApi {

    private static final String BASE = "/v1/participante-batalha";

    public Response cadastrarParticipante(ParticipanteBatalhaRequestDTO dto) {
        return RequestHelper.withAuth()
                .body(dto)
                .when()
                .post(BASE);
    }

    public Response deletarParticipante(Long id) {
        return RequestHelper.withAuth()
                .pathParam("id", id)
                .when()
                .delete(BASE + "/{id}");
    }

    public Response buscarParticipantePorId(Long id) {
        return RequestHelper.withAuth()
                .pathParam("id", id)
                .when()
                .get(BASE + "/{id}");
    }

    public Response listarParticipantes() {
        return RequestHelper.withAuth()
                .when()
                .get(BASE);
    }

    public Response atualizarParticipante(Long id, ParticipanteBatalhaRequestDTO dto) {
        return RequestHelper.withAuth()
                .pathParam("id", id)
                .body(dto)
                .when()
                .put(BASE + "/{id}");
    }

}
