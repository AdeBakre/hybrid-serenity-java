package com.gbk.hybrid.qa.ui.core;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.DriverManagerType;
import net.thucydides.core.webdriver.DriverSource;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.safari.SafariDriverService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.gbk.hybrid.qa.CustomProperties.*;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;
import static java.lang.String.format;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public class CustomWebDriver implements DriverSource {

    protected static Scenario scenario;
    private WebDriver driver;
    private DriverService driverService;
    private String browser = getBrowser();


    @Before
    public void setUp(Scenario scenario){
        CustomWebDriver.scenario = scenario;
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Override
    public WebDriver newDriver(){
        MutableCapabilities capabilities = new MutableCapabilities();
        setCapabilites(capabilities);
        setDriverService(browser);
        startDriverService();

        driver = new RemoteWebDriver(driverService.getUrl(),capabilities);
        return driver;
    }

    @Override
    public boolean takesScreenshots() { return true; }

    private void setCapabilites(@NotNull MutableCapabilities capabilities){

        capabilities.setCapability(BROWSER_NAME, browser);
    }

    /**
     * Method to get the drivers from the cloud instead of local install
     * @param browser
     */
    private void setDriverService(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                setDriverManager(CHROME,"https://chromedriver.storage.googleapis.com/");
                driverService = ChromeDriverService.createDefaultService();
                break;
            case "firefox":
                setDriverManager(FIREFOX, "https://api.github.com/repos/mozilla/geckodriver/releases/");
                driverService = GeckoDriverService.createDefaultService();
                break;
            case "safari":
                driverService = SafariDriverService.createDefaultService();
                break;
            default:
                throw new IllegalArgumentException(format("%s is unsupported, kindly try chrome or firefox.", browser));
        }
    }

    private void startDriverService() {
        try {
            driverService.start();
        } catch (IOException exc) {
            String message = format("Unable to start driver service, due to %s", exc.getMessage());
            //LOG.error(message);
            throw new UnreachableBrowserException(message);
        }
    }

    private void setDriverManager(DriverManagerType driverManagerType, String downloadUrl){
        try{
            getInstance(driverManagerType)
                    .driverRepositoryUrl(new URL(downloadUrl))
                    .version(getVersion())
                    .avoidOutputTree()
                    .setup();
        }
        catch (MalformedURLException exc){
            throw new UnreachableBrowserException(format("%s is not supported. Please try a browser like chrome or firefox.",browser));
        }
    }

}
