#!/bin/bash

docker pull mysql
#docker image inspect mysql

##  docker container run -d -p 3306:3306 --name mysql --env MYSQL_ROOT_PASSWORD=root mysql 
docker container run -d  -p 3306:3306 --name mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=True -v mysql-vol:/var/lib/mysql mysql 
#docker container inspect mysql
#docker volume inspect mysql-vol