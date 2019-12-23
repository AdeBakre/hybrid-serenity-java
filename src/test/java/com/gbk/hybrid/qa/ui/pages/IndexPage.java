package com.gbk.hybrid.qa.ui.pages;

import com.gbk.hybrid.qa.CustomProperties;
import com.gbk.hybrid.qa.ui.core.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class IndexPage extends PageObject {


    @FindBy(css = ".cmc-cryptocurrency-listing-tabs .cmc-tabs__header .cmc-popover__trigger span")
    private List<WebElement> tabs;

    @FindBy(css = ".cmc-table-listing__pagination .cmc-link")
    private List<WebElement> cmcTableLinks;

    @FindBy(css = ".cmc-table__table-wrapper-outer tbody .cmc-table-row")
    private List<WebElement> cryptocurrencies;

    @FindBy(css = ".cmc-table__column-name>a")
    private List<WebElement> currencyTableNames;

    @FindBy(css = ".cmc-popover__dropdown .cmc-menu .cmc-link")
    private List<WebElement> menuOptions;

    @FindBy(css = ".cmc-select_menu .cmc-select_option")
    private List<WebElement> filterOptions;

    @FindBy(css = ".row.cmc-view-all-coins__select-control")
    WebElementFacade viewAllSelectControl;

    @FindBy(id = "#react-select-volume-input")
    private WebElement volumeInput;

    @FindBy(css = "div[id*=react-select-market-option")
    private List<WebElement> marketOptions;

    private WebElementFacade element;

    public void openPage(){

        openUrl(CustomProperties.getWebDriverBaseUri());

        if(isDisplayed(element = findBy("#cmc-cookie-policy-banner"))) {
            click((waitUntilVisible(element.thenFind(".cmc-cookie-policy-banner__close"))));
        }

        getDriver().manage().window().fullscreen();
    }

    public void click_view_all(){

        click(cmcTableLinks, "View All");
        waitFor(viewAllSelectControl).waitUntilClickable();
    }

    public String return_current_url(){

        return getDriver().getCurrentUrl();
    }

    public int check_rows_displayed(){

        return cryptocurrencies.size();
    }

    public void select_random_cryptocurrency(){

        element = waitUntilVisible(cryptocurrencies.parallelStream().unordered().findAny().orElseThrow(NoSuchElementException::new));
    }

    public void add_cryptocurrency_to_watchlist(){
        clickOnContextMenuOption("Add to Watchlist");
        //click_watchlist_link();

        waitABit(2500);
    }

    public void openContextMenu(){

        element.thenFind(".cmc-popover .fa-ellipsis-h").waitUntilClickable().click();
    }

    public void select_cryptocurrency_tab(){
        select_tab_by_label("Cryptocurrencies");
    }

    public String get_cryptocurrency_name(){

        return element.thenFind(".cmc-table__column-name .cmc-link").getText();
    }

    public void select_tab_by_label(String label) {
        click(tabs,label);
    }

    public void clickOnContextMenuOption(String option) {

        click(menuOptions, option);

        //Temp measures
        waitABit(5000);
    }

    public void select_top_filter(){

        //marketOptions.parallelStream().unordered().findAny().ifPresent(WebElement::click);
        waitABit(3000);
        findAll(".cmc-select__menu .cmc-select__option").parallelStream().distinct().findAny().ifPresent(WebElementFacade::click);
    }


    public void click_on_different_tab(String destinationUrl){

        openNewTabInWindows(destinationUrl);
    }

    public List<String> get_name_of_all_currencies_displayed(){

        List<String> watchlist_data = new ArrayList<>();

        for(WebElement element:currencyTableNames){

            String eachCurrency = element.getText();
            watchlist_data.add(eachCurrency);
        }

        return watchlist_data;
    }



}
