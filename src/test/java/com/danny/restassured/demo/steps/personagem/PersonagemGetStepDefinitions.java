package com.danny.restassured.demo.steps.personagem;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.PersonagemApi;
import com.danny.restassured.demo.support.config.helper.RequestHelper;
import com.danny.restassured.demo.support.domain.personagem.PersonagemRequest;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class PersonagemGetStepDefinitions {
    private final PersonagemApi personagemApi;

    public PersonagemGetStepDefinitions(PersonagemApi personagemApi) {
        this.personagemApi = personagemApi;
    }

    private PersonagemRequest personagemEsperado;
    private Response response;
    private Long personagemIdCriado;
    private Long personagemIdParaBusca;

    @Dado("que exista um personagem salvo com ID {long}")
    public void dadoQueExistaUmPersonagemSalvoComID(Long id) {
        personagemIdParaBusca = id;
    }

    @Dado("que o ID {long} não esteja associado a nenhum personagem")
    public void dadoQueOIdNaoEstejaAssociadoNenhumPersonagem(Long id) {
        personagemIdParaBusca = id;
    }

    @Quando("eu envio uma requisição GET com esse ID")
    public void euEnvioUmaRequisicaoGETComEsseID() {
        response = personagemApi.buscarPersonagem(personagemIdParaBusca);
    }

    @Então("o personagem correspondente é retornado")
    public void oPersonagemCorrespondenteERetornado() {
        response.then().statusCode(HttpStatus.OK.value());
        assertEquals(personagemIdParaBusca,
                response.jsonPath().getLong("id"));
    }

    @Então("a API deve retornar erro de não encontrado")
    public void aApiDeveRetornarErroDeNaoEncontrado() {
        String message = response.jsonPath().getString("message");
        assertNotNull(message, "Esperava mensagem de 'not found' no message");
        assertEquals("Personagem não encontrado", message);
    }

    @Quando("eu envio uma requisição GET para listar os personagens")
    public void euEnvioUmaRequisicaoGETParaListarOsPersonagens() {
        response = personagemApi.buscarTodosPersonagens();
    }

    @Então("a API retorna a lista de personagens")
    public void apiRetornaListaDePersonagens() {
        response.then().statusCode(HttpStatus.OK.value());
        assertNotNull(response.jsonPath().getList("content"));
    }

    @Quando("eu envio uma requisição GET para listar personagens com parâmetros inválidos")
    public void euEnvioGetComParametrosInvalidos() {
        response = RequestHelper.withAuth()
                .queryParam("page", -1)
                .queryParam("size", 0)
                .when()
                .get("/v1/personagens");
    }

    @Então("a API deve retornar erro de requisição inválida")
    public void apiRetornaErroListagem() {
        response.then().statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Dado("que existam personagens salvos no sistema")
    public void que_existam_personagens_salvos_no_sistema() {
        personagemEsperado = PersonagemRequest.builder().nome("Personagem Teste").build();
        response = personagemApi.criarPersonagem(personagemEsperado);

        if (response.statusCode() == HttpStatus.CREATED.value()) {
            personagemIdCriado = response.jsonPath().getLong("id");
        }

        assertEquals(HttpStatus.CREATED.value(), response.statusCode());
    }

    @Então("a API deve retornar a lista de personagens com sucesso")
    public void a_api_deve_retornar_a_lista_de_personagens_com_sucesso() {
        response.then().statusCode(HttpStatus.OK.value());
        assertNotNull(response.jsonPath().getList("content"));
    }

    @After
    public void apagarPersonagemCriado() {
        if (personagemIdCriado != null) {
            personagemApi.deletarPersonagem(personagemIdCriado);
        }
    }

}
