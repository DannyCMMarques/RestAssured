package com.danny.restassured.demo.support.api;

import static io.restassured.RestAssured.*;

import com.danny.restassured.demo.support.domain.LoginRequest;

import io.restassured.response.Response;


public class LoginApi {
 private static final String LOGIN_ENDPOINT = "/v1/login"; // ajuste se necessário

    public static Response autenticar(LoginRequest login) {

        return given()
                .contentType("application/json")
                .body(login)
        .when()
                .post(LOGIN_ENDPOINT);
        
    }

    
}
