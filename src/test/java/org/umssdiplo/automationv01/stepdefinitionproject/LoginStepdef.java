package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.Login.Login;

public class LoginStepdef {
    Login loginPage= new Login();

    @When("^Logueo en la aplicacion$")
    public void logueoEnLaAplicacion(){
        loginPage.login();
    }

    @Then("^Cierro sesion$")
    public void cierroSesion() {
        loginPage.cerrarSesion();
    }
}
