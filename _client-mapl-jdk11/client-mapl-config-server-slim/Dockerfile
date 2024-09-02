FROM eclipse-temurin:17

LABEL maintainer=thomas1.maestas@gmail.com

WORKDIR /app

COPY target/mapl-config-server-1.0.0.jar /app/mapl-config-server.jar

ENTRYPOINT ["java", "-jar", "mapl-config-server.jar"]
