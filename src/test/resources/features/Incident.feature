# Incident feature review the behavior in thie feature
# autor: Carlos Meneses Covarrubias
Feature: Incident

  Background: Login
    Given la pagina de Sistema de Seguridad Industrial es cargada
    When Logueo en la aplicacion
    Then Selecciono Security Issues en el Dashboard

#    Registrar un incidente

  Scenario Outline: Como usuario debo poder registrar una nuevo incidente
    When Selecciono el boton Register New Incident
    And LLeno los siguientes datos del formulario del incidente:
      | Descriptions | <IncidentDescriptions> |
      | Observations | <IncidentObservations> |
      | Date         | <IncidentDate>         |
      | Witness      | <IncidentWitness>      |
      | Place        | <IncidentPlace>        |
    Then Selecciono el catalogo de incidente "<IncidentCatalogName>"
    And Realizo la seleccion del empleado "<EmployeeName>"
    And Seleccionar el boton Create
    Then Presiono el boton aceptar en el mensaje de alert
    And Selecciono el incidente Creado
    Then Verifico los datos del nuevo incidente registrado
      | Catalog Type | <IncidentCatalogName>  |
      | Witness      | <IncidentWitness>      |
      | Place        | <IncidentPlace>        |
      | Descriptions | <IncidentDescriptions> |
      | Observations | <IncidentObservations> |
      | Date         | <IncidentDate>         |
      | Employee     | <EmployeeName>         |
    Then Presiono el boton Delete ubicado en la parte inferior derecha de la pagina
    And Presiono el boton aceptar en el mensaje de alert
    Then Cierro sesion
    Examples:
      | IncidentDescriptions    | IncidentObservations                                   | IncidentDate | IncidentWitness       | IncidentPlace    | IncidentCatalogName | EmployeeName     |
      | Caida de una Carretilla | La carretilla cayo desde el segundo piso               | 4/22/2018    | Jorge Saavedra vecino | Av. Heroinas     | Higth               | Carlos Meneses   |
      | Caida de tejas          | Se ocaciono por que no fueron acomodadas adecuadamente | 3/11/2018    | Luis Obrero           | Av. Panamericana | Important           | Juaquin Gonzales |
      | loza destruida          | se cayeron cajas de loza al descargadas del camion     | 1/26/2018    | Manuel vecino         | Av. Moscu        | Mediun              | Jorge Beltran    |
      | Accidente con vehiculo  | caida de escombro el parabrisas de un auto estacionado | 2/20/2018    | Patricio vecino       | Av. America      | Low                 | Rudy Salvatierra |
      | Perdida de cemento      | La perdida de 60 bolsas fue ocacionada por la lluvia   | 5/19/2018    | Noemi vecina          | Av. Oquendo      | Null                | Noemi Luna       |

#   Actualizar un incidente

  Scenario Outline: Como usuario debo poder modificar un incidente determinado y los cambios deben ser guardados
    When Selecciono el incidente "<IncidentLabel>" que se quiere actualizar
    And Presiono el boton Update para ir al formulario de actualizacion del incidente
    And LLeno los siguientes datos del formulario del incidente:
      | Descriptions | <IncidentDescriptions> |
      | Observations | <IncidentObservations> |
      | Date         | <IncidentDate>         |
      | Witness      | <IncidentWitness>      |
      | Place        | <IncidentPlace>        |
    Then Selecciono el catalogo de incidente "<IncidentCatalogName>"
    And Realizo la seleccion del empleado "<EmployeeName>"
    Then Nuevamente presiono en el boton Update para guardar los cambios del incidente
    And Presiono el boton aceptar en el mensaje de alert
    Then Verifico los datos del nuevo incidente registrado
      | Catalog Type | <IncidentCatalogName>  |
      | Witness      | <IncidentWitness>      |
      | Place        | <IncidentPlace>        |
      | Descriptions | <IncidentDescriptions> |
      | Observations | <IncidentObservations> |
      | Date         | <IncidentDate>         |
      | Employee     | <EmployeeName>         |
    And Cierro sesion
    Examples:
      | IncidentLabel | IncidentDescriptions    | IncidentObservations                                   | IncidentDate | IncidentWitness       | IncidentPlace    | IncidentCatalogName | EmployeeName     |
      | INC-16        | Caida de una Carretilla | La carretilla cayo desde el segundo piso               | 4/22/2018    | Jorge Saavedra vecino | Av. Heroinas     | Higth               | Carlos Meneses   |
      | INC-4         | Caida de tejas          | Se ocaciono por que no fueron acomodadas adecuadamente | 3/11/2018    | Luis Obrero           | Av. Panamericana | Important           | Juaquin Gonzales |
      | INC-5         | loza destruida          | se cayeron cajas de loza al descargadas del camion     | 1/26/2018    | Manuel vecino         | Av. Moscu        | Mediun              | Jorge Beltran    |
      | INC-6         | Accidente con vehiculo  | caida de escombro el parabrisas de un auto estacionado | 2/20/2018    | Patricio vecino       | Av. America      | Low                 | Rudy Salvatierra |
      | INC-7         | Perdida de cemento      | La perdida de 60 bolsas fue ocacionada por la lluvia   | 5/19/2018    | Noemi vecina          | Av. Oquendo      | Null                | Noemi Luna       |


