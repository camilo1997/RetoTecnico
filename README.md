# Automatización de Servicios Rest 

##  Descripción

Este es un proyecto Maven donde se usan los principales verbos GET,POST,PUT, DELETE en la API de ejemplo:  https://dummyapi.io/data/v1/.

##  Stack Técnico

* Maven para gestión de librerías.
* Java 8.
* Serenity con BDD Screenplay.
* Cucumber con Serenity.
* Serenity Rest con Serenity y Screenplay.
* Hamcrest.
* Patron de diseño Screenplay.

## Ejecución local
***
Para construir el proyecto:
```
mvn clean compile
```
Para ejecutar los test y generar el reporte:
```
mvn clean verify
```
El reporte sera creado en:
```
/target/site/index.html
```
