FROM ubuntu-jdk

MAINTAINER Thomas Maestas "thomas.maestas@hotmail.com"

ENV version=localhost

ENV dbuser=root
ENV dbpass=root
ENV jdbcurl=jdbc:mysql://mysqldb:3306/grootdb

WORKDIR /usr/local/bin

ADD "target/mapl.war" .

ENTRYPOINT ["java", "-jar", "friendsofgroot.war"]
