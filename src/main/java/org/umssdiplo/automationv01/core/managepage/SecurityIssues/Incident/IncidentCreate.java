package org.umssdiplo.automationv01.core.managepage.SecurityIssues.Incident;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class IncidentCreate extends BasePage {

    @FindBy(xpath = "//span[contains(text(), ' REGISTER NEW INCIDENT')]")
    private WebElement registerNewIncident;

    @FindBy(name = "descriptions")
    private WebElement descriptionsIncident;

    @FindBy(name = "observations")
    private WebElement observationIncident;

    @FindBy(name = "Date")
    private WebElement dateIncident;

    @FindBy(name = "witness")
    private WebElement witnessIncident;

    @FindBy(name = "incidentplace")
    private WebElement indicentPlace;

    @FindBy(css = "mat-select[name='cataloge']")
    private WebElement catalogOption;

    @FindBy(css = "mat-select[name='employeee']")
    private WebElement employeeOption;

    @FindBy(id = "createIncident")
    private WebElement createButon;

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon")
    private WebElement lastIcon;

    public void goToNewIncidentForm() {
        CommonEvents.clickButton(registerNewIncident);
    }

    public void descriptionsIncidentTextBox(String descIncident) {
        CommonEvents.setInputField(descriptionsIncident, descIncident);
        descriptionsIncident.clear();
        CommonEvents.setInputField(descriptionsIncident, descIncident);
        descriptionsIncident.clear();
        CommonEvents.setInputField(descriptionsIncident, descIncident);
    }

    public void observationsIncidentTexBox(String obsIncident) {
        observationIncident.clear();
        CommonEvents.setInputField(observationIncident, obsIncident);
    }

    public void dateIncidentTextBox(String datIncident) {
        dateIncident.clear();
        CommonEvents.setInputField(dateIncident, datIncident);
    }

    public void witnessIncidentTextBox(String witIncident) {
        witnessIncident.clear();
        CommonEvents.setInputField(witnessIncident, witIncident);
    }

    public void incidentPlaceTextBox(String placeIncident) {
        indicentPlace.clear();
        CommonEvents.setInputField(indicentPlace, placeIncident);
    }

    public void selectCatalogIncident(String catalog) {
        CommonEvents.clickButton(catalogOption);
        WebElement selectCatalog = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//span[contains(text(),' " + catalog + " ')]"));
        CommonEvents.clickButton(selectCatalog);
    }

    public void selectEmployee(String employee) {
        CommonEvents.clickButton(employeeOption);
        WebElement selectEmployee = ManageDriver.getInstance().getWebDriver().
                findElement(By.xpath("//span[contains(text(),' " + employee + " ')]"));
        CommonEvents.clickButton(selectEmployee);
    }

    public void selectButonCreate() {
        CommonEvents.clickButton(createButon);
    }

    public void openLastRow() {
        CommonEvents.clickButton(lastIcon);
    }

}
