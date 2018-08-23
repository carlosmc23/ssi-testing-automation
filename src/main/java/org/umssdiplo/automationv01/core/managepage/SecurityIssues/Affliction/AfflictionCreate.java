package org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AfflictionCreate extends BasePage {

    @FindBy(xpath = "//span[contains(text(), ' Affliction ')]")
    private WebElement aflictionList;

    @FindBy(xpath = "//span[contains(text(), ' REGISTER NEW AFFLICTION')]")
    private WebElement registerNewAffliction;

    @FindBy(name = "name")
    private WebElement nameOfAffliction;

    @FindBy(name = "observations")
    private WebElement observationsAffliction;

    @FindBy(name = "descriptions")
    private WebElement descriptionsAffliction;

    @FindBy(name = "Date")
    private WebElement dateAffliction;

    @FindBy(css = "mat-select[name='cataloge']")
    private WebElement catalogOption;

    @FindBy(css = "mat-select[name='employeee']")
    private WebElement employeeOption;

    @FindBy(id = "create")
    private WebElement createButon;

    @FindBy(xpath = "//tr[@class='mat-row ng-star-inserted'][last()]//mat-icon")
    private WebElement lastIcon;

    public void goToAfflictionList() {
        CommonEvents.clickButton(aflictionList);
    }

    public void goToNewAfflictionForm() {
        CommonEvents.clickButton(registerNewAffliction);
    }

    public void nameAfflictionTexBox(String name) {
        CommonEvents.setInputField(nameOfAffliction, name);
        nameOfAffliction.clear();
        CommonEvents.setInputField(nameOfAffliction, name);
        nameOfAffliction.clear();
        CommonEvents.setInputField(nameOfAffliction, name);
    }

    public void observationsAfflictionTextBox(String obsAffliction) {
        observationsAffliction.clear();
        CommonEvents.setInputField(observationsAffliction, obsAffliction);
    }

    public void descriptionsAfflictionTextBox(String descAffliction) {
        descriptionsAffliction.clear();
        CommonEvents.setInputField(descriptionsAffliction, descAffliction);
    }

    public void dateAfflictionBox(String datAffliction) {
        dateAffliction.clear();
        CommonEvents.setInputField(dateAffliction, datAffliction);
    }

    public void selectCatalogAffliction(String catalog) {
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

    public void aceptAfirmationAlert() {
        CommonEvents.aceptAlert();
    }

    public void openLastRow() {
        CommonEvents.clickButton(lastIcon);
    }




}
