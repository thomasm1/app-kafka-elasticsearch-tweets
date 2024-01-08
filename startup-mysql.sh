#!/bin/bash
docker pull mysql/mysql-server:latest && \
docker run --name=mysqlContainer -p 3306:3306 -d mysql/mysql-server:latest && \
#docker logs mysqlContainer
docker exec -it mysqlContainer mysql -uroot -p && \
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';
CREATE DATABASE myDB;
#SHOW DATABASES;
CREATE USER 'user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%';
FLUSH PRIVILEGES;
SELECT host, user FROM mysql.user;
