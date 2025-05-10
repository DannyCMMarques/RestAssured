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

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        ServerConfig properties = ConfigManager.getConfiguration();

        RestAssured.baseURI = String.format("%s:%d", properties.baseURI(), properties.port());
        RestAssured.basePath = properties.basePath();

        RestAssured.requestSpecification = new RequestSpecBuilder()
        .setContentType(ContentType.JSON)
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .build();
    }

}