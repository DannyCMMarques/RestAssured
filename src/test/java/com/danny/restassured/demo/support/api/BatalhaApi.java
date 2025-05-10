package com.danny.restassured.demo.support.api;

import com.danny.restassured.demo.support.config.helper.RequestHelper;
import com.danny.restassured.demo.support.domain.BatalhaRequestDTO;

import io.restassured.response.Response;

public class BatalhaApi {

    private static final String BASE_BATALHA = "/v1/batalha";

    public Response iniciarBatalha(BatalhaRequestDTO batalhaRequest) {
    return RequestHelper.withAuth()
            .body(batalhaRequest)
            .when()
            .post(BASE_BATALHA);
}
    public Response buscarBatalhaPorId(Long batalhaId) {
        return RequestHelper.withAuth()
                .pathParam("id", batalhaId)
                .when()
                .get(BASE_BATALHA + "/{id}");
    }

    public Response deletarBatalha(Long batalhaId) {
        return RequestHelper.withAuth()
                .pathParam("id", batalhaId)
                .when()
                .delete(BASE_BATALHA + "/{id}");
    }

    public Response listarBatalhas() {
        return RequestHelper.withAuth()
                .when()
                .get(BASE_BATALHA);
    }

    public Response atualizarBatalha(Long batalhaId, BatalhaRequestDTO batalhaRequest) {
        return RequestHelper.withAuth()
                .pathParam("id", batalhaId)
                .body(batalhaRequest)
                .when()
                .put(BASE_BATALHA + "/{id}");
    }

    public Response iniciarBatalhaComJsonInvalido(String rawJson) {
        return RequestHelper.withAuth()
                .body(rawJson)
                .contentType("application/json")
                .when()
                .post(BASE_BATALHA);
    }
}
