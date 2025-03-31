#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version

if [ "$(docker ps -aq -f name=mongodb_container)"]; 
then
     echo "Mongo Image already on local system"
else
     docker pull mongo
     echo "Mongo image pulled from Registry"
fi




if [ "$(docker ps -q -f name=mongodb_container)" ]; then
    echo "MongoDB container is already running."
else
    docker run -p 27017:27017 --name mongodb_container -d mongo
    echo "MongoDB container started."
fi

# List running containers
docker ps

# Enter the MongoDB container
#docker exec -it mongodb_container bash

# Start the MongoDB shell
# mongosh

# show dbs
# use mydb
# db.mydb.insertOne({name: "John Doe", age: 30})
# db.mydb.find()

# # Exit the MongoDB container
# exit
