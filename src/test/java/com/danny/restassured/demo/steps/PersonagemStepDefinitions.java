package com.danny.restassured.demo.steps;

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

public class PersonagemStepDefinitions {
    private final PersonagemApi personagemApi;

    public PersonagemStepDefinitions(PersonagemApi personagemApi) {
        this.personagemApi = personagemApi;
    }

    private PersonagemRequest personagemEsperado;
    private Response response;
    private Long personagemIdCriado;
    private Long personagemIdParaBusca;


    @After
    public void apagarPersonagemCriado() {
        if (personagemIdCriado != null) {
            personagemApi.deletarPersonagem(personagemIdCriado);
        }
    }



}
