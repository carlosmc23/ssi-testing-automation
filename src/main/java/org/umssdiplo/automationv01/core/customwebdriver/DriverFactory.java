package org.umssdiplo.automationv01.core.customwebdriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.umssdiplo.automationv01.core.utils.BrowserType;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private DriverFactory(){}

    public static WebDriver getManageDriver(BrowserType browserType){
        Map<BrowserType, CustomWebDriver> pickupDriver = new HashMap<>();
        pickupDriver.put(BrowserType.CHROME, new Chrome());
        pickupDriver.put(BrowserType.FIREFOX, new Firefox());

        return pickupDriver.get(browserType).generateWebDriver();
    }
    public static WebDriver getRemoteDriver(BrowserType browserType, String url) throws MalformedURLException {
        Map<BrowserType, CustomWebDriver> pickupDriver = new HashMap<>();
        pickupDriver.put(BrowserType.CHROME, new Chrome());
        pickupDriver.put(BrowserType.FIREFOX, new Firefox());

        return pickupDriver.get(browserType).generateRemoteWebDriver(url);
    }
}
