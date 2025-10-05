# Étape 1 : Build du projet Java avec Maven
FROM maven:3.9.4-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copier les fichiers Maven (pom.xml + sources)
COPY pom.xml .
COPY src ./src

# Télécharger les dépendances et compiler le projet
RUN mvn clean package -DskipTests

# Étape 2 : Image finale avec uniquement le JAR
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copier le jar compilé depuis l'étape précédente
COPY --from=builder /app/target/application-0.0.1-SNAPSHOT.jar application-0.0.1-SNAPSHOT.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "application-0.0.1-SNAPSHOT.jar"]
