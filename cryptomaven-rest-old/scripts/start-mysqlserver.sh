#!/bin/bash
docker pull mysql/mysql-server:latest
docker images 
docker run --name=mySQLContainer -p 3306:3306 -d mysql/mysql-server:latest
docker ps 
docker logs mySQLContainer # !! save generated root password 
docker exec -it mySQLContainer mysql -uroot -p 
	
#ALTER USER 'root'@'localhost' IDENTIFIED BY 'uhgmjg8i7y-h87b,tyr99jy6';
#CREATE DATABASE dashboard_db
#SHOW DATABASES
#CREATE USER 'admin'@'%' IDENTIFIED BY 'abc123!!';
#GRANT ALL PRIVILEGES ON * . * TO 'admin'@'%';
#FLUSH PRIVILEGES;
#SELECT host, user FROM mysql.user;  
#verify  entry for | % | user | in your table. 
#| host | user    | 
#| %     | admin |   \