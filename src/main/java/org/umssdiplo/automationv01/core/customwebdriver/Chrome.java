package org.umssdiplo.automationv01.core.customwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Chrome implements CustomWebDriver {

    @Override
    public WebDriver generateWebDriver() {
        return new ChromeDriver();
    }

    @Override
    public WebDriver generateRemoteWebDriver(String seleniumHub) throws MalformedURLException {
        Capabilities capabilities = DesiredCapabilities.chrome();
        return new RemoteWebDriver(new URL(seleniumHub), capabilities);
    }
}
