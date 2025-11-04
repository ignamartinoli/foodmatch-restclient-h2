# ==== build ====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build

# POM padre + ambos módulos (para que el reactor no falle)
COPY pom.xml ./pom.xml
COPY ms-comidas/pom.xml     ms-comidas/pom.xml
COPY ms-comidas/src         ms-comidas/src
COPY ms-maridaje/pom.xml    ms-maridaje/pom.xml
COPY ms-maridaje/src        ms-maridaje/src

# 👇 Agregamos spring-boot:repackage
RUN mvn -DskipTests -pl ms-comidas -am clean package spring-boot:repackage

# ==== runtime ====
FROM eclipse-temurin:21-jre
WORKDIR /app
# El repackage reemplaza el jar principal (salvo que tu POM use classifier)
COPY --from=build /build/ms-comidas/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]

