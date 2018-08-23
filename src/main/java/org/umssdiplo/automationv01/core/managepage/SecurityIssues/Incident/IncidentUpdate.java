package org.umssdiplo.automationv01.core.managepage.SecurityIssues.Incident;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class IncidentUpdate extends BasePage {

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon")
    private WebElement lastIcon;

    @FindBy(id = "incidentUpdate")
    private WebElement updateButon;

    @FindBy(id = "updateIncident")
    private WebElement updateButonTwo;

    public void selectIncidentLabel(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement selectAffliction = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//tr[ td[contains(text(),'" + label + "')] ]//mat-icon"));
        CommonEvents.clickButton(selectAffliction);
    }

    public void SelectIncidentUpdateButton() {
        CommonEvents.clickButton(updateButon);
    }

    public void selectUpdateButonTwo() {
        CommonEvents.clickButton(updateButonTwo);
    }

}


