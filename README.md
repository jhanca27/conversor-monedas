## Conversor de monedas

Este es un proyecto para convertir el valor de una moneda.

## Dependency Management

![](https://img.shields.io/badge/version-Java_21-blue)
![](https://img.shields.io/badge/Gson-2.11.0-blue)

## Folder Structure

El siguiente area de trabajo contiene las siguientes carpetas principales:

- `src`: Esta carpeta contiene los principales recursos:
- `settings.json`: Este archivo maneja las configuraciones del proyecto y las dependencias.

Mientras tanto, los archivos de salida compilados se generarán en la carpeta bin de forma predeterminada.

## Estructura del Proyecto

El proyecto se divide en los siguientes paquetes y clases:

### Paquete: `errors`
- `ErrorResponse.java`: Maneja las respuestas de error que se reciben de la api.

### Paquete: `models`
- `Conversor.java`: Clase principal que contiene el objeto principal que maneja el conversor.
- `ConversorRecord.java`: Clase que permite recibir los datos de las respuesta de la api .

### Paquete: `utils`
- `ConexionAPI.java`: Clase para manejar la conexión con la API.
- `CrearUrl.java`: Clase para crear URLs necesarias para las peticiones a la API.
- `Json.java`: Clase para manejar la conversión y manipulación de datos JSON.
- `LocalDateTimeAdapter.java`: Adaptador para manejar conversiones de fechas y horas al momento de serialización.
- `Response.java`: Clase para manejar las respuestas de las peticiones.
- `Principal.java`: Clase principal del proyecto y donde se ejecuta.
- `ProvadorFecha.java`: Clase para probar y validar pruebas.

## Compilación y Ejecución

Los archivos de salida compilados se generarán en la carpeta `bin` de forma predeterminada.

### Requisitos
- JDK 11 o superior


### Ejecución
Para Ejecutar el proyecto, ejecute el siguiente comando desde la raíz del proyecto:

```sh
java -cp bin com.jh.Principal
````

## Api:
se va a consumir una api para conseguir los valores de tasa de cambio entre monedas. 
https://www.exchangerate-api.com

