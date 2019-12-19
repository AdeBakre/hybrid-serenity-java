package com.gbk.hybrid.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IndexPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexPage.class);

    @FindBy(css = "table>tbody>tr")
    private List<WebElementFacade>  tableRows;

    @FindBy(xpath = "//a[text()='Watchlist']")
    private WebElementFacade watchListTab;

    @FindBy(xpath = "//span[text()='Cryptocurrencies']")
    private WebElementFacade cryptoTab;

    @FindBy(css = ".cmc-popover__dropdown")
    private WebElementFacade cryptoDropDownList;

    @FindBy(css = ".cmc-table-listing__pagination a:nth-child(2)")
    private WebElementFacade viewAllButton;

}
