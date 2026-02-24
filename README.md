# MoviePlay API

## Descripción
MoviePlay es una API REST desarrollada con **Spring Boot** que gestiona un catálogo de películas.  
Permite realizar operaciones CRUD, validaciones de negocio y consultas dinámicas sobre el catálogo.

El proyecto fue desarrollado como parte de un proceso de especialización en **backend con Java y Spring**, aplicando principios de **arquitectura limpia**, separación de responsabilidades y buenas prácticas de diseño.

La aplicación está desplegada en **Render** y expone documentación interactiva mediante **Swagger/OpenAPI**:

**Swagger UI:**  
[https://movieplay-424k.onrender.com/movie-play/api/swagger-ui/index.html](https://movieplay-424k.onrender.com/movie-play/api/swagger-ui/index.html)

## Stack Tecnológico

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Gradle
- MapStruct
- Spring Validation
- Springdoc OpenAPI (Swagger)
- Docker
- LangChain4j (integración con IA)

## Arquitectura
Arquitectura en capas orientada al dominio:  

```

Controller → Service → Repository → Entity → Database

````

- **Controller:** Expone los endpoints REST y gestiona las respuestas HTTP.  
- **Service:** Contiene la lógica de negocio y coordina operaciones.  
- **Repository:** Abstrae el acceso a la base de datos.  
- **Entity:** Representa las tablas mediante JPA.  
- **DTO / Modelo de Dominio:** Desacopla la API de la capa de persistencia.  

Se aplica el patrón **Data Mapper** mediante **MapStruct** para traducir entre entidades JPA y modelos de dominio.  
Esta estructura favorece mantenibilidad, escalabilidad y pruebas unitarias.

## Qué demuestra este proyecto

- Construcción de APIs REST robustas con Spring Boot.  
- Persistencia con Spring Data JPA.  
- Validaciones con Bean Validation.  
- Manejo centralizado de excepciones.  
- Uso de MapStruct para mapeo desacoplado.  
- Documentación automática con OpenAPI.  
- Configuración de perfiles de entorno.  
- Integración con PostgreSQL.  
- Contenerización con Docker.  
- Despliegue en la nube (Render).  
- Integración básica de Inteligencia Artificial para recomendaciones.

## Funcionalidad de IA
El proyecto integra **LangChain4j** para generar sugerencias de películas basadas en el catálogo.  

**Ejemplo conceptual de uso:**

1. El usuario consulta una película.  
2. El sistema puede generar recomendaciones similares utilizando los datos existentes.  
3. La IA puede sugerir títulos relacionados por género, temática o estilo.  

Esto demuestra cómo complementar una API tradicional con capacidades de IA sin romper la arquitectura en capas.

## Ejecución local

### 1. Construcción
```bash
./gradlew build
````

### 2. Ejecutar

```bash
java -jar build/libs/movieplay-1.0.0.jar
```

## Base de Datos (Entorno Dev)

**PostgreSQL**

Se requiere:

* Usuario: `psantana`
* Contraseña: `password`
* Base de datos: `movie_play_db`

La configuración puede ajustarse en `application.properties` o mediante variables de entorno.

### Docker

El proyecto está preparado para ejecutarse mediante Docker.

* **Construir imagen:**

```bash
docker build -t movieplay .
```

* **Ejecutar contenedor:**

```bash
docker run -p 8080:8080 movieplay
```

También puede utilizarse **docker-compose** si se desea levantar PostgreSQL junto con la aplicación.

## Swagger / OpenAPI

Documentación disponible en:
[https://movieplay-424k.onrender.com/movie-play/api/swagger-ui/index.html](https://movieplay-424k.onrender.com/movie-play/api/swagger-ui/index.html)

Permite probar todos los endpoints directamente desde el navegador.

## Enfoque de Diseño

Este proyecto busca demostrar:

* Dominio claro y desacoplado.
* Arquitectura limpia.
* Preparación para escalar hacia microservicios.

