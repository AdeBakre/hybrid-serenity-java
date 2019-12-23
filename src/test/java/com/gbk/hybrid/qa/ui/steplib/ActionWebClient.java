package com.gbk.hybrid.qa.ui.steplib;

import com.gbk.hybrid.qa.ui.pages.IndexPage;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionWebClient extends ScenarioSteps {

    IndexPage indexPage;
    List<String> currencyNames = new ArrayList<>();
    String currencyName;

    @Before
    public void go_to_main_page(){

        indexPage.openPage();
    }

    @Step
    public void user_clicks_on_view_all(){

        indexPage.click_view_all();

        assertThat(
                indexPage.return_current_url()
        ).contains("views/all");
    }

    @Step
    public void verify_number_of_rows(int rowsExpected){

        assertThat(
                indexPage.check_rows_displayed()
        ).isGreaterThanOrEqualTo(rowsExpected);

    }

    @Step
    public void select_random_currencies_and_add_to_watchlist() {

        indexPage.select_random_cryptocurrency();
        currencyName = indexPage.get_cryptocurrency_name();
        currencyNames.add(currencyName);
        indexPage.openContextMenu();
        indexPage.add_cryptocurrency_to_watchlist();

        //TODO - Create more than one item to be added to watch list as multiple makes it flakey
//        Random random = new Random();
//        int randomNumber =  4 + random.nextInt(5);;
//        System.out.println(randomNumber);
//
//        for(int a=0;a<=randomNumber;a++){
//
//            indexPage.select_random_cryptocurrency();
//            currencyName = indexPage.get_cryptocurrency_name();
//            System.out.println(currencyName);
//            currencyNames.add(currencyName);
//            indexPage.openContextMenu();
//            indexPage.add_cryptocurrency_to_watchlist();
//
//
//        }


    }

    @Step
    public void open_different_tab(String menu){

        indexPage.openNewTabInWindows(menu);
    }

    @Step
    public void verify_stored_currencies_names_with_amended(){

        assertThat(
            indexPage.get_name_of_all_currencies_displayed().equals(currencyNames)
        ).isTrue();
    }

    @Step
    public void user_clicks_on_full_list_filter(String filterName, String tabName){

        indexPage.select_tab_by_label(tabName);
        indexPage.clickOnContextMenuOption(filterName);

        //Get list of all the currency names for future comparison
        currencyNames = indexPage.get_name_of_all_currencies_displayed();
    }

    @Step
    public void filter_applied_to_table_data(){


        indexPage.select_top_filter();

    }

}
