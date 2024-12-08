#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version
docker pull rabbitmq:3.12.0-management

winpty docker run --rm -it --name rabbitmq_container -p 15672:15672 -p 5672:5672 rabbitmq:3.12.0-management
#http://localhost:15672/  user: guest, password: guest