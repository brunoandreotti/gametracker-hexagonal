
FROM maven:3.9.6 AS build

COPY /src /app/src

COPY /pom.xml /app

RUN mvn -f /app/pom.xml clean package -DskipTests


FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]