#!/bin/bash
docker pull thomasm1/tom-mysql && \
docker container run -d -p 3306:3306 --name tom-mysql --env MYSQL_ROOT_PASSWORD=password
