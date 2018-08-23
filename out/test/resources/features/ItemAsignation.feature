#Noemi Luna Huanca
Feature: ItemAsignation

  Background: Login
    Given la pagina de Sistema de Seguridad Industrial es cargada
    When Logueo en la aplicacion
    Then Presiono el cuadro Security Items
    And Presiono la opcion Items Asignation

  Scenario: Como ususario, debo poder registrar una asignation de item
    Given Presiono el boton ADD ITEM ASIGNATION
    When Lleno el formulario con los siquientes datos
      | LLeno la fecha de inicio       | 09/07/2018                   |
      | Lleno la fecha de fin          | 24/07/2018                   |
      | Lleno la description           | Para proteccion de los oidos |
      | Lleno el state actual del item | raspado la parte delantera   |
    And Selecciono un item
    And Selecciono un employee
    And Presiono boton Enviar
    Then Dentro la pagina debo poder ver la asignacion creada con descripcion "Para proteccion de los oidos"
    And Cierro sesion


