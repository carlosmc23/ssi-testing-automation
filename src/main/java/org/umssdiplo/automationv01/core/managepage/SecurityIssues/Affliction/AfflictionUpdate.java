package org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AfflictionUpdate extends BasePage {

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon")
    private WebElement lastIcon;

    @FindBy(id = "afflictionUpdate")
    private WebElement updateButon;

    @FindBy(id = "updateAfflictionn")
    private WebElement updateButonTwo;


    public void selectAfflictionLabel(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement selectAffliction = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//tr[ td[contains(text(),'" + label + "')] ]//mat-icon"));
        CommonEvents.clickButton(selectAffliction);
    }

    public void SelectAfflictionUpdateButton() {
        CommonEvents.clickButton(updateButon);
    }

    public void selectUpdateButonTwo() {
        CommonEvents.clickButton(updateButonTwo);
    }

}


