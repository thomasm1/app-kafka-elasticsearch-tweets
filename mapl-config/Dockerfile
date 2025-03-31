FROM openjdk:17-jdk-slim

LABEL maintainer=thomas1.maestas@gmail.com

COPY target/mapl-config-*.0.jar mapl-config.jar

ENTRYPOINT ["java", "-jar", "mapl-config.jar"]
