package org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectAssigUpdate extends BasePage {

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon")
    private WebElement lastIcon;

    @FindBy(id = "updateProjectAssignment")
    private WebElement updateButon;

    public void selectProjectAssignmentLabel(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement selectAssignment = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//tr[ td[contains(text(),'" + label + "')] ]//mat-icon[contains(text(),'edit')]"));
        CommonEvents.clickButton(selectAssignment);
    }

    public void selectUpdateButon() {
        CommonEvents.clickButton(updateButon);
    }

    public String getProjectAssignationEmployeeName(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement employeeAssgination = ManageDriver.getInstance().getWebDriver()
                .findElement(By.xpath("//tr[ td[contains(text(),' " + label + " ')] ]/td[2]"));
        CommonEvents.waitForElementIsVisible(employeeAssgination);
        return CommonEvents.getInnerText(employeeAssgination);
    }

    public String getProjectAssignationProjectName(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement projectAssignation = ManageDriver.getInstance().getWebDriver()
                .findElement(By.xpath("//tr[ td[contains(text(),' " + label + " ')] ]/td[3]"));
        CommonEvents.waitForElementIsVisible(projectAssignation);
        return CommonEvents.getInnerText(projectAssignation);
    }

    public String getProjectAssignationInitDate(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement initDateAssignation = ManageDriver.getInstance().getWebDriver()
                .findElement(By.xpath("//tr[ td[contains(text(),' " + label + " ')] ]/td[4]"));
        CommonEvents.waitForElementIsVisible(initDateAssignation);
        return CommonEvents.getInnerText(initDateAssignation);
    }

    public String getProjectAssignationEndDate(String label) {
        CommonEvents.waitForElementIsVisible(lastIcon);
        WebElement endDateAssignation = ManageDriver.getInstance().getWebDriver()
                .findElement(By.xpath("//tr[ td[contains(text(),' " + label + " ')] ]/td[5]"));
        CommonEvents.waitForElementIsVisible(endDateAssignation);
        return CommonEvents.getInnerText(endDateAssignation);
    }
}


