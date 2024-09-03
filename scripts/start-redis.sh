#!/bin/bash

docker pull redis:latest

docker run -dit --name redis_container redis

#docker stop redis_container
docker logs redis_container