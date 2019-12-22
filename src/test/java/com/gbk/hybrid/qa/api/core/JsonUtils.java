package com.gbk.hybrid.qa.api.core;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;



import static java.lang.String.format;

public class JsonUtils {

    /**
     * Helper method to assist with response json formatting
     * @param response
     * @return
     */
    public static JsonPath getJsonPath(ResponseBodyExtractionOptions response){
        return new JsonPath(response.jsonPath().prettify());
    }

    /**
     * Helper method that takes in response as well as hardcorded element type of symbol
     * @param response
     * @param member
     * @return
     */
    public static Object getJsonObject(ResponseBodyExtractionOptions response, String member){

        return getJsonPath(response).getList(format("data.findAll {it.symbol == '%s'}.id",member)).stream().findAny().get();
    }


}
