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

public class BatalhaStepDefinitions {

    private final BatalhaApi batalhaApi;

    private BatalhaRequestDTO batalhaRequest;
    private String jsonInvalido;
    private Response response;
    private Long batalhaIdCriada;

    public BatalhaStepDefinitions(BatalhaApi batalhaApi) {
        this.batalhaApi = batalhaApi;
    }

    @Dado("que o sistema é responsável por preencher os dados da batalha")
    public void queSistemaPreencheAutomaticamente() {
        batalhaRequest = BatalhaRequestDTO.builder()
                .criadoEm(null)
                .finalizadoEm(null)
                .status(null)
                .build();

    }

    @Dado("que eu envie dados não permitidos ou malformados no corpo da requisição")
    public void queEnvieDadosInvalidos() {
        jsonInvalido = "{ \"status\": 12345 }";
    }

    @Quando("eu envio uma requisição POST vazia para o cadastro de batalha")
    public void envioPostVazioCadastro() {
        response = batalhaApi.iniciarBatalha(batalhaRequest);
        if (response.statusCode() == HttpStatus.CREATED.value()) {
            batalhaIdCriada = response.jsonPath().getLong("id");
        }
    }

    @Quando("eu envio uma requisição POST para cadastrar a batalha")
    public void envioPostComDadosInvalidos() {
        response = batalhaApi.iniciarBatalhaComJsonInvalido(jsonInvalido);
    }

    @Então("a batalha é registrada automaticamente com sucessoso")
    public void batalhaRegistradaComSucesso() {
        response.then().statusCode(HttpStatus.CREATED.value());
        assertEquals("NAO_INICIADA", response.jsonPath().getString("status"));
        assertNotNull(response.jsonPath().getString("criadoEm"));
    }

    @Então("a API deve retornar erro de validação para batalha")
    public void apiRetornaErroValidacao() {
        response.then().statusCode(HttpStatus.BAD_REQUEST.value());
        String detalhe = response.jsonPath().getString("detail");
        assertNotNull(detalhe, "Esperava 'detail' na resposta de erro.");
    }

}