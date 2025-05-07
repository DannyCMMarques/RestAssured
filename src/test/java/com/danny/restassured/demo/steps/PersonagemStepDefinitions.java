package com.danny.restassured.demo.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.PersonagemApi;
import com.danny.restassured.demo.support.domain.PersonagemRequest;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

public class PersonagemStepDefinitions {
    private final PersonagemApi personagemApi;

    public PersonagemStepDefinitions(PersonagemApi personagemApi) {
        this.personagemApi = personagemApi;
    }
    private PersonagemRequest personagemEsperado; 
    private Response response;

@Dado("^que eu possua um nome, idade, aldeia e especialidade para o personagem$")
public void queEuPossuaUmNomeIdadeAldeiaESpecialidadeParaOPersonagem() {
        System.out.println(">> Step foi chamado!");

        personagemEsperado = PersonagemRequest.builder().build();
    }
   
    @Quando("eu envio uma requisição POST para criar o personagem")
    public void euEnvioUmaRequisicaoPOSTParaCriarOPersonagem() {
    response = personagemApi.criarPersonagem(personagemEsperado);
    }

    @Então("o personagem é criado com sucesso")
    public void oPersonagemECriadoComSucesso() {

         response.then().statusCode(HttpStatus.CREATED.value());
         assertEquals(personagemEsperado.getNome(), response.jsonPath().getString("nome"));
     
    }


}
