FROM openjdk:17-jdk-slim

LABEL maintainer="thomas1.maestas@gmail.com"

COPY target/mapl-graph-1.3.0.jar mapl-graph.jar

ENTRYPOINT ["java", "-jar", "mapl-graph.jar"]
