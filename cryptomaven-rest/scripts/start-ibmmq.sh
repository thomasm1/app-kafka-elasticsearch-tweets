#!/bin/bash

docker pull ibmcom/mq:latest

docker volume create mqlocalvolume

docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume mqlocalvolume:/mnt/mqm
   --publish 1414:1414 --publish 9443:9443 --name mqlocal --detach --env MQ_APP_PASSWORD=passw0rd ibmcom/mq:latest
   
docker exec -it [a3v200c] bash
# dspmqver
# dspmq
docker ps

[[ https://localhost:9443/ibmmq/console     username: admin, password:  passw0rd    <-zero 0