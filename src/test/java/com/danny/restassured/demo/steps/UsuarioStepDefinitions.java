package com.danny.restassured.demo.steps;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

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
    private Long usuarioIdCriado2;
    private UsuarioRequest usuarioRequest;
    private Response response;
    private final UsuarioApi usuarioApi;

    public UsuarioStepDefinitions(UsuarioApi usuarioApi) {
        this.usuarioApi = usuarioApi;
    }

    @Dado("que eu tenha nome, email e senha válidos")
    public void queEuTenhaNomeEmailSenhaValidos() {
        String email = "user+" + System.currentTimeMillis() + "@example.com";
        usuarioRequest = UsuarioRequest.builder()
                .email(email)
                .nome("Nome Teste")
                .senha("Senha123!")
                .build();
    }

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
        assertEquals(usuarioRequest.getEmail(),
                response.jsonPath().getString("email"));
    }

    @Dado("que exista um usuário previamente registrado")
    public void queExistaUmUsuarioPreviamenteRegistrado() {
        queEuTenhaNomeEmailSenhaValidos();
        Response resp = usuarioApi.cadastrarUsuario(usuarioRequest);
        resp.then().statusCode(HttpStatus.CREATED.value());
        usuarioIdCriado = resp.jsonPath().getLong("id");
    }

    @Quando("eu envio uma requisição GET para buscar o usuário por ID")
    public void euEnvioRequisicaoGetPorId() {
        response = usuarioApi.buscarUsuario(usuarioIdCriado != null ? usuarioIdCriado : 0L);
    }

    @Então("os dados do usuário são retornados com sucesso")
    public void dadosUsuarioRetornadosComSucesso() {
        response.then().statusCode(HttpStatus.OK.value());
        assertEquals(usuarioRequest.getEmail(),
                response.jsonPath().getString("email"));
    }

    @Quando("eu envio uma requisição DELETE para excluir o usuário")
    public void euEnvioRequisicaoDelete() {
        response = usuarioApi.deletarUsuario(usuarioIdCriado != null ? usuarioIdCriado : 0L);
    }

    @Então("o usuário é excluído com sucesso")
    public void usuarioExcluidoComSucesso() {
        response.then().statusCode(HttpStatus.NO_CONTENT.value());
        usuarioIdCriado = null; 
    }

    @Dado("que o ID 9999 não esteja associado a nenhum usuário")
    public void idInexistenteParaUsuario() {
    }

    @Quando("eu envio uma requisição GET para buscar o usuário por ID inexistente")
    public void envioGetUsuarioPorIdInexistente() {
        response = usuarioApi.buscarUsuario(9999L);
    }

    @Quando("eu envio uma requisição DELETE para excluir o usuário inexistente")
    public void envioDeleteUsuarioInexistente() {
        response = usuarioApi.deletarUsuario(9999L);
    }

    @Então("a API deve retornar erro de não encontrado para o usuário")
    public void apiRetornaErroNotFoundUsuario() {
        response.then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Quando("eu envio uma requisição GET para listar os usuários com parâmetros inválidos")
    public void envioGetListarUsuariosParametrosInvalidos() {
        response = usuarioApi.buscarTodosUsuariosComParametrosInvalidos();
    }

    @Então("a API usuário deve retornar erro de requisição inválida")
    public void apiRetornaErroRequisicaoInvalida() {
        response.then()
                .statusCode(anyOf(is(HttpStatus.BAD_REQUEST.value()),
                        is(HttpStatus.INTERNAL_SERVER_ERROR.value())));
    }

    @After
    public void apagarUsuariosCriados() {
        if (usuarioIdCriado != null) {
            usuarioApi.deletarUsuario(usuarioIdCriado);
            usuarioIdCriado = null;
        }
        if (usuarioIdCriado2 != null) {
            usuarioApi.deletarUsuario(usuarioIdCriado2);
            usuarioIdCriado2 = null;
        }
    }
}
