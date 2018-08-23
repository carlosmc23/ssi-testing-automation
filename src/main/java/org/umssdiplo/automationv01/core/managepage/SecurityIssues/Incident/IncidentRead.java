package org.umssdiplo.automationv01.core.managepage.SecurityIssues.Incident;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class IncidentRead extends BasePage {

    @FindBy(id = "catalogName")
    private WebElement incCatalog;

    @FindBy(id = "incidentWitness")
    private WebElement incWitness;

    @FindBy(id = "incidentPlace")
    private WebElement incPlace;

    @FindBy(id = "incidentDescription")
    private WebElement incDescription;

    @FindBy(id = "incidentObservations")
    private WebElement incObservation;

    @FindBy(id = "incidentDate")
    private WebElement incDate;

    @FindBy(id = "employeeName")
    private WebElement incEmployee;

    public String getIncidentCatalog() {
        return CommonEvents.getInnerText(incCatalog);
    }

    public String getIncidentWitness() {
        return CommonEvents.getInnerText(incWitness);
    }

    public String getIncidentPlace() {
        return CommonEvents.getInnerText(incPlace);
    }

    public String getIncidentDescriptions() {
        return CommonEvents.getInnerText(incDescription);
    }

    public String getIncidentObservation() {
        return CommonEvents.getInnerText(incObservation);
    }

    public String getIncidentDate() {
        return CommonEvents.getInnerText(incDate);
    }

    public String getEmployee() {
        return CommonEvents.getInnerText(incEmployee);
    }
}
