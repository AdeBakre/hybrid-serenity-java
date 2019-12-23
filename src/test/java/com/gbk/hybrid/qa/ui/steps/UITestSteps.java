package com.gbk.hybrid.qa.ui.steps;

import com.gbk.hybrid.qa.ui.steplib.ActionWebClient;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class UITestSteps extends ScenarioSteps{

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

    @And("^user added a random number of crypto-currencies to the watchlist$")
    public void userAddedARandomNumberOfCryptoCurrenciesToTheWatchlist()  {

        actionWebClient.select_random_currencies_and_add_to_watchlist();
    }

    @When("^user clicks on the (.*) in a different tab$")
    public void userClicksOnTheWatchlistInADifferentTab(String dest) {

        actionWebClient.open_different_tab(dest);
    }

    @Then("^user should see the items previously added on the watchlist page$")
    public void userShouldSeeTheItemsPreviouslyAddedOnTheWatchlistPage() {

        actionWebClient.verify_stored_currencies_names_with_amended();
    }

    @And("^user selects the (.*) option from (.*) tab$")
    public void userSelectsTheFullListOption(String filterType, String tabName) {

        actionWebClient.user_clicks_on_full_list_filter(filterType,tabName);
    }

    @When("^user applies the filter for (.*)$")
    public void userAppliesTheFilterForPrice(String filter) {

        actionWebClient.filter_applied_to_table_data();
    }

    @Then("^the result displayed on the page should be different from full list option$")
    public void theResultDisplayedOnThePageShouldBeDifferentFromFullListOption() {

        actionWebClient.verify_stored_currencies_names_with_amended();
    }
}
