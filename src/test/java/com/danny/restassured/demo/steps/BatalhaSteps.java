package com.danny.restassured.demo.steps;
import io.cucumber.java.pt.Quando;

public class BatalhaSteps {

    @Quando("eu envio uma requisição POST vazia para o cadastro de batalha")
    public void enviarRequisicaoPostVaziaParaCadastroDeBatalha() {
        // Implementação do envio de uma requisição POST vazia
        System.out.println("Enviando requisição POST vazia para o cadastro de batalha...");
        // Aqui você pode adicionar o código para enviar a requisição usando RestAssured ou outra biblioteca
    }
}