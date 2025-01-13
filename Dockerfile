# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR que se genera al construir el proyecto
COPY target/*.jar app.jar

# Expone el puerto en el que tu aplicación correrá (por defecto 8080 para Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "app.jar"]
