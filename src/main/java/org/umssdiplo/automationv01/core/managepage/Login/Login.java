package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class Login extends BasePage {
    @FindBy(name = "username")
    private WebElement userTextbox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(name = "submit")
    private WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),' Logout')]")
    private WebElement logout;

    public void login() {
        String username = PropertyAccessor.getInstance().getUser();
        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(userTextbox, username);
        CommonEvents.setInputField(passwordTextBox, password);
        CommonEvents.clickButton(loginButton);
    }

    public void cerrarSesion() {
        CommonEvents.clickButton(logout);
    }


}
