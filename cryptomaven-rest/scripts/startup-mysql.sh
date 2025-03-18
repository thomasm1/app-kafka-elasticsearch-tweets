#D!i/bin/bash
#docker pull mysql/mysql-server:latest && \
docker run --name mysqlContainer --publish 3306:3306 -d 1d9c2 && \
#docker logs mysqlContainer
docker exec -it mysqlContainer mysql -uroot -p && \
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';
CREATE DATABASE myDB;
#SHOW DATABASES;
CREATE USER 'user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%';
FLUSH PRIVILEGES;
SELECT host, user FROM mysql.user;
