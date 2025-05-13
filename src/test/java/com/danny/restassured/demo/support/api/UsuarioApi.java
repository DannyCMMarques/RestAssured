package com.danny.restassured.demo.support.api;

import com.danny.restassured.demo.support.config.helper.RequestHelper;
import com.danny.restassured.demo.support.domain.UsuarioRequest;

import static io.restassured.RestAssured.given;
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


    public Response buscarTodosUsuariosComParametrosInvalidos() {
        return RequestHelper.withAuth()
                .queryParam("page", -1)
                .queryParam("size", -5)
                .queryParam("sortBy", "campoInvalido")
                .queryParam("direction", "ladoErrado")
                .when()
                .get(BASE_USUARIOS);
    }

    public Response buscarTodosUsuariosComParametrosValidos() {
        return RequestHelper.withAuth()
                .queryParam("page", 0)
                .queryParam("size", 10)
                .queryParam("sortBy", "id")
                .queryParam("direction", "asc")
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
