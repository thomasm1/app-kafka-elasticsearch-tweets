#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version
docker pull nginx:latest

docker tag nginx:latest localhost:5000/nginx:latest
docker images
 
curl http://localhost:5000/v2/_catalog
#You should see "nginx" listed as a repository.
#{"repositories":["nginx"]}
#docker rmi nginx:latest
#docker images
#docker rmi localhost:5000/nginx:latest
#docker images
#docker pull localhost:5000/nginx
#docker images
#docker run -d localhost:5000/nginx
#docker ps
ip a