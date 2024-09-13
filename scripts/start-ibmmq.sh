#!/bin/bash

docker pull ibmcom/mq:latest

docker volume create mqlocalvolume

docker run \
     --env LICENSE=accept  \
     --env MQ_QMGR_NAME=QM1  \
     -env MQ_APP_PASSWORD=passw0rd \
      #  --env MQ_ADMIN_PASSWORD=adminPass123 \
     --volume mqlocalvolume:/mnt/mqm \
     -p 1414:1414 -p 9443:9443 \
     --name mqlocal 
     --detach ibmcom/mq:latest
   
docker exec -it mqlocal bash
# dspmqver
# dspmq
docker ps
#[[ https://localhost:9443/ibmmq/console     username: admin, password:  passw0rd    <-zero 0

 