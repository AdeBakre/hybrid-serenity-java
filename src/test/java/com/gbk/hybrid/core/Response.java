package com.gbk.hybrid.core;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.HashMap;

public class Response {

    private int statusCode;
    private String body;
    private HashMap<String, String> headers;

    public Response(int statusCode, String body, Headers headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = new HashMap<>();
        for (Header header : headers)
            this.headers.put(header.getName(), header.getValue());
    }

    /**
     * Get the headers of the response
     *
     * @return the headers hashmap
     */
    public HashMap<String, String> getHeaders() {
        return headers;
    }

    /**
     * Get the status code of the response
     *
     * @return the status code of the response
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Get the body of the response
     *
     * @return the body of the response
     */
    public String getBody() {
        return body;
    }
}
