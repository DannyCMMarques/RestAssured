package com.danny.restassured.demo.support.api;

import static io.restassured.RestAssured.*;

import com.danny.restassured.demo.support.config.helper.RequestHelper;
import com.danny.restassured.demo.support.domain.UsuarioRequest;

import io.restassured.response.Response;

public class UsuarioApi {

    private final String BASE_USUARIOS = "/v1/usuarios";

    public Response cadastrarUsuario(UsuarioRequest usuarioRequest) {
        return given()
                .body(usuarioRequest)
                .when()
                .post(BASE_USUARIOS + "/registro");
    }

    public Response buscarTodosUsuarios() {
        return RequestHelper.withAuth()
                .when()
                .get(BASE_USUARIOS);
    }

    public Response buscarUsuario(Long usuarioId) {
        return RequestHelper.withAuth()
                .pathParam("id", usuarioId)
                .when()
                .get(BASE_USUARIOS + "/{id}");
    }

    public Response atualizarUsuario(Long usuarioId, UsuarioRequest usuarioRequest) {
        return RequestHelper.withAuth()
                .pathParam("id", usuarioId)
                .body(usuarioRequest)
                .when()
                .put(BASE_USUARIOS + "/{id}");
    }

    public Response deletarUsuario(Long usuarioId) {
        return RequestHelper.withAuth()
                .pathParam("id", usuarioId)
                .when()
                .delete(BASE_USUARIOS + "/{id}");
    }
}
