# app-web-alumnos

## Descripción

La aplicación **app-web-alumnos** es una aplicación web para gestionar alumnos y usuarios utilizando **Spring Boot** con **Thymeleaf** para la vista y **JPA** para la persistencia de datos en una base de datos MySQL. La aplicación permite crear, editar, eliminar y listar alumnos, así como gestionar usuarios con opciones de registro y autenticación.

## Funcionalidades

- **Gestión de Alumnos**:
  - Crear nuevos alumnos.
  - Editar datos de alumnos existentes.
  - Eliminar alumnos.
  - Buscar alumnos por nombre, apellido, DNI, etc.
  - Listar todos los alumnos con sus detalles.

- **Gestión de Usuarios**:
  - Registro de nuevos usuarios.
  - Inicio de sesión con autenticación de credenciales.
  - La aplicación utiliza el campo `activo` para gestionar la activación de cuentas de usuario.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Thymeleaf**
- **Bootstrap 5**
- **MySQL**

## Estructura del Proyecto

- **`src/main/java/com/keepcoding/app/web/entity`**:
  - Clases de entidad `Alumno` y `Usuario` que representan las tablas en la base de datos.
  
- **`src/main/java/com/keepcoding/app/web/repository`**:
  - Interfaces que extienden `JpaRepository` para interactuar con la base de datos.
  
- **`src/main/java/com/keepcoding/app/web/service`**:
  - Interfaces para los servicios de `Alumno` y `Usuario` con sus implementaciones en `serviceImpl`.

- **`src/main/java/com/keepcoding/app/web/controller`**:
  - Controladores para manejar las peticiones HTTP y gestionar las vistas.

- **`src/main/resources/templates`**:
  - Plantillas Thymeleaf para las vistas de la aplicación.

- **`src/main/resources/application.properties`**:
  - Configuraciones de la aplicación. He añadido `spring.mvc.date-format=yyyy-MM-dd` y `spring.mvc.format.date=yyyy-MM-dd` para resolver problemas de validación de fechas en los formularios de creación y edición de alumnos.
