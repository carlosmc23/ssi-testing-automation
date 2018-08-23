package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Projects.Project.ProjectCreate;
import org.umssdiplo.automationv01.core.managepage.Projects.Project.ProjectDelete;
import org.umssdiplo.automationv01.core.managepage.Projects.Project.ProjectRead;
import org.umssdiplo.automationv01.core.managepage.Projects.Project.ProjectUpdate;

import java.util.List;

public class ProjectStepdef {
    private ProjectCreate create = new ProjectCreate();
    private ProjectRead read = new ProjectRead();
    private ProjectDelete delete = new ProjectDelete();
    private ProjectUpdate update = new ProjectUpdate();

    @Then("^Selecciono el boton Register New Project")
    public void seleccionoElBotonRegisterNewProject() {
        create.gotToNewProjectForm();
    }

    @And("^LLeno los siguientes datos del formulario del proyecto")
    public void llenoLosSiguientesDatosDelFormularioRegisterNewProject(DataTable datos) {
        List<List<String>> datosFormulario = datos.raw();
        for (List<String> dato : datosFormulario) {
            switch (dato.get(0)) {
                case "Project Name":
                    create.nameProjectTextBox(dato.get(1));
                    break;
                case "Description":
                    create.descriptionProjectTexBox(dato.get(1));
                    break;
                case "Location":
                    create.locationProjectTextBox(dato.get(1));
                    break;
                case "Init Date":
                    create.initDateProjectTextBox(dato.get(1));
                    break;
                case "End Date":
                    create.endDateProjectTextBox(dato.get(1));
                    break;
            }
        }
    }

    @And("^Preciono el boton Create para registrar el proyecto$")
    public void seleccionoElBotonCreate() {
        create.selectButonCreate();
    }

    @And("^Selecciono el boton aceptar en el mensaje de alert$")
    public void presionoElBotonAceptarEnElMensajeDeAlert() {
        create.aceptAfirmationProjectAlert();
    }

    @Then("^Selecciono el proyecto creado$")
    public void seleccionoElProyectoCreado() {
        create.openLastRow();
    }

    @Then("^Verifico los datos insertados en el proyecto$")
    public void verificoLosDatosInsertadosEnElNuevoProyecto(DataTable prDatos) {
        List<List<String>> DatosFormulario = prDatos.raw();
        for (List<String> dato : DatosFormulario) {
            switch (dato.get(0)) {
                case "Project Name":
                    String actualName = read.getProjectName();
                    Assert.assertTrue(actualName.contains(dato.get(1)));
                    break;
                case "Location":
                    String actualLocation = read.getProjectLocation();
                    Assert.assertTrue(actualLocation.contains(dato.get(1)));
                    break;
                case "Description":
                    String actualDesc = read.getProjectDescription();
                    Assert.assertTrue(actualDesc.contains(dato.get(1)));
                    break;
                case "Init Date":
                    String actualInitDate = read.getProjectInitDate();
                    Assert.assertTrue(actualInitDate.contains(dato.get(1)));
                    break;
                case "End Date":
                    String actualEndDate = read.getProjectEndDate();
                    Assert.assertTrue(actualEndDate.contains(dato.get(1)));
                    break;
            }
        }
    }

    @Then("^Presiono el boton Delete en la parte inferior derecha de la pagina para borrar el proyecto$")
    public void presionoElBotonDelete() {
        delete.buttonDelete();
    }

    /**
     * Metodos para la actualizacion de datos
     */
    @And("^Selecciono el proyecto \"([^\"]*)\" que se quiere actualizar$")
    public void seleccionoElProyectoQueSeQuiereActualizar(String label) {
        update.selectProjectLabel(label);
    }

    @And("^Presiono el boton Update para ir al formulario de actualizacion del proyecto:$")
    public void presionoElBotonUpdateParaIrAlFormularioDeActualizacionDelProyecto() {
        update.SelectProjectUpdateButton();
    }

    @Then("^Nuevamente presiono en el boton Update para guardar los cambios del proyecto$")
    public void nuevamentePresionoEnElBotonUpdateParaGuardarLosCambiosDelProyecto() {
        update.selectUpdateButonTwo();
    }
}
