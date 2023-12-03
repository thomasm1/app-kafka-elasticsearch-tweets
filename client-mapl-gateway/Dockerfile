FROM eclipse-temurin:17

LABEL maintainer=thomasm1.maestas@gmail.com

WORKDIR /app

COPY target/mapl-gateway-1.0.0.jar /app/mapl-gateway.jar

ENTRYPOINT ["java", "-jar", "mapl-gateway.jar"]

