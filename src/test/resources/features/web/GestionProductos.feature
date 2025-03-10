# language: es
@Web
Característica: Gestión de Productos

  Antecedentes:
    Dado que me encuentro en la pantalla inicial de Store
    Cuando selecciono la categoría "Phones"
    Y selecciono el producto "Samsung galaxy s6"

  Regla: El sistema debe permitir el ingreso de los siguientes formulario

  @CP05
  Escenario: Selección de producto Samsung Galaxy S6
    Entonces podré ver el detalle del producto con la etiqueta "Product description"

  @CP06
  Escenario: Agregar producto al carrito
    Cuando agrego el producto al carrito
    Entonces podré ver el mensaje de la alerta "Product added"

  @CP07
  Escenario: Verificar producto en carrito
    Cuando agrego el producto al carrito
    Y podré ver el mensaje de la alerta "Product added"
    Y accedo a la sección Cart desde el menú
    Entonces podré ver el producto "Samsung galaxy s6" agregado en mi carrito de compras

  @CP08
  Escenario: Eliminar producto del carrito
    Cuando agrego el producto al carrito
    Y podré ver el mensaje de la alerta "Product added"
    Y accedo a la sección Cart desde el menú
    Y elimino el producto "Samsung galaxy s6" del carrito
    Entonces el producto "Samsung galaxy s6" desaparecerá del listado
