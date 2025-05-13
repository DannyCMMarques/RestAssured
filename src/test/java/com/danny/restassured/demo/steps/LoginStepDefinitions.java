package com.danny.restassured.demo.steps;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.LoginApi;
import com.danny.restassured.demo.support.domain.LoginRequest;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class LoginStepDefinitions {

    private Response response;
    private LoginRequest loginRequest;

    @Dado("que eu possua um e-mail e senha válidos")
    public void queEuPossuaEmailESenhaValidos() {
        loginRequest = LoginRequest.builder().build();
    }

    @Dado("que eu possua um e-mail válido e uma senha incorreta")
    public void queEuPossuaEmailValidoESenhaIncorreta() {
        loginRequest = LoginRequest.builder().senha("senhaerrada").build();
    }

    @Quando("eu envio uma requisição POST para o login")
    public void euEnvioRequisicaoPOSTParaLogin() {
        response = LoginApi.autenticar(loginRequest);
    }

    @Então("a autenticação é realizada com sucesso")
    public void autenticacaoRealizadaComSucesso() {
        response.then().statusCode(HttpStatus.OK.value());
        String token = response.jsonPath().getString("token");
        assertNotNull(token, "Esperava receber um token JWT");
        assertFalse(token.isEmpty(), "Token não deve ser vazio");
    }

    @Então("a API deve retornar erro de autenticação")
    public void apiDeveRetornarErroDeAutenticacao() {
        response.then().statusCode(HttpStatus.UNAUTHORIZED.value());
    }
}
