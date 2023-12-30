FROM ubuntu-jdk

MAINTAINER Thomas Maestas "thomas.maestas@hotmail.com"

ENV version=localhost

ENV dbuser=mapl
ENV dbpass=abc123!!
ENV jdbcurl=jdbc:mysql://mysqldb:3306/mapl_db

WORKDIR /usr/local/bin

ADD "target/mapl.war" .

ENTRYPOINT ["java", "-jar", "mapl.war"]
