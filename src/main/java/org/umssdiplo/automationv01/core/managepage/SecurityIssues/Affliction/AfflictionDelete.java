package org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AfflictionDelete extends BasePage {

    @FindBy(id = "afflictionDelete")
    private WebElement deleteButon;

    public void buttonDelete() {
        CommonEvents.clickButton(deleteButon);
    }

}
