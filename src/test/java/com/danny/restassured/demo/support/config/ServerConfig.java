package com.danny.restassured.demo.support.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/application.properties")

public interface ServerConfig extends Config {
    @Key("api.base.uri")
    String baseURI();

    @Key("api.base.path")
    String basePath();

    int port();
}