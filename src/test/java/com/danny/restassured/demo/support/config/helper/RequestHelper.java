package com.danny.restassured.demo.support.config.helper;

import static io.restassured.RestAssured.*;

import com.danny.restassured.demo.support.api.LoginApi;
import com.danny.restassured.demo.support.domain.LoginRequest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestHelper {

    private static String cachedToken;

    public static RequestSpecification withAuth() {
        if (cachedToken == null) {
            cachedToken = getToken();
        }

        return given()
                .header("Authorization", "Bearer " + cachedToken)
                .contentType("application/json");
    }

    public static RequestSpecification withoutAuth() {
        return given()
                .contentType("application/json");
    }

    private static String getToken() {
        LoginRequest loginRequest = LoginRequest.builder().build();

        Response response = LoginApi.autenticar(loginRequest);
        return response.jsonPath().getString("token");
    }
}
