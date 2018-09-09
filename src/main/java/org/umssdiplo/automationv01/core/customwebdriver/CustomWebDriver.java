package org.umssdiplo.automationv01.core.customwebdriver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface CustomWebDriver {

    WebDriver generateWebDriver();
    WebDriver generateRemoteWebDriver(String hub) throws MalformedURLException;
}

