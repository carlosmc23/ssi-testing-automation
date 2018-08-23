package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Incident.IncidentCreate;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Incident.IncidentDelete;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Incident.IncidentRead;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Incident.IncidentUpdate;

import java.util.List;

public class IncidentStepdef {
    private IncidentCreate create = new IncidentCreate();
    private IncidentRead read = new IncidentRead();
    private IncidentDelete delete = new IncidentDelete();
    private IncidentUpdate update = new IncidentUpdate();

    @Then("^Selecciono el boton Register New Incident$")
    public void seleccionoElBotonRegisterNewIncident() {
        create.goToNewIncidentForm();
    }

    @And("^LLeno los siguientes datos del formulario del incidente:$")
    public void llenoLosSiguientesDatosDelFormularioRegisterNewIncident(DataTable datos) {
        List<List<String>> datosFormulario = datos.raw();
        for (List<String> dato : datosFormulario) {
            switch (dato.get(0)) {
                case "Descriptions":
                    create.descriptionsIncidentTextBox(dato.get(1));
                    break;
                case "Observations":
                    create.observationsIncidentTexBox(dato.get(1));
                    break;
                case "Date":
                    create.dateIncidentTextBox(dato.get(1));
                    break;
                case "Witness":
                    create.witnessIncidentTextBox(dato.get(1));
                    break;
                case "Place":
                    create.incidentPlaceTextBox(dato.get(1));
                    break;
            }
        }
    }

    @And("^Selecciono el catalogo de incidente \"([^\"]*)\"$")
    public void seleccionoElCatalogoDeInicidente(String catalogName) {
        create.selectCatalogIncident(catalogName);
    }

    @And("^Realizo la seleccion del empleado \"([^\"]*)\"$")
    public void seleccionoElEmpleado(String employeeName) {
        create.selectEmployee(employeeName);
    }

    @And("^Seleccionar el boton Create$")
    public void seleccionarElBotonCreate() {
        create.selectButonCreate();
    }

    @And("^Selecciono el incidente Creado$")
    public void seleccionoElIncidenteCreado() {
        create.openLastRow();
    }

    @Then("^Verifico los datos del nuevo incidente registrado$")
    public void verificoLosDatosDelNuevoIncidenteRegistrado(DataTable datos) {
        List<List<String>> datosFormulario = datos.raw();
        for (List<String> dato : datosFormulario) {
            switch (dato.get(0)) {
                case "Catalog Type":
                    String actualCatalog = read.getIncidentCatalog();
                    Assert.assertTrue(actualCatalog.contains(dato.get(1)));
                    break;
                case "Witness":
                    String actualWitness = read.getIncidentWitness();
                    Assert.assertTrue(actualWitness.contains(dato.get(1)));
                    break;
                case "Place":
                    String actualPlace = read.getIncidentPlace();
                    Assert.assertTrue(actualPlace.contains(dato.get(1)));
                    break;
                case "Descriptions":
                    String actualDescription = read.getIncidentDescriptions();
                    Assert.assertTrue(actualDescription.contains(dato.get(1)));
                    break;
                case "Observations":
                    String actualObservation = read.getIncidentObservation();
                    Assert.assertTrue(actualObservation.contains(dato.get(1)));
                    break;
                case "Date":
                    String actualDate = read.getIncidentDate();
                    Assert.assertTrue(actualDate.contains(dato.get(1)));
                    break;
                case "Employee":
                    String actualEmployee = read.getEmployee();
                    Assert.assertTrue(actualEmployee.contains(dato.get(1)));
                    break;

            }
        }
    }

    @Then("^Presiono el boton Delete ubicado en la parte inferior derecha de la pagina$")
    public void presionoElBotonDeleteUbicadoEnLaParteInferiorDerechaDeLaPagina() {
        delete.buttonDelete();
    }


    /**
     * Metodos para la actualizacion de datos
     */
    @When("^Selecciono el incidente \"([^\"]*)\" que se quiere actualizar$")
    public void seleccionoElIncidenteQueSeQuiereActualizar(String label) {
        update.selectIncidentLabel(label);
    }

    @And("^Presiono el boton Update para ir al formulario de actualizacion del incidente$")
    public void presionoElBotonUpdateParaIrAlFormularioDeActualizacionDelIncidente() {
        update.SelectIncidentUpdateButton();
    }

    @Then("^Nuevamente presiono en el boton Update para guardar los cambios del incidente$")
    public void nuevamentePresionoEnElBotonUpdateParaGuardarLosCambiosDelIncidente() {
        update.selectUpdateButonTwo();
    }
}
