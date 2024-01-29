FROM eclipse-temurin:17

MAINTAINER Thomas Maestas "thomas.maestas@hotmail.com"

ENV version=localhost
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=password

ENV jdbcurl=jdbc:mysql://mysqldb:3306/dashboard_db

WORKDIR /app
COPY target/*mapl*.*ar /app/mapl-dashboard.war
CMD ["java", "-jar", "mapl-dashboard.war"]

