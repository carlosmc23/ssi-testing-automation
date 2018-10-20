# Affliction feature review the behavior in thie feature
# autor: Carlos Meneses Covarrubias
Feature: Affliction

  Background: Login
    Given la pagina de Sistema de Seguridad Industrial es cargada
    When Logueo en la aplicacion
    Then Selecciono Security Issues en el Dashboard

#    Registrar una aflliccion

  Scenario Outline: Como usuario debo poder registrar una nueva afliccion
    When Selecciono el boton Affliction que se encuentra en la parte superior de la pagina
    And Selecciono el boton Register New Affliction
    And LLeno los siguientes datos del formulario de la afliccion
      | Name of affliction | <AfflictionName>         |
      | Observations       | <AfflictionObservations> |
      | Descriptions       | <AfflictionDescriptions> |
      | Date               | <AfflictionDate>         |
    Then Selecciono el catalogo de afliccion "<AfflictionCatalogName>"
    And Selecciono el empleado "<EmployeeName>"
    Then Selecciono el boton Create
    And Presiono el boton aceptar en el mensaje de alert
    And Selecciono la afliccion creada
    Then Verifico los datos insertados en la afliccion
      | Catalog Type       | <AfflictionCatalogName>  |
      | Name of affliction | <AfflictionName>         |
      | Descriptions       | <AfflictionDescriptions> |
      | Observations       | <AfflictionObservations> |
      | Date               | <AfflictionDate>         |
      | Employee           | <EmployeeName>           |
    Then Presiono el boton Delete en la parte inferior derecha de la pagina
    And Presiono el boton aceptar en el mensaje de alert
    Then Cierro sesion
    Examples:
      | AfflictionName        | AfflictionObservations                                  | AfflictionDescriptions                | AfflictionDate | AfflictionCatalogName | EmployeeName     |
      | Dolor en las rodillas | El dolor comenzo despues de cargar bolsas de cemento    | Dolor intenso en la rodilla izquierda | 5/12/2018      | Digestiva             | Carlos Meneses   |
#      | Irritacion en la piel | La irritacion comenzo despues de manipular yeso         | El area de irritada son las manos     | 4/19/2018      | Reumatica             | Juaquin Gonzales |
#      | Dolor estomacal       | El dolor es por la manipulacion de diecel si mascarilla | El dolor escomacal es constante       | 2/24/2018      | Cardiologica          | Jorge Beltran    |
#      | Resfriado recurrente  | El resfriado se dio por contagio fuera del trabajo      | El empleado sufre de agotamiento      | 6/11/2018      | Hematologica          | Rudy Salvatierra |
#      | Estres                | Se deribo al empleado al Medico para su tratamiento     | El empelado sufre Estres              | 1/20/2018      | Neurologica           | Noemi Luna       |

#   Actualizar una afliccion

#  Scenario Outline: Como usuario debo poder modificar una afliccion determinada y los cambios deben ser guardados
#    When Selecciono el boton Affliction que se encuentra en la parte superior de la pagina
#    And Selecciono la afliccion "<AfflictionLabel>" que se quiere actualizar
#    And Presiono el boton Update para ir al formulario de actualizacion de la afliccion:
#    Then LLeno los siguientes datos del formulario de la afliccion
#      | Name of affliction | <AfflictionName>         |
#      | Observations       | <AfflictionObservations> |
#      | Descriptions       | <AfflictionDescriptions> |
#      | Date               | <AfflictionDate>         |
#    Then Selecciono el catalogo de afliccion "<AfflictionCatalogName>"
#    And Selecciono el empleado "<EmployeeName>"
#    Then Nuevamente presiono en el boton Update para guardar los cambios de la afliccion
#    And Presiono el boton aceptar en el mensaje de alert
#    Then Verifico los datos insertados en la afliccion
#      | Catalog Type       | <AfflictionCatalogName>  |
#      | Name of affliction | <AfflictionName>         |
#      | Descriptions       | <AfflictionDescriptions> |
#      | Observations       | <AfflictionObservations> |
#      | Date               | <AfflictionDate>         |
#      | Employee           | <EmployeeName>           |
#    And Cierro sesion
#    Examples:
#      | AfflictionLabel | AfflictionName        | AfflictionObservations                                  | AfflictionDescriptions                | AfflictionDate | AfflictionCatalogName | EmployeeName     |
#      | AFF-12          | Dolor en la rodilla   | El dolor comenzo despues de cargar bolsas de cemento    | Dolor intenso en la rodilla izquierda | 5/12/2018      | Digestiva             | Carlos Meneses   |
#      | AFF-13          | Irritacion en la piel | La irritacion comenzo despues de manipular yeso         | El area de irritada son las manos     | 4/19/2018      | Reumatica             | Juaquin Gonzales |
#      | AFF-15          | Dolor estomacal       | El dolor es por la manipulacion de diecel si mascarilla | El dolor escomacal es constante       | 2/24/2018      | Cardiologica          | Jorge Beltran    |
#      | AFF-14          | Resfriado recurrente  | El resfriado se dio por contagio fuera del trabajo      | El empleado sufre de agotamiento      | 6/11/2018      | Hematologica          | Rudy Salvatierra |
#      | AFF-18          | Estres                | Se deribo al empleado al Medico para su tratamiento     | El empelado sufre Estres              | 1/20/2018      | Neurologica           | Noemi Luna       |
