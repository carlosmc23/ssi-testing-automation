# Project feature review the behavior in thie feature
# autor: Carlos Meneses Covarrubias
Feature: Project

  Background: Login
    Given la pagina de Sistema de Seguridad Industrial es cargada
    When Logueo en la aplicacion
    Then Selecciono Projects en el Dashboard

#  Registrar un proyecto

  Scenario Outline: Como usuario debo poder registrar un nuevo proyecto
    When Selecciono el boton Register New Project
    And LLeno los siguientes datos del formulario del proyecto
      | Project Name | <ProjectName>         |
      | Description  | <ProjectDescriptions> |
      | Location     | <ProjectLocation>     |
      | Init Date    | <ProjectInitDate>     |
      | End Date     | <ProjectEndDate>      |
    Then Preciono el boton Create para registrar el proyecto
    And Selecciono el boton aceptar en el mensaje de alert
    And Selecciono el proyecto creado
    Then Verifico los datos insertados en el proyecto
      | Project Name | <ProjectName>         |
      | Location     | <ProjectLocation>     |
      | Description  | <ProjectDescriptions> |
      | Init Date    | <ProjectInitDate>     |
      | End Date     | <ProjectEndDate>      |
    Then Presiono el boton Delete en la parte inferior derecha de la pagina para borrar el proyecto
    And Selecciono el boton aceptar en el mensaje de alert
    Then Cierro sesion
    Examples:
      | ProjectName    | ProjectDescriptions           | ProjectLocation  | ProjectInitDate | ProjectEndDate |
      | Los Robles     | casa de 2 pisos               | Av. Ayacucho     | 5/12/2018       | 11/20/2018     |
      | Edif. Saavedra | Edificio de 6 pisos           | Av. Heroina      | 4/19/2018       | 2/16/2019      |
      | Los Tajivos    | Edificio de 5 pisos           | Av. Panamericana | 2/24/2018       | 9/25/2018      |
      | La Riviera     | condominio 3 Edif. de 6 pisos | Av. Villarroel   | 6/11/2018       | 3/11/2019      |
      | La Casona      | Edificio de 10 pisos          | Av. Belzu        | 1/20/2018       | 4/18/2019      |

  #   Actualizar un proyecto

  Scenario Outline: Como usuario debo poder modificar un proyecto determinado y los cambios deben ser guardados
    When Selecciono el proyecto "<ProjectLabel>" que se quiere actualizar
    And Presiono el boton Update para ir al formulario de actualizacion del proyecto:
    And LLeno los siguientes datos del formulario del proyecto
      | Project Name | <ProjectName>         |
      | Description  | <ProjectDescriptions> |
      | Location     | <ProjectLocation>     |
      | Init Date    | <ProjectInitDate>     |
      | End Date     | <ProjectEndDate>      |
    Then Nuevamente presiono en el boton Update para guardar los cambios del proyecto
    And Presiono el boton aceptar en el mensaje de alert
    Then Verifico los datos insertados en el proyecto
      | Project Name | <ProjectName>         |
      | Location     | <ProjectLocation>     |
      | Description  | <ProjectDescriptions> |
      | Init Date    | <ProjectInitDate>     |
      | End Date     | <ProjectEndDate>      |
    And Cierro sesion
    Examples:
      | ProjectLabel | ProjectName | ProjectDescriptions | ProjectLocation | ProjectInitDate | ProjectEndDate |
      | PRJ-16       | Los Robles  | casa de 2 pisos     | Av. Ayacucho    | 5/12/2018       | 11/20/2018     |
      | PRJ-4        | Edif. Saavedra | Edificio de 6 pisos           | Av. Heroina      | 4/19/2018       | 2/16/2019      |
      | PRJ-5        | Los Tajivos    | Edificio de 5 pisos           | Av. Panamericana | 2/24/2018       | 9/25/2018      |
      | PRJ-6        | La Riviera     | condominio 3 Edif. de 6 pisos | Av. Villarroel   | 6/11/2018       | 3/11/2019      |
      | PRJ-7        | La Casona      | Edificio de 10 pisos          | Av. Belzu        | 1/20/2018       | 4/18/2019      |

