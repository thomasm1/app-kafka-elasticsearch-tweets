#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version
docker pull container-registry.oracle.com/database/express:latest

#docker image inspect oracle
CONTAINER_NAME="$@"

docker container run -d  -p 1521:1521 --name "$CONTAINER_NAME" -e ORACLE_PWD=root -v oracle-vol:/var/lib/oracle container-registry.oracle.com/database/express:latest
docker container inspect "$CONTAINER_NAME"
docker volume inspect oracle-vol
docker ps
#docker exec -it "$CONTAINER_NAME" bash
 
 
