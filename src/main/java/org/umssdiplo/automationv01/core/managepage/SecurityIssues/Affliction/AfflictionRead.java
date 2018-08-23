package org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AfflictionRead extends BasePage {

    @FindBy(id = "catalogName")
    private WebElement affCatalog;

    @FindBy(id = "afflictionName")
    private WebElement affName;

    @FindBy(id = "afflictionDescription")
    private WebElement affDescription;

    @FindBy(id = "afflictionObservation")
    private WebElement affObservation;

    @FindBy(id = "afflictionDate")
    private WebElement affDate;

    @FindBy(id = "employeeName")
    private WebElement affEmployee;

    public String getAfflictionCatalog() {
        return CommonEvents.getInnerText(affCatalog);
    }

    public String getAfflictionName() {
        return CommonEvents.getInnerText(affName);
    }

    public String getAfflictionDescription() {
        return CommonEvents.getInnerText(affDescription);
    }

    public String getAfflictionObservation() {
        return CommonEvents.getInnerText(affObservation);
    }

    public String getAfflictionDate() {
        return CommonEvents.getInnerText(affDate);
    }

    public String getEmployeeName() {
        return CommonEvents.getInnerText(affEmployee);
    }
}
