# ==== build ====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build

COPY pom.xml ./pom.xml
COPY ms-comidas/pom.xml     ms-comidas/pom.xml
COPY ms-comidas/src         ms-comidas/src
COPY ms-maridaje/pom.xml    ms-maridaje/pom.xml
COPY ms-maridaje/src        ms-maridaje/src

# 👇 Agregamos spring-boot:repackage
RUN mvn -DskipTests -pl ms-maridaje -am clean package spring-boot:repackage

# ==== runtime ====
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /build/ms-maridaje/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
