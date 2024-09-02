FROM openjdk:17-jdk-slim

LABEL maintainer=thomas1.maestas@gmail.com

COPY target/mapl-config-server-1.2.0.jar mapl-config-server.jar

ENTRYPOINT ["java", "-jar", "mapl-config-server.jar"]
