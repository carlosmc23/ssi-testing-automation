package org.umssdiplo.automationv01.core.customwebdriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Firefox implements CustomWebDriver {
    @Override
    public WebDriver generateWebDriver() {
        return new FirefoxDriver();
    }

    @Override

    public WebDriver generateRemoteWebDriver(String seleniumHub) throws MalformedURLException {
        Capabilities capabilities = DesiredCapabilities.firefox();
        return new RemoteWebDriver(new URL(seleniumHub), capabilities);
    }
}
