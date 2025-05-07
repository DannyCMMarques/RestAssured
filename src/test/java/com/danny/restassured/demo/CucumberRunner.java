package com.danny.restassured.demo;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "com.danny.restassured.demo.bdd.automation.api.steps"
)
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty"
)
public class CucumberRunner {
}