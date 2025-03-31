FROM eclipse-temurin:17

LABEL maintainer="thomas1.maestas@gmail.com"

WORKDIR /app

COPY target/cryptomaven-rest-*.0.jar /app/cryptomaven-rest.jar

ENTRYPOINT ["java", "-jar", "cryptomaven-rest.jar"]
