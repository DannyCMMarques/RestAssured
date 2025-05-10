package com.danny.restassured.demo.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;

import com.danny.restassured.demo.support.api.UsuarioApi;
import com.danny.restassured.demo.support.domain.UsuarioRequest;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class UsuarioStepDefinitions {

    private Long usuarioIdCriado;
    private UsuarioRequest usuarioRequest;
    private Response response;
    private UsuarioApi usuarioApi;

    public UsuarioStepDefinitions(UsuarioApi usuarioApi) {
        this.usuarioApi = usuarioApi;
    }

    @Dado("que eu tenha nome, email e senha válidos")
    public void queEuTenhaNomeEmailSenhaValidos() {
        usuarioRequest = UsuarioRequest.builder().build();
    }

    // @Dado("que eu tenha um nome e senha válidos mas um email inválido")
    // public void queEuTenhaNomeSenhaValidosMasEmailInvalido() {
    //     usuarioRequest = UsuarioRequest.builder()
    //             .email("emailinvalido123")
    //             .nome("Nome Válido")
    //             .senha("SenhaVálida123")
    //             .build();
    // }

    // @Dado("que eu envie nome, email e senha em branco")
    // public void queEuEnvieCamposEmBranco() {
    //     usuarioRequest = UsuarioRequest.builder()
    //             .nome(null)
    //             .email(null)
    //             .senha(null)
    //             .build();
    // }

    @Quando("eu envio uma requisição POST para cadastrar o usuário")
    public void euEnvioRequisicaoPostParaCadastrarUsuario() {
        response = usuarioApi.cadastrarUsuario(usuarioRequest);
        if (response.statusCode() == HttpStatus.CREATED.value()) {
            usuarioIdCriado = response.jsonPath().getLong("id");
        }
    }

    @Então("o usuário é criado com sucesso")
    public void usuarioCriadoComSucesso() {
        response.then().statusCode(HttpStatus.CREATED.value());
        assertEquals(usuarioRequest.getEmail(), response.jsonPath().getString("email"));
    }

    // @Então("a API deve retornar erro")
    // public void apiRetornaErroValidacao() {
    //     int statusCode = response.statusCode();
    //     System.out.println("Resposta da API: " + response.getBody().asPrettyString());
    
    //     if (statusCode != HttpStatus.BAD_REQUEST.value()) {
    //         System.err.println("⚠️ Código inesperado: " + statusCode);
    //     }
    
    //     assertEquals(HttpStatus.BAD_REQUEST.value(), statusCode);
    // }

    @After
    public void apagarUsuarioCriado() {
        if (usuarioIdCriado != null) {
            usuarioApi.deletarUsuario(usuarioIdCriado);
        }
    }
}