#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version
docker pull rabbitmq:3.11.0

docker run --rm -it -p 5672:5672 rabbitmq:3.11.0