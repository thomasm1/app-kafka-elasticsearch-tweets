FROM openjdk:17-jdk-slim
LABEL maintainer="thomas1.maestas@gmail.com"
COPY target/mapl-authorization-1.3.0.jar mapl-auth.jar
ENTRYPOINT ["java", "-jar", "mapl-auth.jar"]
