# language: es
@Web
Característica: Registro e Inicio de Sesión

  Antecedentes:
    Dado que me encuentro en la pantalla inicial de Store

  Regla: El sistema debe permitir el ingreso de los siguientes formulario

  @CP01
  Escenario: Registro de usuario
    Cuando realizo el registro de una nueva cuenta
    Entonces podré ver el mensaje de la alerta "Sign up successful."

  @CP02
  Esquema del escenario: Inicio de sesión
    Cuando ingreso mis credenciales y accedo a la plataforma
      | Username   | Password   |
      | <Username> | <Password> |
    Entonces podré ver mi nombre de usuario "<Username>" en la esquina superior derecha
    Ejemplos:
      | Username   | Password     |
    #Data:src/main/resources/DataEntry/AutenticacionUsuario.xlsx|E01
|EdgarLemus|Pruebas2025*|

  @CP03
  Esquema del escenario: CA09 - Cierre de sesión
    Cuando ingreso mis credenciales y accedo a la plataforma
      | Username   | Password   |
      | <Username> | <Password> |
    Y cierre la sesion en la plataforma de Store
    Entonces se cerrará mi sesión y seré redirigido a la pantalla principal de Store
    Ejemplos:
      | Username   | Password     |
    #Data:src/main/resources/DataEntry/AutenticacionUsuario.xlsx|E01
|EdgarLemus|Pruebas2025*|
