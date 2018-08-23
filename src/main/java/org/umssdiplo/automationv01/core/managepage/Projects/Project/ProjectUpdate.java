package org.umssdiplo.automationv01.core.managepage.Projects.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectUpdate extends BasePage {

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon")
    private WebElement lastIcon;

    @FindBy(id = "projectUpdate")
    private WebElement updateButon;

    @FindBy(id = "updateProject")
    private WebElement updateButonTwo;

    public void selectProjectLabel(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement selectAffliction = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//tr[ td[contains(text(),'" + label + "')] ]//mat-icon"));
        CommonEvents.clickButton(selectAffliction);
    }

    public void SelectProjectUpdateButton() {
        CommonEvents.clickButton(updateButon);
    }

    public void selectUpdateButonTwo() {
        CommonEvents.clickButton(updateButonTwo);
    }

}


