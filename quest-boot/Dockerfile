FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

# Télécharger les dépendances Maven
# L'option -B permet d'exécuter la commande maven en mode Batch (pas d'interaction avec l'utilisateur)
RUN mvn dependency:go-offline -B

COPY ./src ./src

RUN mvn clean verify sonar:sonar -Dsonar.projectKey=TP1-Docker -Dsonar.projectName='TP1-Docker' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_d182c3a1318937435ab1e4ca324721525daef9a2

# RUN rm -R src
# RUN rm pom.xml
# RUN mv target/quest-boot-0.0.1-SNAPSHOT.jar quest-boot.jar
# RUN rm -R target

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/target/*.war quest-boot.war

CMD [ "java", "-jar", "quest-boot.war" ]

EXPOSE 8080



