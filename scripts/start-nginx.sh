#!/bin/bash

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