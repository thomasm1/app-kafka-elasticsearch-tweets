FROM openjdk:17-jdk-slim

LABEL maintainer="thomas1.maestas@gmail.com"

COPY target/-1.3.0.jar mapl-integration.jar

ENTRYPOINT ["java", "-jar", "mapl-integration.jar"]