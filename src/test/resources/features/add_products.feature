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

  Scenario Outline: Usuario sin autenticarse selecciona un producto y agrega cierta cantidad al carrito de compras.
    When El usuario selecciona el producto "<Producto>"
    And El usuario agrega la cantidad de productos <Cantidad> al carrito de compras.
    Then El usuario debe ver la misma cantidad de productos en el carrito de compras.
    Examples:
      | Cantidad  |   Producto          |
      |   2       | Nokia lumia 1520    |
      |   5       | Samsung galaxy s7   |
      |   4       | Sony vaio i5        |

  Scenario Outline: Usuario sin autenticarse selecciona una categoria y un producto y lo agrega al carrito de compras.
    When El usuario selecciona la categoria "<Categoria>" y el producto "<Producto>"
    And El usuario lo agrega al carrito de compras.
    Then El usuario debe ver la misma cantidad de productos en el carrito de compras.
    Examples:
      | Categoria |   Producto    |
      | Phones    | Iphone 6 32gb |
      | Laptops   | MacBook air   |
      | Monitors  | ASUS Full HD  |

  Scenario Outline: Un usuario autenticado agrega productos, cierra sesion y vuelve a abrirla debe seguir viendo los productos agregados en el carrito.
    When El usuario inicia sesion y selecciona el producto "<Producto>" y lo agrega al carrito de compras.
    And El usuario cierra y abre sesion e ingresa al carrito.
    Then El usuario debe ver la misma cantidad de productos en el carrito de compras que tenia antes de cerrar sesion.
    Examples:
      |   Producto        |
      | Iphone 6 32gb     |
      | Sony xperia z5    |