FROM eclipse-temurin:11

LABEL maintainer=thomas1.maestas@gmail.com

WORKDIR /app

COPY target/mapl-gateway-1.0.0.jar /app/mapl-gateway.jar

ENTRYPOINT ["java", "-jar", "mapl-gateway.jar"]

