package com.gbk.hybrid.qa.api.steps;

import com.gbk.hybrid.qa.api.steplib.ActionRestClient;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class BackEndTestsSteps extends ScenarioSteps{

    @Steps
    ActionRestClient actionRestClient;


    @Given("^user makes map request to retrieve id for (.*)$")
    public void userMakesMapRequestToRetrieveIdForSymbol(String cryptocurrency) throws Throwable {

        actionRestClient.retrieve_Id_For_CryptoCurrency(cryptocurrency);
    }

    @When("^user converts the amount of (.*) to currency (.*)$")
    public void userConvertsCryptocurrency(String amount, String currency) throws Throwable {

        actionRestClient.convert_currency(amount,currency);
    }

    @Then("^the conversion should be successful$")
    public void theConversionShouldBeSuccessful() throws Throwable {

        actionRestClient.verify_that_currency_is_converted(true);
    }


    @Given("^user request the cryptocurrency ID of (.*) displayed$")
    public void userRequestTheCryptocurrencyIDOfDisplayed(String id) throws Throwable {

        actionRestClient.retrieve_currency_info(id);
    }

    @Then("^the (.*) information should contain (.*)$")
    public void theInformationShouldContain(String attribute, String value) throws Throwable {

        actionRestClient.verify_that_currency_info_contains(attribute,value);
    }


    @And("^the (.*) information should be empty$")
    public void thePlatformInformationShouldBeEmpty(String attribute) throws Throwable {

        actionRestClient.verify_that_cryptocurrency_info_is_null(attribute);
    }

}
