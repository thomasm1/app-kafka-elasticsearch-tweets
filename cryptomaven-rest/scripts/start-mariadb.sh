#!/bin/bash
docker pull mariadb
docker run -p 3307:3306 --name localhost -e MYSQL_ROOT_PASSWORD=password  MYSQL_DATABASE=dashboard_db -e MYSQL_USER=root MYSQL_PASSWORD=password -d mysql:latest
docker exec -it [xa3cbcydef1] bash
mysql -u root -p

docker run --network dashboard-mysql-net --name dashboard-mysql-container2 -p 8080:8080 docker logs -f
docker run --name mysqldb --network dashboard-mysql-net -e MYSQL_ROOT_PASSWORD=password MYSQL_DATABASE=dashboard_db -e MYSQL_USER=root
