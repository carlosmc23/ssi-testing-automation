package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Home extends BasePage {


    @FindBy(xpath = "//div[@class='mat-card-header-text']/mat-card-title[contains(text(),' Security Issues ')]")
    private WebElement securityIssues;

    @FindBy(xpath = "//span[contains(text(),' Home')]")
    private WebElement homeHeader;

    @FindBy(xpath = "//div[@class='mat-card-header-text']/mat-card-title[contains(text(),' Projects ')]")
    private WebElement projects;

    @FindBy(xpath = "//div[@class='mat-card-header-text']/mat-card-title[contains(text(),'Security Items')]")
    private WebElement securityItems;

    public void goToSecurityIssues() {
        CommonEvents.clickButton(securityIssues);
    }

    public void goToHome() {
        CommonEvents.clickButton(homeHeader);
    }


    public void goToProjects() {
        CommonEvents.clickButton(projects);
    }
    public void goSecurityItems() {
        CommonEvents.clickButton(securityItems);
    }

}
