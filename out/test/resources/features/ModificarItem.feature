#Noemi Luna Huanca
Feature: ModificarItem

  Background: Login
    Given la pagina de Sistema de Seguridad Industrial es cargada
    When Logueo en la aplicacion
    Then Presiono el cuadro Security Items
    And Presiono la opcion Items

  Scenario: Como usuario, debo poder modificar un item
    Given Presiono el boton UPDATE ITEM
    When Modifico los campos del formulario
      | Name of Item | Tapon auditivo |
      | Price        | 100            |
      | State        | usado          |
    And Modifico subcategory
    And Presiono el boton updateitem
    Then En la pagina web debo ver la modificacion con name "Tapon auditivo"
    And Cierro sesion
