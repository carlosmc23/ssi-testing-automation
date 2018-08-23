package org.umssdiplo.automationv01.core.managepage.Projects.Project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectRead extends BasePage {

    @FindBy(id = "projectName")
    private WebElement projName;

    @FindBy(id = "projectLocation")
    private WebElement projLocation;

    @FindBy(id = "projectDescription")
    private WebElement projDescription;

    @FindBy(id = "projectInitDate")
    private WebElement projInidDate;

    @FindBy(id = "projectEndDate")
    private WebElement projEndDate;


    public String getProjectName() {
        return CommonEvents.getInnerText(projName);
    }

    public String getProjectLocation() {
        return CommonEvents.getInnerText(projLocation);
    }

    public String getProjectDescription() {
        return CommonEvents.getInnerText(projDescription);
    }

    public String getProjectInitDate() {
        return CommonEvents.getInnerText(projInidDate);
    }

    public String getProjectEndDate() {
        return CommonEvents.getInnerText(projEndDate);
    }

}
