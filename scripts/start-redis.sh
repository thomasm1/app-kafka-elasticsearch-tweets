#!/bin/bash

docker pull redis:latest

docker run -dit -p 6379:6379 --name redis_container -e SPRING_DATA_REDIS_CONNECT-TIMEOUT=2s -e SPRING_DATA_HOST=redis -e SPRING_DATA_PORT=6379 -e SPRING_DATA_TIMEOUT=1s   redis

#docker stop redis_container
docker logs redis_container

# Load testing
sudo apt-get update 
sudo apt-get install -y apache2-utils

yum install httpd-tools

ab -n 1000 -c 100 http://localhost:6379/
ab -n 10 -c 2 -v 3 http://localhost:8072/mapl/cards/api/contact-info
