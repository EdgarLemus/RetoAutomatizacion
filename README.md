# CSB-Examen-Automatizacion

Este repositorio contiene la automatización de pruebas E2E para aplicaciones web, móviles y API utilizando **Java, Serenity BDD, Screenplay, Appium y Gradle**.

## 📌 Tecnologías utilizadas

- **Java**
- **Serenity BDD**
- **Screenplay Pattern**
- **Appium**
- **Gradle**
- **Cucumber**

## 📂 Estructura del Proyecto

```plaintext
CSB-Examen-Automatizacion/
│── src/
│   ├── main/
│   │   ├── java/  # Código principal de automatización
│   │   ├── resources/
│   │   │   ├── features/  # Archivos feature de Cucumber
│   │   │   ├── DataEntry/  # Archivos JSON y XLSX para pruebas
│   ├── test/
│── build.gradle  # Configuración de Gradle
│── README.md  # Este archivo
```

## 🚀 Instalación y Configuración

1. **Clonar el repositorio**
   ```sh
   git clone https://github.com/tu-usuario/CSB-Examen-Automatizacion.git
   cd CSB-Examen-Automatizacion
   ```

2. **Configurar las dependencias**
   ```sh
   ./gradlew clean build
   ```

3. **Configurar Appium**
    - Instalar Appium Server
    - Configurar un emulador o dispositivo físico
    - Ajustar las capacidades en el código según el dispositivo

## 🧪 Ejecución de Pruebas

### 🔹 Pruebas API
```sh
./gradlew test -Dcucumber.options="src/main/resources/features/api"
```

### 🔹 Pruebas Web
```sh
./gradlew test -Dcucumber.options="src/main/resources/features/web"
```

### 🔹 Pruebas Móviles
```sh
./gradlew test -Dcucumber.options="src/main/resources/features/mobile"
```

## 📜 Casos de Prueba Implementados

### 🌐 E2E Web - [DemoBlaze](https://www.demoblaze.com/index.html)
- Registro y login de usuario
- Navegación y validación de productos
- Agregar y eliminar productos del carrito
- Cierre de sesión

### 📱 E2E Móvil
- Navegación y validaciones de interfaz
- Interacción con elementos de la aplicación móvil

### 🔗 API - [PetStore](https://petstore.swagger.io/v2/)
- Crear, modificar y eliminar mascotas

## 📊 Reportes
Los reportes se generan automáticamente en `target/site/serenity/index.html` después de la ejecución.

## 📝 Notas Adicionales
- Se usan archivos **JSON y XLSX** en `src/main/resources/DataEntry` para la gestión de datos.
- El código de automatización está en `src/main/java` en lugar de `src/test/java`.

---
🚀 **¡Listo para ejecutar las pruebas y validar la automatización!**
