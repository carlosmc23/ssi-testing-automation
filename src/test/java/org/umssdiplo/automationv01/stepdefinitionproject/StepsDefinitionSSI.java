package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSI {
    private Login login;

    @Given("^la pagina de Sistema de Seguridad Industrial es cargada$")
    public void ssiPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

}
