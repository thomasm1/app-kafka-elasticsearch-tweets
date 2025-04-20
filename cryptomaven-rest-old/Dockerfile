FROM eclipse-temurin:17

LABEL maintainer="thomas1.maestas@gmail.com"

WORKDIR /app

COPY build/libs/cryptomaven-rest-1.3.0.jar /app/cryptomaven-rest.jar

ENTRYPOINT ["java", "-jar", "cryptomaven-rest.jar"]
