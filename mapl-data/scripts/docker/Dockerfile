FROM eclipse-temurin:17

LABEL maintainer="thomas1.maestas@gmail.com"

WORKDIR /app

COPY target/friendsofgroot.war /app/friendsofgroot.war

ENTRYPOINT ["java", "-jar", "friendsofgroot.war"]
