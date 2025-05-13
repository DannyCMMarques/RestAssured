package com.danny.restassured.demo.steps.personagem;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.PersonagemApi;
import com.danny.restassured.demo.support.domain.personagem.PersonagemRequest;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class PersonagemDeleteStepDefinitions {
    private final PersonagemApi personagemApi;

    public PersonagemDeleteStepDefinitions(PersonagemApi personagemApi) {
        this.personagemApi = personagemApi;
    }

    private PersonagemRequest personagemEsperado;
    private Response response;
    private Long personagemIdCriado;

    @Então("o personagem é excluído com sucesso")
    public void personagemExcluidoComSucesso() {
        response.then().statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Quando("eu tento excluir um personagem com ID inexistente")
    public void euTentoExcluirPersonagemComIdInexistente() {
        response = personagemApi.deletarPersonagem(9999L);
    }

    @Então("a API deve retornar erro de não encontrado ao excluir")
    public void apiRetornaErroExclusao() {
        response.then().statusCode(HttpStatus.NOT_FOUND.value());
        String mensagem = response.jsonPath().getString("message");
        assertNotNull(mensagem);
        assertEquals("Personagem não encontrado", mensagem);
    }

    @Quando("eu envio uma requisição DELETE com esse ID")
    public void eu_envio_uma_requisicao_delete_com_esse_id() {
        response = personagemApi.deletarPersonagem(personagemIdCriado);
    }

    @Então("o personagem é removido com sucesso")
    public void o_personagem_e_removido_com_sucesso() {
        response.then().statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Dado("que exista um personagem salvo para exclusão")
    public void que_exista_um_personagem_salvo_para_exclusao() {
        String nomeUnico = "PersonagemExcluir" + System.currentTimeMillis();

        personagemEsperado = PersonagemRequest.builder()
                .nome(nomeUnico)
                .idade(18L)
                .aldeia("Areia")
                .especialidade("TAIJUTSU")
                .build();

        Response responseCriacao = personagemApi.criarPersonagem(personagemEsperado);
        assertEquals(HttpStatus.CREATED.value(), responseCriacao.statusCode());

        personagemIdCriado = responseCriacao.jsonPath().getLong("id");
    }

}
