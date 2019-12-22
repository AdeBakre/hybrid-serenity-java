package com.gbk.hybrid.qa.ui.pages;

import com.gbk.hybrid.qa.CustomProperties;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class IndexPage extends PageObject {


    @FindBy(css = ".cmc-table-listing .cmc-table.sc-1yv6u5n-0")
    private WebElementFacade cmcTableListing;

    @FindBy(css = ".cmc-cryptocurrency-listing-tabs .cmc-tabs__header .cmc-popover__trigger span")
    private List<WebElementFacade> tabs;

    @FindBy(css = ".cmc-table-listing__pagination .cmc-link")
    private List<WebElementFacade> cmcTableLinks;

    @FindBy(css = ".cmc-table__table-wrapper-outer tbody .cmc-table-row")
    private List<WebElementFacade> cmcCryptocurrencyRows;


    @FindBy(css = "table>tbody>tr")
    List<WebElementFacade>  tableRows;

    @FindBy(xpath = "//a[text()='Watchlist']")
    WebElementFacade watchListTab;

    @FindBy(xpath = "//span[text()='Cryptocurrencies']")
    WebElementFacade cryptoTab;

    @FindBy(css = ".cmc-popover__dropdown")
    WebElementFacade cryptoDropDownList;

    @FindBy(css = ".cmc-table-listing__pagination a:nth-child(2)")
    WebElementFacade viewAllButton;

    @FindBy(css = ".row.cmc-view-all-coins__select-control")
    WebElementFacade viewAllSelectControl;

    public void openPage(){
        openUrl(CustomProperties.getWebDriverBaseUri());
    }

    public void click_view_all(){

        viewAllButton.click();
        waitFor(viewAllSelectControl).waitUntilClickable();
    }

    public String return_current_url(){


        return getDriver().getCurrentUrl();
    }

    public int check_rows_displayed(){

        return tableRows.size();
    }



//    }

}
