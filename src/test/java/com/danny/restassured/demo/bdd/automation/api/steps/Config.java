package com.danny.restassured.demo.bdd.automation.api.steps;



import io.cucumber.java.Before;

import com.danny.restassured.demo.bdd.automation.api.support.config.ConfigManager;
import com.danny.restassured.demo.bdd.automation.api.support.config.ServerConfig;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class Config {

    // private final UserApi userApi;
    // private final PetApi petApi;

    // public Config() {
    //     this.userApi = new UserApi();
    //     this.petApi = new PetApi();
    // }

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        ServerConfig properties = ConfigManager.getConfiguration();

        RestAssured.baseURI = String.format("%s:%d", properties.baseURI(), properties.port());
        RestAssured.basePath = properties.basePath();

        RestAssured.requestSpecification = new RequestSpecBuilder()
            .addHeader("Authorization", getToken())
            .setContentType(ContentType.JSON)
            .build();
    }

    private String getToken() {
        return "grant access"; 
    }

    // @After("@deleteAllUsers")
    // public void deleteAllUsers() {
    //     userApi.deleteAllUsers();
    // }
}