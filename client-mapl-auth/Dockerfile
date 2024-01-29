FROM eclipse-temurin:17
LABEL maintainer="thomas1.maestas@gmail.com"
WORKDIR /app
COPY target/mapl-authorization-service*.jar /app/mapl-auth.jar
ENTRYPOINT ["java", "-jar", "mapl-auth.jar"]
