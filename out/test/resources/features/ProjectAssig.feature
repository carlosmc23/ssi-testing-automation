# Assignment Projects feature review the behavior in thie feature
# autor: Carlos Meneses Covarrubias
Feature: Assignment Projects

  Background: Login
    Given la pagina de Sistema de Seguridad Industrial es cargada
    When Logueo en la aplicacion
    Then Selecciono Projects en el Dashboard

#  Registrar una asignacion de proyecto

  Scenario Outline: Como usuario debo poder registrar una nueva  asignacion de proyecto
    When Selecciono el boton Assignment Projects que se encuentra en la parte superior de la pagina
    And Presiono el boton Register New Project Assignment
    And LLeno los siguientes datos del formulario de la asignacion de proyecto
      | Init Date | <AssigProjectInitDate> |
      | End Date  | <AssigProjectEndDate>  |
    Then Selecciono el empleado que sera asignado "<EmployeeName>"
    And Selecciono el proyecto "<ProjectName>"
    Then Preciono el boton Create para registrar la asignacion de proyecto
    And Selecciono el boton aceptar en el mensaje de alert
    And Selecciono la asignacion de proyecto creada
    Then Verifico los datos insertados en la asignacion de proyecto
      | Init Date    | <AssigProjectInitDate> |
      | End Date     | <AssigProjectEndDate>  |
      | Employee     | <EmployeeName>         |
      | Project Name | <ProjectName>          |
    Then Cierro sesion
    Examples:
      | AssigProjectInitDate | AssigProjectEndDate | EmployeeName     | ProjectName    |
      | 5/12/2018            | 11/20/2018          | Carlos Meneses   | Los Robles     |
      | 4/19/2018            | 2/16/2019           | Juaquin Gonzales | Edif. Saavedra |
      | 2/24/2018            | 9/25/2018           | Jorge Beltran    | Los Tajivos    |
      | 6/11/2018            | 3/11/2019           | Rudy Salvatierra | La Riviera     |
      | 1/20/2018            | 4/18/2019           | Noemi Luna       | La Casona      |

  #   Actualizar un proyecto

  Scenario Outline: Como usuario debo poder modificar una asignacion a un proyecto determinado y los cambios deben ser guardados
    When Selecciono el boton Assignment Projects que se encuentra en la parte superior de la pagina
    And Presiono el icono de basurero "<AssignmentLabel>" ubicado en lado derecho de la asignacion que se quiere actualizar
    And LLeno los siguientes datos del formulario de la asignacion de proyecto
      | Init Date | <AssigProjectInitDate> |
      | End Date  | <AssigProjectEndDate>  |
    Then Selecciono el empleado que sera asignado "<EmployeeName>"
    And Selecciono el proyecto "<ProjectName>"
    Then Presiono en el boton Update para guardar los cambios realizados en la asignacion de proyecto
    And Presiono el boton aceptar en el mensaje de alert
    Then Verifico los datos actualizados en la asignacion de proyecto "<AssignmentLabel>"
      | Init Date    | <AssigProjectInitDate> |
      | End Date     | <AssigProjectEndDate>  |
      | Employee     | <EmployeeName>         |
      | Project Name | <ProjectName>          |
    And Cierro sesion
    Examples:
      | AssignmentLabel | AssigProjectInitDate | AssigProjectEndDate | EmployeeName     | ProjectName    |
      | PAS-12          | 5/12/2018            | 11/20/2018          | Carlos Meneses   | Los Robles     |
      | PAS-13          | 4/19/2018            | 2/16/2019           | Juaquin Gonzales | Edif. Saavedra |
      | PAS-14          | 2/24/2018            | 9/25/2018           | Jorge Beltran    | Los Tajivos    |
      | PAS-15          | 6/11/2018            | 3/11/2019           | Rudy Salvatierra | La Riviera     |
      | PAS-16          | 1/20/2018            | 4/18/2019           | Noemi Luna       | La Casona      |

