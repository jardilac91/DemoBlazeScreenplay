Feature: Agregar productos al carrito de compras.
  Como usuario de la aplicación demoblaze.
  Requiero agregar productos al carrito de compras.
  Para realizar una compra en la página.

  Background:
    Given El usuario ha ingresado a la pagina demoblaze.

  Scenario: Usuario sin autenticarse selecciona un producto aleatorio y lo agrega al carrito de compras.
    When El usuario selecciona un producto cualquiera.
    And El usuario lo agrega al carrito de compras.
    Then El usuario debe ver la misma cantidad de productos en el carrito de compras.