package com.gbk.hybrid.qa.ui.core;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import net.thucydides.core.webdriver.exceptions.ElementNotVisibleAfterTimeoutError;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.time.Duration.ofSeconds;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

/***
 * Bespoke methods to act as wrappers for some existing functions
 */

public class PageObject extends net.serenitybdd.core.pages.PageObject {

    private Select select;
    private String message;
    private final long TIMEOUT = 90;


    public void selectByValue(WebElement element) {
        select = new Select(element);
        WebElement opt = select.getOptions().parallelStream().distinct().findAny().get();
        select.selectByValue(opt.getAttribute("value"));
    }

    public WebElementFacade waitUntilVisible(WebElement element) {
        return waitUntilVisible(element, TIMEOUT);
    }

    public boolean isDisplayed(WebElement element, long timeout) {
        try {
            return waitFor(element).withTimeoutOf(ofSeconds(timeout)).waitUntilVisible().isDisplayed();
        } catch (NotFoundException | TimeoutException | StaleElementReferenceException  | ElementNotVisibleException | ElementNotFoundAfterTimeoutError err) {
            //LOG.info(format("%s wasn't visible after %s seconds", element, timeout));
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        return isDisplayed(element, TIMEOUT);
    }

    public WebElementFacade waitUntilVisible(WebElement element, long timeout) {
        try {
            return waitFor(element).withTimeoutOf(ofSeconds(timeout)).waitUntilVisible();
        } catch ( NotFoundException | StaleElementReferenceException | ElementNotVisibleException | TimeoutException | ElementNotFoundAfterTimeoutError | ElementNotVisibleAfterTimeoutError err) {
            message = format("Unable to locate element(%s), due to %s", element, err.getCause());
            //LOG.error(message);
            throw new NoSuchElementException(message);
        }
    }

    public void click(List<WebElement> elements) {
        try {
            elements.stream().findAny().ifPresent(WebElement::click);
        } catch (ElementNotInteractableException err) {
            message = format("Unable to locate elements(%s), due to %s", elements, err.getCause());
            //LOG.error(message);
            throw new NoSuchElementException(message);
        }
    }

    public void click(List<WebElement> elements, String value) {
        try {
            elements.stream().filter(
                    e -> equalsIgnoreCase(e.getText(), value) || equalsIgnoreCase(e.getAttribute("value"), value)
            ).findAny().ifPresent(WebElement::click);
        } catch (ElementNotInteractableException err) {
            message = format("Unable to locate element(%s), due to %s", value, err.getCause());
            //LOG.error(message);
            throw new NoSuchElementException(message);
        }
    }

    public void click(WebElement element) {
        try {
            waitUntilVisible(element).waitUntilClickable().click();
        } catch (ElementNotInteractableException err) {
            message = format("Unable to interact with element(%s), due to %s", element, err.getCause());
            //LOG.error(message);
            throw new NoSuchElementException(message);
        }
    }

    public void openNewTabInWindows(String linkName){

        //Get system OS first to determine if we use control or command. Only for PC or Mac OS
        String osName = System.getProperty("os.name");
        if(osName.contains("Mac OS X")){
            String selectLinkOpenInNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN);
            getDriver().findElement(By.linkText(linkName)).sendKeys(selectLinkOpenInNewTab);

        }
        else{
            String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            getDriver().findElement(By.linkText(linkName)).sendKeys(selectLinkOpenInNewTab);
        }

        //Store the number of tabs to allow us navigate to the one of our choice
        ArrayList<String> allOpenTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(allOpenTabs.get(1));
    }
}
