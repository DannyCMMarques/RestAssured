package com.danny.restassured.demo.steps;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.ParticipanteBatalhaApi;
import com.danny.restassured.demo.support.domain.ParticipanteBatalhaRequestDTO;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class ParticipanteBatalhaStepDefinitions {

    private final ParticipanteBatalhaApi api;
    private ParticipanteBatalhaRequestDTO request;
    private Response response;
    private Long participanteIdCriado;

    public ParticipanteBatalhaStepDefinitions(ParticipanteBatalhaApi api) {
        this.api = api;
    }

    @Dado("que eu tenha os dados corretos de um participante em uma batalha existente")
    public void dadosValidos() {
        request = ParticipanteBatalhaRequestDTO.builder().build();
    }

    @Dado("que eu informe um ID de batalha que não existe")
    public void batalhaInexistente() {
        request = ParticipanteBatalhaRequestDTO.builder().batalha(9999L).build();
    }

    @Dado("que eu envie uma requisição com campos obrigatórios em branco ou nulos")
    public void dadosAusentes() {
        request = ParticipanteBatalhaRequestDTO.builder()
                .batalha(null)
                .nomeUsuario(null)
                .personagem(null)
                .playerOrder(null)
                .vencedor(null)
                .build();
    }

    @Quando("eu envio uma requisição POST para cadastrar o participante")
    public void envioPost() {
        response = api.cadastrarParticipante(request);
        if (response.statusCode() == HttpStatus.CREATED.value()) {
            participanteIdCriado = response.jsonPath().getLong("id");
        }
    }

    @Então("o participante da batalha é registrado com sucesso")
    public void sucesso() {
        response.then().statusCode(HttpStatus.CREATED.value());
        assertNotNull(response.jsonPath().getLong("id"));
    }

    @Então("a API deve retornar erro de batalha informada não encontrado")
    public void erroNaoEncontrado() {
        response.then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Então("a API deve retornar erro de validação dos participantes da batalha")
    public void erroValidacao() {
        response.then().statusCode(HttpStatus.NOT_FOUND.value());
        assertNotNull(response.jsonPath().getString("message"));
    }

    @Dado("que exista um participante previamente cadastrado")
    public void existeParticipante() {
        request = ParticipanteBatalhaRequestDTO.builder().build();
        response = api.cadastrarParticipante(request);
        response.then().statusCode(HttpStatus.CREATED.value());
        participanteIdCriado = response.jsonPath().getLong("id");
    }

    @Dado("que o ID 9999 não esteja associado a nenhum participante")
    public void idParticipanteInexistente() {
    }

    @Quando("eu envio uma requisição GET para buscar o participante por ID")
    public void envioGetPorId() {
        Long id = participanteIdCriado != null ? participanteIdCriado : 9999L;
        response = api.buscarParticipantePorId(id);
    }

    @Então("os dados do participante são retornados com sucesso")
    public void dadosParticipanteRetornados() {
        response.then().statusCode(HttpStatus.OK.value());
        assertEquals(request.getNomeUsuario(),
                response.jsonPath().getString("nomeUsuario"));
    }

    @Então("a API deve retornar erro de participante não encontrado")
    public void erroParticipanteNaoEncontrado() {
        response.then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Quando("eu envio uma requisição DELETE para excluir o participante")
    public void envioDelete() {
        Long id = participanteIdCriado != null ? participanteIdCriado : 9999L;
        response = api.deletarParticipante(id);
    }

    @Então("o participante é excluído com sucesso")
    public void participanteExcluido() {
        response.then().statusCode(HttpStatus.NO_CONTENT.value());
        participanteIdCriado = null;
    }

    @After
    public void limparParticipanteCriado() {
        if (participanteIdCriado != null) {
            api.deletarParticipante(participanteIdCriado);
        }
    }
}
