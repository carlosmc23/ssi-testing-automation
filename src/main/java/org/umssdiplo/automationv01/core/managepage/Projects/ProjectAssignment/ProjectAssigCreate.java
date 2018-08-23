package org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectAssigCreate extends BasePage {

    @FindBy(xpath = "//span[contains(text(),' Assignment Projects ')]")
    private WebElement AssigmentProjectsButon;

    @FindBy(id = "projecAssigCreate")
    private WebElement newProjectAssig;

    @FindBy(name = "init")
    private WebElement initDateAssig;

    @FindBy(name = "end")
    private WebElement endDateAssig;

    @FindBy(css = "mat-select[name='employeee']")
    private WebElement employeeSelect;

    @FindBy(css = "mat-select[name='projec']")
    private WebElement projectSelect;

    @FindBy(id = "projectAssigCreate")
    private WebElement createButon;

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]")
    private WebElement lastIcon;

    public void goToProjectAssigmentList() {
        CommonEvents.clickButton(AssigmentProjectsButon);
    }

    public void gotToNewProjectAssigForm() {
        CommonEvents.clickButton(newProjectAssig);
    }

    public void initDateProjectTextBox(String initDate) {
        CommonEvents.waitForElementIsVisible(employeeSelect);
        initDateAssig.clear();
        CommonEvents.setInputField(initDateAssig, initDate);
        initDateAssig.clear();
        CommonEvents.setInputField(initDateAssig, initDate);
        initDateAssig.clear();
        CommonEvents.setInputField(initDateAssig, initDate);
    }

    public void endDateProjectTextBox(String endDate) {
        endDateAssig.clear();
        CommonEvents.setInputField(endDateAssig, endDate);
    }

    public void selectEmployeeAssignment(String name) {
        CommonEvents.clickButton(employeeSelect);
        WebElement selectCatalog = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//span[contains(text(),' " + name + " ')]"));
        CommonEvents.clickButton(selectCatalog);
    }

    public void selectProjectAssignment(String project) {
        CommonEvents.clickButton(projectSelect);
        WebElement selectCatalog = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//span[contains(text(),' " + project + " ')]"));
        CommonEvents.clickButton(selectCatalog);
    }

    public void selectButonCreate() {
        CommonEvents.clickButton(createButon);
    }

    public void openLastRow() {
        CommonEvents.clickButton(lastIcon);
    }

}
