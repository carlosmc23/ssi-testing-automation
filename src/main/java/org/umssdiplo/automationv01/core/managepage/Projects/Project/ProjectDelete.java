package org.umssdiplo.automationv01.core.managepage.Projects.Project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectDelete extends BasePage {

    @FindBy(id = "deleteProject")
    private WebElement deleteButon;

    public void buttonDelete() {
        CommonEvents.clickButton(deleteButon);
    }

}
