package org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectAssigDelete extends BasePage {

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon[contains(text(),'delete')]")
    private WebElement deleteicon;

    public void iconDelete() {
        CommonEvents.clickButton(deleteicon);
    }

}
