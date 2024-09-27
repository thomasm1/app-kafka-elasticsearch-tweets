FROM openjdk:17-jdk-slim

LABEL maintainer="thomas1.maestas@gmail.com"

COPY target/client-mapl-dashboard-1.2.0.war mapl-dashboard.war

ENTRYPOINT ["java", "-jar", "mapl-dashboard.war"]
