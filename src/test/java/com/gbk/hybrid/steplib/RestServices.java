package com.gbk.hybrid.steplib;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.steps.ScenarioSteps;



import java.util.Objects;
import java.util.Properties;

import static net.serenitybdd.rest.SerenityRest.given;

public class RestServices extends ScenarioSteps {

    private Properties prop = new Properties();

    private RequestSpecification getRequest(String endpoint){

        String url = prop.getProperty("ap_base_uri") + endpoint.toLowerCase();

        RestAssured.reset();
        return given().relaxedHTTPSValidation().contentType(prop.getProperty("content-type")).baseUri(url).log().all(true);
    }

//    ResponseBodyExtractionOptions getResponse(String endpoint){
//
//        return getRequest(endpoint).when().get().then().statusCode()
//    }



}
