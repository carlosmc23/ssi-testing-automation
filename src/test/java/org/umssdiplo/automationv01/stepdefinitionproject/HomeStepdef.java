package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.Login.Home;

public class HomeStepdef {
    Home home = new Home();

    @When("^Selecciono Security Issues en el Dashboard$")
    public void escojoSecirityIssuesEnElDashboard() {
        home.goToSecurityIssues();
    }

    @Then("^Navego a Home$")
    public void navegoAHome() {
        home.goToHome();
        home.goToSecurityIssues();
    }


    @Then("^Selecciono Projects en el Dashboard$")
    public void seleccionoProjectsEnElDashboard() {
        home.goToProjects();
    }
    @Then("^Presiono el cuadro Security Items$")
    public void presiono_el_cuadro_Security_Items() {
        home.goSecurityItems();

    }
}
