package org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectAssigRead extends BasePage {

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]/td[2]")
    private WebElement employee;

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]/td[3]")
    private WebElement project;

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]/td[4]")
    private WebElement initDate;

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]/td[5]")
    private WebElement endDate;

    public String getEmployeeName() {
        return CommonEvents.getInnerText(employee);
    }

    public String getProjectName() {
        return CommonEvents.getInnerText(project);
    }

    public String getInitDate() {
        return CommonEvents.getInnerText(initDate);
    }

    public String getEndDate() {
        return CommonEvents.getInnerText(endDate);
    }


}
