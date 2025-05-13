package com.danny.restassured.demo.steps.batalha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.BatalhaApi;
import com.danny.restassured.demo.support.domain.BatalhaRequestDTO;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class BatalhaGetStepDefinitions {

    private final BatalhaApi batalhaApi;

    private BatalhaRequestDTO batalhaRequest;
    private Response response;
    private Long batalhaIdCriada;

    public BatalhaGetStepDefinitions(BatalhaApi batalhaApi) {
        this.batalhaApi = batalhaApi;
    }

    @Dado("que exista uma batalha previamente registrada")
    public void queExistaUmaBatalhaPreviamenteRegistrada() {
        batalhaRequest = BatalhaRequestDTO.builder()
                .criadoEm(null)
                .finalizadoEm(null)
                .status(null)
                .build();

        Response respostaCriacao = batalhaApi.iniciarBatalha(batalhaRequest);
        respostaCriacao.then().statusCode(HttpStatus.CREATED.value());
        batalhaIdCriada = respostaCriacao.jsonPath().getLong("id");
    }

    @Quando("eu envio uma requisição GET para buscar a batalha pelo ID")
    public void euEnvioGetBatalhaPorId() {
        response = batalhaApi.buscarBatalhaPorId(batalhaIdCriada);
    }

    @Então("a batalha correspondente deve ser retornada com sucesso")
    public void batalhaPorIdComSucesso() {
        response.then().statusCode(HttpStatus.OK.value());
        assertEquals(batalhaIdCriada, response.jsonPath().getLong("id"));
        assertNotNull(response.jsonPath().getString("status"));
    }

}