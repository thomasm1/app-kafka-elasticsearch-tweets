#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version
docker pull mysql
#docker image inspect mysql
CONTAINER_NAME="$@"
##  docker container run -d -p 3306:3306 --name mysql --env MYSQL_ROOT_PASSWORD=root mysql 
docker container run -d  -p 3306:3306 --name "$CONTAINER_NAME" -e MYSQL_ALLOW_EMPTY_PASSWORD=True -v mysql-vol:/var/lib/mysql mysql 
#docker container inspect mysql
#docker volume inspect mysql-vol