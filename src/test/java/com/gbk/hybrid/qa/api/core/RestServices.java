package com.gbk.hybrid.qa.api.core;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.reset;
import static net.serenitybdd.rest.SerenityRest.given;


import static io.restassured.http.ContentType.JSON;


public class RestServices {


    private static RequestSpecification request;

    /**
     * Method for request with contentType set as default
     * @param headers
     * @param baseUri
     */
    public static void request(Map<String, ?> headers, String baseUri){
        reset();
        request = given().relaxedHTTPSValidation().contentType(JSON).headers(headers).baseUri(baseUri).when();
    }

    /**
     * This gets the response and we expect it to be ok(hardcoded) when request is made
     * @param path
     * @return
     */
    public static ValidatableResponse get(String path){
        return request.get(path).then().assertThat().statusCode(200);
    }


}
