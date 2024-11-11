# Fase 1: Construcción del archivo JAR utilizando Maven
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo pom.xml y las fuentes para que Maven pueda usarlo durante la construcción
COPY pom.xml .
COPY src ./src

# Ejecutar Maven para construir el archivo JAR, omitiendo las pruebas
RUN mvn clean package

# Fase 2: Ejecutar la aplicación con OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado en la fase de construcción al contenedor
COPY --from=build /app/target/student-service-1.0-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
