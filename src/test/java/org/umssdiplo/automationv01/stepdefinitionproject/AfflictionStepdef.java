package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction.AfflictionCreate;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction.AfflictionDelete;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction.AfflictionRead;
import org.umssdiplo.automationv01.core.managepage.SecurityIssues.Affliction.AfflictionUpdate;

import java.util.List;

public class AfflictionStepdef {
    private AfflictionCreate create = new AfflictionCreate();
    private AfflictionRead read = new AfflictionRead();
    private AfflictionDelete delete = new AfflictionDelete();
    private AfflictionUpdate update = new AfflictionUpdate();

    @When("^Selecciono el boton Affliction que se encuentra en la parte superior de la pagina$")
    public void seleccionoElBotonAffliction() {
        create.goToAfflictionList();
    }

    @Then("^Selecciono el boton Register New Affliction$")
    public void seleccionoElBotonRegisterNewAffliction() {
        create.goToNewAfflictionForm();
    }

    @And("^LLeno los siguientes datos del formulario de la afliccion$")
    public void llenoLosSiguientesDatosDelFormularioRegisterNewAffliction(DataTable datos) {
        List<List<String>> datosFormulario = datos.raw();
        for (List<String> dato : datosFormulario) {
            switch (dato.get(0)) {
                case "Name of affliction":
                    create.nameAfflictionTexBox(dato.get(1));
                    break;
                case "Observations":
                    create.observationsAfflictionTextBox(dato.get(1));
                    break;
                case "Descriptions":
                    create.descriptionsAfflictionTextBox(dato.get(1));
                    break;
                case "Date":
                    create.dateAfflictionBox(dato.get(1));
                    break;
            }
        }
    }

    @And("^Selecciono el catalogo de afliccion \"([^\"]*)\"$")
    public void seleccionoElCatalogoDeAfliccion(String catalogName) {
        create.selectCatalogAffliction(catalogName);
    }

    @And("^Selecciono el empleado \"([^\"]*)\"$")
    public void seleccionoElEmpleado(String employeeName) {
        create.selectEmployee(employeeName);
    }

    @And("^Selecciono el boton Create$")
    public void seleccionoElBotonCreate() {
        create.selectButonCreate();
    }

    @Then("^Selecciono la afliccion creada$")
    public void seleccionoLaAfliccionCreada() {
        create.openLastRow();
    }

    @And("^Presiono el boton aceptar en el mensaje de alert$")
    public void presionoElBotonAceptarEnElMensajeDeAlert() {
        create.aceptAfirmationAlert();
    }

    @Then("^Verifico los datos insertados en la afliccion$")
    public void verificoLosDatosInsertadosEnLaNuevaAfliccion(DataTable revDatos) {
        List<List<String>> DatosFormulario = revDatos.raw();
        for (List<String> dato : DatosFormulario) {
            switch (dato.get(0)) {
                case "Catalog Type":
                    String actualCatalog = read.getAfflictionCatalog();
                    Assert.assertTrue(actualCatalog.contains(dato.get(1)));
                    break;
                case "Name of affliction":
                    String actualName = read.getAfflictionName();
                    Assert.assertTrue(actualName.contains(dato.get(1)));
                    break;
                case "Descriptions":
                    String actualDesc = read.getAfflictionDescription();
                    Assert.assertTrue(actualDesc.contains(dato.get(1)));
                    break;
                case "Observations":
                    String actualObs = read.getAfflictionObservation();
                    Assert.assertTrue(actualObs.contains(dato.get(1)));
                    break;
                case "Date":
                    String actualDate = read.getAfflictionDate();
                    Assert.assertTrue(actualDate.contains(dato.get(1)));
                    break;
                case "Employee":
                    String actualEmp = read.getEmployeeName();
                    Assert.assertTrue(actualEmp.contains(dato.get(1)));
                    break;
            }
        }
    }

    @Then("^Presiono el boton Delete en la parte inferior derecha de la pagina$")
    public void presionoElBotonDelete() {
        delete.buttonDelete();
    }

    /**
     * Metodos para la actualizacion de datos
     */
    @And("^Selecciono la afliccion \"([^\"]*)\" que se quiere actualizar$")
    public void seleccionoLaAfliccionQueSeQuiereActualizar(String label) {
        update.selectAfflictionLabel(label);
    }

    @Then("^Presiono el boton Update para ir al formulario de actualizacion de la afliccion:$")
    public void presionoElBotonUpdateParaActualizarLaAfliccion() {
        update.SelectAfflictionUpdateButton();
    }

    @Then("^Nuevamente presiono en el boton Update para guardar los cambios de la afliccion$")
    public void nuevamentePresionoEnElBotonUpdateParaGuardarLosCambios() {
        update.selectUpdateButonTwo();
    }
}
