# GenomeBankAPI (sin JWT) - Proyecto para pruebas

Esta versión **no** incluye autenticación. Está pensada para usar con **H2 in-memory** y probar en Postman fácilmente.

Pasos rápidos:
1. Importa el proyecto en IntelliJ como un proyecto Maven.
2. Ejecuta la clase `com.project.genomebankapi.GenomeBankApiApplication`.
3. Visita `http://localhost:8080/h2-console` para ver la BD (url: jdbc:h2:mem:genomebank, user: sa, password: empty).
4. Usa Postman para probar endpoints como `GET /species`, `POST /species`, etc.
