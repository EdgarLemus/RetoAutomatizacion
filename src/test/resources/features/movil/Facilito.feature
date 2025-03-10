# language: es
Característica: Validacion E2E aplicativo Facilito

  Antecedentes: 
    Dado que abro la aplicacion de facilito

  Escenario: Validar la pantalla inicial
    Entonces podre observar en pantalla el texto "The App"
    Y podre observar en pantalla el texto "Choose An Awesome View"

  Escenario: Acceder a la pantalla de Login
    Cuando ingreso en el link Login Screen
    Entonces podre observar en pantalla el texto "Login"

  Escenario: Validar funcionalidad de Clipboard Demo
    Cuando ingreso en el link ClipBoard Demo
    Y escriba el texto "Consubanco" para asignarlo al portapapeles
    Entonces podre observar en pantalla el texto "Consubanco"
