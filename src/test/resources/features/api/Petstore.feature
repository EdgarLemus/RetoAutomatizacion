# language: es
@api
Característica: Gestión de Mascotas

  Antecedentes:
    Dado que tengo acceso a la API de gestión de mascotas

  Esquema del escenario: Adicionar una nueva mascota
    Cuando agrego una nueva mascota
      | Id   | CategoryId   | CategoryName   | Name   | PhotoUrls   | TagsId   | TagsName   | Status   |
      | <Id> | <CategoryId> | <CategoryName> | <Name> | <PhotoUrls> | <TagsId> | <TagsName> | <Status> |
    Entonces la mascota debe ser registrada correctamente en la API
      | Status |
      | 200    |
    Ejemplos:
      | Id | CategoryId | CategoryName | Name     | PhotoUrls                                                             | TagsId | TagsName | Status    |
    #Data:src/main/resources/DataEntry/Petstore.xlsx|E01

  Escenario: Verificar mascota agregada
    Cuando consulto la información de la mascota
    Entonces la mascota debe ser consultada correctamente en la API
      | Status |
      | 200    |

  Esquema del escenario: Modificar nombre de la mascota
    Cuando actualizo el nombre de la mascota
      | Id   | CategoryId   | CategoryName   | Name   | PhotoUrls   | TagsId   | TagsName   | Status   |
      | <Id> | <CategoryId> | <CategoryName> | <Name> | <PhotoUrls> | <TagsId> | <TagsName> | <Status> |
    Entonces la mascota debe ser consultada correctamente en la API
      | Status |
      | 200    |
    Ejemplos:
      | Id     | CategoryId | CategoryName | Name            | PhotoUrls                                                             | TagsId | TagsName | Status    |
    #Data:src/main/resources/DataEntry/Petstore.xlsx|E02

  Escenario: Verificar nombre de mascota modificado
    Cuando consulto la información de la mascota
    Entonces debo ver el nombre "PugCarlino_Luna" actualizado correctamente

  Escenario: Eliminar mascota
    Cuando elimino la mascota
    Entonces la mascota debe ser consultada correctamente en la API
      | Status |
      | 200    |
