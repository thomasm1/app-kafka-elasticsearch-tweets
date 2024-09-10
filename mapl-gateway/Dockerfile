FROM openjdk:17-jdk-slim

LABEL maintainer=thomas1.maestas@gmail.com

COPY target/mapl-gateway-1.2.0.jar mapl-gateway.jar

ENTRYPOINT ["java", "-jar", "mapl-gateway.jar"]

