FROM eclipse-temurin:17

LABEL maintainer="thomas1.maestas@gmail.com"

WORKDIR /app

COPY target/mapl-data-1.2.0.war /app/mapl-data.war

ENTRYPOINT ["java", "-jar", "mapl-data.war"]
