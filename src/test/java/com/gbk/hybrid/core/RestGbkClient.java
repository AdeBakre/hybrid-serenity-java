package com.gbk.hybrid.core;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.steps.ScenarioSteps;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.reset;
import static io.restassured.http.ContentType.JSON;

public class RestGbkClient extends ScenarioSteps{

    public static RequestSpecification getRequest(String path){
        reset();
        return given().relaxedHTTPSValidation().contentType(JSON).baseUri(path);
    }

    public static Response put(Request request){
        ExtractableResponse response = RestAssured.given()
                .contentType(request.getContentType())
                .headers(request.getHeaders())
                .queryParams(request.getQueryParams())
                .pathParams(request.getPathParams())
                .body(request.getBody())
                .log().all()
                .put(request.getVersion() + request.getPath())
                .then()
                .log().all()
                .extract();

        Response resp = new Response(response.statusCode(), response.body().asString(), response.headers());

        return resp;

    }

    public static Response get(Request request) {
        ExtractableResponse response = RestAssured.given()
                .contentType(request.getContentType())
                .urlEncodingEnabled(true)
                .headers(request.getHeaders())
                .queryParams(request.getQueryParams())
                .pathParams(request.getPathParams())
                .log().all()
                .get(request.getVersion() + request.getPath())
                .then()
                .log().all()
                .extract();
        Response resp = new Response(response.statusCode(), response.body().asString(), response.headers());
        return resp;
    }


}
