package com.gbk.hybrid.qa.api.steplib;


import com.gbk.hybrid.qa.api.core.RestServices;
import com.gbk.hybrid.qa.api.pojo.Currency;
import com.gbk.hybrid.qa.CustomProperties;
import com.gbk.hybrid.qa.api.core.JsonUtils;

import cucumber.api.java.Before;
import io.restassured.response.ResponseBodyExtractionOptions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RegExUtils;

import static org.apache.commons.lang3.StringUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

import static java.lang.String.format;


public class ActionRestClient extends ScenarioSteps{


    private ResponseBodyExtractionOptions currentResponse;
    private String currencyCode;
    private static String cryptoMapPath = "cryptocurrency/map";
    Map<String, String> headers = new HashMap<>();
    private List<String> tagsExist = new ArrayList<>();
    private Object item;


    @Before
    public void setUpRestSession(){
        headers.put("X-CMC_PRO_API_KEY",System.getenv("X-CMC_PRO_API_KEY"));
        RestServices.request(headers, CustomProperties.getApiBaseUrl());
    }


    @Step
    public void retrieve_Id_For_CryptoCurrency(String symbol) {

        currentResponse = RestServices.get(cryptoMapPath).extract();
        item = JsonUtils.getJsonObject(currentResponse, symbol);

    }

    @Step
    public void convert_currency(String amount, String currency){

        currencyCode = Currency.valueOf(upperCase(RegExUtils.replaceAll(currency," ","_"))).getCode();
        currentResponse = RestServices.get(format("tools/price-conversion?id=%s&amount=%s&convert=%s",item, amount, currencyCode)).extract();

    }

    @Step
    public void verify_that_currency_is_converted(boolean expected){

        assertThat(
                isNotBlank(Float.toString(JsonUtils.getJsonPath(currentResponse).get(format("data.quote.%s.price",currencyCode))))
        ).isEqualTo(expected);

    }

    @Step
    public void retrieve_currency_info(String currencyId){
        currencyCode = currencyId;
        currentResponse = RestServices.get(format("cryptocurrency/info?id=%s",currencyCode)).extract();
    }

    @Step
    public void verify_that_currency_info_contains(String key, String value){
        assertThat(
                containsIgnoreCase(JsonUtils.getJsonPath(currentResponse).get(format("data.%s.%s", currencyCode,key)).toString(),value)
        ).isTrue();
    }

    @Step
    public void verify_that_cryptocurrency_info_is_null(String key){
        assertThat(
                isEmpty(JsonUtils.getJsonPath(currentResponse).get(format("data.%s.%s", currencyCode, key)))
        ).isTrue();
    }



}
