# Consideraciones/Aclaraciones

No se implementó un microservicio de carreras. En cambio, se permite agregar cualquier ID de carrera en la tabla de inscripciones. En una implementación completa habría que chequear si ese ID pertenece a una carrera válida haciéndole una peticion al microservicio mencionado.

# Guia para testear los diferentes endpoints:

## Microservicio de inscripciones
El microservicio de inscripciones corre en el puerto 8082.
Endpoints dispobibles:
- /inscription
    - GET: Usado para saber si el servicio esta funcionando. No recibe ningun parámetro y devuelve {"message":"Inscription index!"}.
    - POST: Usado para agregar una inscripcion. Recibe dos parámetros, el ID del estudiante como un RequestParam, y una carrera en el body de la request.

        Ejemplo:  
        ```
        curl --location --request POST 'http://localhost:8082/inscription?id_estudiante=2' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "id": 1,
            "nombre": "Matematica"
        }'
- /inscription/all
    - GET: Devuelve todas las inscripciones. Solo incluye los ID presentes, no busca los datos de los estudiantes. No recibe parámetros.
- /inscription/carrera/{id}
    - GET: Devuelve las inscripciones que incluyan a la carrera con el ID provisto.
      Ejemplo:
      ```
      curl --location --request GET 'http://localhost:8082/inscription/carrera/1'
    - DELETE: Borra las inscripciones que incluyan a la carrera con el ID provisto.
      Ejemplo:
      ```
      curl --location --request GET 'http://localhost:8082/inscription/carrera/1'
- /inscription/student/{id}
    - GET: Devuelve las inscripciones que incluyan al estudiante con el ID provisto.
      Ejemplo:
      ```
      curl --location --request GET 'http://localhost:8082/inscription/student/1'
    - DELETE: Borra las inscripciones que incluyan al estudiante con el ID provisto.
      Ejemplo:
      ```
      curl --location --request GET 'http://localhost:8082/inscription/student/1'
## Microservicio de estudiantes
El microservicio de estudiantes corre en el puerto 8081.
Endpoints dispobibles:
- /student
    - GET: Usado para saber si el servicio esta funcionando. No recibe ningun parámetro y devuelve {"message":"Student index!"}.
    - POST: Usado para agregar un estudiante. Recibe un parámetro, los datos de un estudiante en el body de la request (sin incluir el ID).
      Ejemplo:
      ```
      curl --location --request POST 'http://localhost:8081/student' \
      --header 'Content-Type: application/json' \
      --data-raw '{
        "nombre": "Nicolas",
        "apellido": "Dartayeta",
        "edad": 21,
        "genero": "M",
        "dni": 44859810,
        "ciudad": "Mar del Plata",
        "libreta": 44859810
      }'
- /student/all
    - GET: Devuelve todos los estudiantes de los que se tiene registro con sus datos. No recibe ningun parámetro.
- /student/{id}
    - GET: Devuelve los datos del estudiante con el ID provisto.
    - DELETE: Elimina un usuario de la base de datos. Tambien le pide al microservicio de inscripciones que elimine las inscripciones que contengan a ese usuario.
      Ejemplo:
      ```
      curl --location --request DELETE 'http://localhost:8081/student/1' \
    - PATCH: Endpoint para modificar parcialmente los datos de un usuario. Recibe en el body los atributos a modificar.
      Ejemplo:
      ```
      curl --location --request PATCH 'http://localhost:8081/student/2 \
      --header 'Content-Type: application/json' \
      --data-raw '{
      "nombre": "Carlos",
      "ciudad": "Mendoza"
      }'
