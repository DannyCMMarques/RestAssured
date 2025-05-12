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

public class PersonagemPutStepDefinitions {
    private final PersonagemApi personagemApi;

    public PersonagemPutStepDefinitions(PersonagemApi personagemApi) {
        this.personagemApi = personagemApi;
    }

    private PersonagemRequest personagemEsperado;
    private Response response;
    private Long personagemIdCriado;
    private Long personagemIdParaBusca;
    private PersonagemRequest personagemInexistente;

    @Dado("que exista um personagem salvo que eu queira atualizar personagem")
    public void que_eu_tenha_novos_dados_válidos_para_esse_personagem() {
        personagemEsperado = PersonagemRequest.builder()
                .nome("Naruto Para atualização")    
                .idade(25L)
                .aldeia("Konoha")
                .especialidade("NINJUTSU")
                .build();

        Response responseCriacao = personagemApi.criarPersonagem(personagemEsperado);
        responseCriacao.then().statusCode(HttpStatus.CREATED.value());

        personagemIdCriado = responseCriacao.jsonPath().getLong("id");
    }
    @Dado("que eu tenha dados válidos para atualizar um personagem inexistente")
    public void preparar_dados_para_personagem_inexistente() {
        personagemInexistente = PersonagemRequest.builder()
                .nome("Sasuke Inexistente")
                .idade(22L)
                .aldeia("Konoha")
                .especialidade("GENJUTSU")
                .build();
    }
    @Quando("eu envio uma requisição PUT com o ID e os dados atualizados")
    public void eu_envio_uma_requisição_put_com_o_id_e_os_dados_atualizados() {
        personagemEsperado.setNome("Naruto Uzumaki Atualizado"); // <- ajuste aqui
        response = personagemApi.atualizarPersonagem(personagemIdCriado, personagemEsperado);
    }
    @Então("o personagem é atualizado com sucesso")
    public void personagemAtualizadoComSucesso() {
        response.then().statusCode(HttpStatus.OK.value());
        assertEquals("Naruto Uzumaki Atualizado", response.jsonPath().getString("nome"));
    }

    @Quando("eu tento atualizar um personagem com ID inexistente")
    public void euTentoAtualizarPersonagemComIdInexistente() {

        response = personagemApi.atualizarPersonagem(9999L, personagemInexistente);
    }

    @Então("a API deve retornar erro de não encontrado ao atualizar")
    public void apiRetornaErroAtualizacao() {
        response.then().statusCode(HttpStatus.NOT_FOUND.value());
        String mensagem = response.jsonPath().getString("message");
        assertNotNull(mensagem);
        assertEquals("Personagem não encontrado", mensagem);
    }

    @After
    public void apagarPersonagemCriado() {
        if (personagemIdCriado != null) {
            personagemApi.deletarPersonagem(personagemIdCriado);
        }
    }
}
