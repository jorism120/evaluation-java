
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/application-0.0.1-SNAPSHOT.jar application-0.0.1-SNAPSHOT.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "application-0.0.1-SNAPSHOT.jar"]
