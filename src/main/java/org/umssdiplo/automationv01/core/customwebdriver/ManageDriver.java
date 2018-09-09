package org.umssdiplo.automationv01.core.customwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.umssdiplo.automationv01.core.utils.BrowserType;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.*;
import java.util.concurrent.TimeUnit;

public class ManageDriver {
    private static final String SELENIUM_HUB_URL = System.getProperty("selenium_hub_url");
    private static final int IMPLICIT_TIME_WAIT = PropertyAccessor.getInstance().getImplicitTimeWait();
    private static final int EXPLICIT_TIME_WAIT = PropertyAccessor.getInstance().getExplicitTimeWait();
    private static ManageDriver instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private ManageDriver() {
        BrowserType driverType = BrowserType.valueOf(PropertyAccessor.getInstance().getBrowser());

        if (SELENIUM_HUB_URL.equals("")) {
            webDriver = DriverFactory.getManageDriver(driverType);
            //webDriver.manage().window().maximize();
        }
        else {
            try {
                webDriver = DriverFactory.getRemoteDriver(driverType, SELENIUM_HUB_URL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ManageDriver getInstance() {
        if (instance == null) {
            instance = new ManageDriver();
        }
        return instance;
    }

    public WebDriver getWebDriver() {

        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        webDriverWait = new WebDriverWait(getInstance().getWebDriver(),IMPLICIT_TIME_WAIT);
        return webDriverWait;
    }

    public void restorePreviousTimeWait() {
        setImplicitTimeWait(IMPLICIT_TIME_WAIT);
        setExplicitTimeWait(EXPLICIT_TIME_WAIT);
    }

    public void setImplicitTimeWait(int implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }

    public void setExplicitTimeWait(int explicitTimeWait) {
        webDriverWait = new WebDriverWait(webDriver, explicitTimeWait);
    }
}
