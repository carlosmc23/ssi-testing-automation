package org.umssdiplo.automationv01.core.managepage.Projects.Project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectCreate extends BasePage {

    @FindBy(xpath = "//span[contains(text(), ' REGISTER NEW PROJECT')]")
    private WebElement registerNewProject;

    @FindBy(name = "name")
    private WebElement nameProject;

    @FindBy(name = "descriptions")
    private WebElement descriptionProject;

    @FindBy(name = "location")
    private WebElement locationProject;

    @FindBy(name = "init")
    private WebElement initDateProject;

    @FindBy(name = "end")
    private WebElement endDateProject;

    @FindBy(id = "projectCreate")
    private WebElement createButon;

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon")
    private WebElement lastIcon;

    public void gotToNewProjectForm() {
        CommonEvents.clickButton(registerNewProject);
    }

    public void nameProjectTextBox(String name) {
        CommonEvents.setInputField(nameProject, name);
        nameProject.clear();
        CommonEvents.setInputField(nameProject, name);
        nameProject.clear();
        CommonEvents.setInputField(nameProject, name);
    }

    public void descriptionProjectTexBox(String description) {
        descriptionProject.clear();
        CommonEvents.setInputField(descriptionProject, description);
    }

    public void locationProjectTextBox(String location) {
        locationProject.clear();
        CommonEvents.setInputField(locationProject, location);
    }

    public void initDateProjectTextBox(String initDate) {
        initDateProject.clear();
        CommonEvents.setInputField(initDateProject, initDate);
    }

    public void endDateProjectTextBox(String endDate) {
        endDateProject.clear();
        CommonEvents.setInputField(endDateProject, endDate);
    }

    public void selectButonCreate() {
        CommonEvents.clickButton(createButon);
    }

    public void aceptAfirmationProjectAlert() {
        CommonEvents.aceptAlert();
    }

    public void openLastRow() {
        CommonEvents.clickButton(lastIcon);
    }

}
