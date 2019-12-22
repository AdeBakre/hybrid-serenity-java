package com.gbk.hybrid.qa.ui.steps;

import com.gbk.hybrid.qa.ui.steplib.ActionWebClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class FrontEndTestsSteps extends ScenarioSteps{

    @Steps
    ActionWebClient actionWebClient;

    @Given("^user is on the main page$")
    public void userIsOnTheMainPage() throws Throwable {

        actionWebClient.go_to_main_page();
    }


    @When("^user clicks on view all$")
    public void userClicksOnViewAll() throws Throwable {

        actionWebClient.user_clicks_on_view_all();
    }

    @Then("^user should see results for at least (.*) currencies$")
    public void userShouldSeeResultsForAtLeastCurrencies(int rowsExpected) throws Throwable {

        actionWebClient.verify_number_of_rows(rowsExpected);

    }
}
