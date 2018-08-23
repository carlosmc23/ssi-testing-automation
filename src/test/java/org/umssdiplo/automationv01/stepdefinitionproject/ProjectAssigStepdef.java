package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment.ProjectAssigCreate;
import org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment.ProjectAssigDelete;
import org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment.ProjectAssigRead;
import org.umssdiplo.automationv01.core.managepage.Projects.ProjectAssignment.ProjectAssigUpdate;

import java.util.List;

public class ProjectAssigStepdef {
    private ProjectAssigCreate create = new ProjectAssigCreate();
    private ProjectAssigRead read = new ProjectAssigRead();
    private ProjectAssigDelete delete = new ProjectAssigDelete();
    private ProjectAssigUpdate update = new ProjectAssigUpdate();

    @When("^Selecciono el boton Assignment Projects que se encuentra en la parte superior de la pagina$")
    public void seleccionoElBotonAssignmentProjectsQueSeEncuentraEnLaParteSuperiorDeLaPagina() {
        create.goToProjectAssigmentList();
    }

    @Then("^Presiono el boton Register New Project Assignment")
    public void presionoBotonRegisterNewProjectAssignment() {
        create.gotToNewProjectAssigForm();
    }

    @And("^LLeno los siguientes datos del formulario de la asignacion de proyecto")
    public void llenoLosSiguientesDatosDelFormularioAssignmentProject(DataTable datos) {
        List<List<String>> datosFormulario = datos.raw();
        for (List<String> dato : datosFormulario) {
            switch (dato.get(0)) {
                case "Init Date":
                    create.initDateProjectTextBox(dato.get(1));
                    break;
                case "End Date":
                    create.endDateProjectTextBox(dato.get(1));
                    break;
            }
        }
    }

    @Then("^Selecciono el empleado que sera asignado \"([^\"]*)\"$")
    public void seleccionoElEmpleadoQueSeraAsignado(String employeeName) {
        create.selectEmployeeAssignment(employeeName);
    }

    @And("^Selecciono el proyecto \"([^\"]*)\"$")
    public void seleccionoElProyecto(String projectName) {
        create.selectProjectAssignment(projectName);
    }

    @And("^Preciono el boton Create para registrar la asignacion de proyecto$")
    public void seleccionoElBotonCreateAssignProject() {
        create.selectButonCreate();
    }

    @Then("^Selecciono la asignacion de proyecto creada$")
    public void seleccionoLaAsignacionProyectoCreada() {
        create.openLastRow();
    }

    @Then("^Verifico los datos insertados en la asignacion de proyecto$")
    public void verificoLosDatosInsertadosEnLaAsignacionDeProyecto(DataTable prDatos) {
        List<List<String>> DatosFormulario = prDatos.raw();
        for (List<String> dato : DatosFormulario) {
            switch (dato.get(0)) {
                case "Employee":
                    String actualEmployee = read.getEmployeeName();
                    Assert.assertTrue(actualEmployee.contains(dato.get(1)));
                    break;
                case "Project Name":
                    String actualProject = read.getProjectName();
                    Assert.assertTrue(actualProject.contains(dato.get(1)));
                    break;
                case "Init Date":
                    String actualinitDate = read.getInitDate();
                    Assert.assertTrue(actualinitDate.contains(dato.get(1)));
                    break;
                case "End Date":
                    String actualEndDate = read.getEndDate();
                    Assert.assertTrue(actualEndDate.contains(dato.get(1)));
                    break;
            }
        }
    }

    @Then("^Para borrar la asignacion presiono el icono de basurero ubicado en lado derecho de su fila$")
    public void borroLaAsignacionDeProyecto() {
        delete.iconDelete();
    }

    /**
     * Metodos para la actualizacion de datos
     */

    @And("^Presiono el icono de basurero \"([^\"]*)\" ubicado en lado derecho de la asignacion que se quiere actualizar$")
    public void presionoElIconoDeBasureroUbicadoEnLadoDerechoDeLaAsignacionQueSeQuiereActualizar(String label) {
        update.selectProjectAssignmentLabel(label);
    }

    @Then("^Presiono en el boton Update para guardar los cambios realizados en la asignacion de proyecto$")
    public void presionoEnElBotonUpdateParaGuardarLosCambiosRealizadosEnLaAsignacionDeProyecto() {
        update.selectUpdateButon();
    }

    @And("^Selecciono la asignacion de proyecto que se actualizo \"([^\"]*)\"$")
    public void seleccionoLaAsignacionDeProyectoQueSeActualizo(String label) {
        update.selectProjectAssignmentLabel(label);
    }

    @Then("^Verifico los datos actualizados en la asignacion de proyecto \"([^\"]*)\"$")
    public void verificoLosDatosActualizadosEnLaAsignacionDeProyecto(String label, DataTable verificar) {
        List<List<String>> DatosFormulario = verificar.raw();
        for (List<String> dato : DatosFormulario) {
            switch (dato.get(0)) {
                case "Employee":
                    String actualEmployee = update.getProjectAssignationEmployeeName(label);
                    Assert.assertTrue(actualEmployee.contains(dato.get(1)));
                    break;
                case "Project Name":
                    String actualProject = update.getProjectAssignationProjectName(label);
                    Assert.assertTrue(actualProject.contains(dato.get(1)));
                    break;
                case "Init Date":
                    String actualinitDate = update.getProjectAssignationInitDate(label);
                    Assert.assertTrue(actualinitDate.contains(dato.get(1)));
                    break;
                case "End Date":
                    String actualEndDate = update.getProjectAssignationEndDate(label);
                    Assert.assertTrue(actualEndDate.contains(dato.get(1)));
                    break;
            }
        }
    }
}
