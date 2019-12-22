package com.gbk.hybrid.qa.ui.steplib;

import com.gbk.hybrid.qa.ui.pages.IndexPage;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionWebClient extends ScenarioSteps {

    IndexPage indexPage;

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


}
