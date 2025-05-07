package com.danny.restassured.demo.steps;

import com.danny.restassured.demo.support.config.ConfigManager;
import com.danny.restassured.demo.support.config.ServerConfig;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class Config {

    // private final UserApi userApi;
    // private final PetApi petApi;

    // public Config() {
    // this.userApi = new UserApi();
    // this.petApi = new PetApi();
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
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    private String getToken() {
        return "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiVVNFUiIsImNyZWF0ZWRfYXQiOjE3NDY2NDM3ODQzNTIsInN1YiI6ImpvYW8uc2lsdmFAZXhhbXBsZS5jb20iLCJpYXQiOjE3NDY2NDM3ODQsImV4cCI6MTc0NjczMDE4NH0.Zx84PRPH9WayfAwp1mayCsf56IpCczaqbmI5Opq80hg";
    }

    // @After("@deleteAllUsers")
    // public void deleteAllUsers() {
    // userApi.deleteAllUsers();
    // }
}