package com.gbk.hybrid.qa;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class CustomProperties {

    private static String getProperty(String key){
        EnvironmentVariables vars = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();
        return vars.getProperty(key);
    }


    public static String getApiBaseUrl() {
        return getProperty("rest.api.base.url");
    }

    public static String getWebDriverBaseUri(){return getProperty("webdriver.base.url");}

    public static String getBrowser(){return getProperty("browser.name");}

    public static String getVersion(){return getProperty("version");}



}
