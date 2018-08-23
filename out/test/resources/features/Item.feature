#Noemi Luna Huanca
Feature: Item

  Background: Login
    Given la pagina de Sistema de Seguridad Industrial es cargada
    When Logueo en la aplicacion
    Then Presiono el cuadro Security Items
    And Presiono la opcion Items

  Scenario: Como usuario, debo poder registrar un item
    Given Presiono el boton ADD ITEM
    When Lleno el formulario con los datos
      | Ingreso el name        | gafas de seguridad           |
      | Ingreso el code        | ITM-#                        |
      | Ingreso el estado      | nuevo                        |
      | Ingreso la description | gafas resistentes a impactos |
      | Ingreso el precio      | 300                          |
      | Ingreso el label       | ITM-OSHA                     |
    And Selecciono una subcategory
    And Presiono el boton Enviar
    Then En la pagina web debo ver el item creado con name "gafas de seguridad"
    And Cierro sesion

