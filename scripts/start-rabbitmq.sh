#!/bin/bash

docker pull rabbitmq:3.11.0

docker run --rm -it -p 5672:5672 rabbitmq:3.11.0