FROM eclipse-temurin:17

MAINTAINER thomasm1.maestas@gmail.com
LABEL maintainer=thomas1.maestas@gmail.com

ENV version=localhost
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=password
ENV jdbcurl=jdbc:mysql://mysqldb:3306/dashboard_db

WORKDIR /app
COPY target/*mapl*.*ar /app/mapl-dashboard.war
CMD ["java", "-jar", "mapl-dashboard.war"]


WORKDIR /app

COPY /target/mapl-service-registry-1.0.0.jar /app/mapl-service-registry.jar

ENTRYPOINT ["java","-jar","mapl-service-registry.jar"]
