package com.danny.restassured.demo.steps.personagem;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.PersonagemApi;
import com.danny.restassured.demo.support.domain.personagem.PersonagemRequest;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class PersonagemPostStepDefinitions {

    private final PersonagemApi personagemApi;

    public PersonagemPostStepDefinitions(PersonagemApi personagemApi) {
        this.personagemApi = personagemApi;
    }

    private PersonagemRequest personagemEsperado;
    private Response response;
    private Long personagemIdCriado;

    @Dado("que eu possua um nome, idade, aldeia e especialidade para o personagem")
    public void queEuPossuaUmNomeIdadeAldeiaESpecialidadeParaOPersonagem() {

        personagemEsperado = PersonagemRequest.builder().build();
    }

    @Então("o personagem é criado com sucesso")
    public void oPersonagemECriadoComSucesso() {

        response.then().statusCode(HttpStatus.CREATED.value());
        assertEquals(personagemEsperado.getNome(), response.jsonPath().getString("nome"));

    }

    @Dado("que eu envie dados ausentes, malformados ou não permitidos para o personagem")
    public void dadoQueEnvieDadosInvalidosParaOPersonagem() {
        personagemEsperado = PersonagemRequest.builder()
                .nome(null)
                .idade(-1L)
                .aldeia("")
                .especialidade("XYZ")
                .build();
    }

    @Então("a API deve retornar erro de validação")
    public void aApiDeveRetornarErroDeValidacao() {
        response.then().statusCode(HttpStatus.BAD_REQUEST.value());
        String detail = response.jsonPath().getString("detail");
        assertNotNull(detail);
        assertFalse(detail.isEmpty(), "Esperava mensagem de erro de validação, mas veio vazia");
    }

    @Quando("eu envio uma requisição POST para criar o personagem")
    public void euEnvioUmaRequisicaoPOSTParaCriarOPersonagem() {
        response = personagemApi.criarPersonagem(personagemEsperado);
        if (response.statusCode() == HttpStatus.CREATED.value()) {
            personagemIdCriado = response.jsonPath().getLong("id");
        }
    }

    @After
    public void apagarPersonagemCriado() {
        if (personagemIdCriado != null) {
            personagemApi.deletarPersonagem(personagemIdCriado);
        }
    }

}
