#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version
docker pull thomasm1/tom-mysql && \
docker container run -d -p 3306:3306 --name tom-mysql --env MYSQL_ROOT_PASSWORD=password
