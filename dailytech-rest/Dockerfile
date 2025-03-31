FROM openjdk:17-jdk-slim

LABEL maintainer=thomas1.maestas@gmail.com

COPY target/dailytech-rest-*.0.jar dailytech-rest.jar

ENTRYPOINT ["java", "-jar", "dailytech-rest.jar"]

