package com.gbk.hybrid.util;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigProperties {

    private static final EnvironmentVariables VARS = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigProperties.class);

    public static String getBaseUrl(){ return getProperty("webdriver.base.url");}


    private static String getProperty(String property) {
        if (!property.isEmpty())
            return VARS.getProperty(property);

        String msg = property + " must be provided.";
        LOGGER.error(msg);
        throw new RuntimeException(msg);
    }
}
