FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY ./target/*.war bibliotek-boot.war

CMD [ "java", "-jar", "bibliotek-boot.war" ]

EXPOSE 8080
