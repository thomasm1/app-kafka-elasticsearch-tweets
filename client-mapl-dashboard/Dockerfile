FROM eclipse-temurin:17
#    container_name: mysqldb
#    image: 'thomasm1/mysql:latest'

MAINTAINER thomas1.maestas@gmail.com
LABEL maintainer=thomas1.maestas@gmail.com

ENV env=localhost
ENV MYSQL_DATABASE=dashboard_db
ENV PORT=3306
ENV PORT2=33060
ENV version=1.0.1
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=password
ENV jdbcurl=jdbc:mysql://mysqldb${PORT}/${MYSQL_DATABASE}
ENV DEFAULT_EMAIL_USERNAME=${DEFAULT_EMAIL_USERNAME}
ENV DEFAULT_EMAIL_PASSWORD=${DEFAULT_EMAIL_PASSWORD}

ENV JAVA_OPTS="-Xms256m -Xmx512m -Dspring.profiles.active=mysql -Djava.security.egd=file: -Dbuild.version=${version} -Dapp.mapl.mail.host=smtp.gmail.com -Dapp.mapl.mail.port=587 -"

WORKDIR /app
COPY libs/friendsofgroot.jar /app/friendsofgroot.jar
CMD ["java","-jar","friendsofgroot.jar"]

#WORKDIR /app
#COPY libs/mapl-config-server.jar /app/mapl-config-server.jar
#CMD ["java","-jar","mapl-config-server.jar"]
#
#WORKDIR /app
#COPY libs/mapl-service-registry-1.0.0.jar /app/mapl-service-registry.jar
#CMD ["java","-jar","mapl-service-registry.jar"]

WORKDIR /app
COPY target/*mapl*.*ar /app/mapl-dashboard.war
ENTRYPOINT ["java", "-jar", "mapl-dashboard.war"]
