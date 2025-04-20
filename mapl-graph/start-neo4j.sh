;pp#!/bin/bash
NEO_IMAGE="neo4j:2025.03.0-ubi9"

if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version

if [ "$(docker ps -aq -f name=neo4j_container)"]; 
then
     echo "Neo4j Image already on local system"
else
     docker pull "$NEO_IMAGE"
     echo "Neo4j image pulled from Registry"
fi




if [ "$(docker ps -q -f name=neo4j_container)" ]; then
    echo "Neo4j container is already running."
else
    docker run --restart always -p 7474:7474 -p 7687:7687 --name neo4j_container --env NEO4J_AUTH=none -d neo4j "$DOCKER_IMAGE"
    echo "Neo4j container started."
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
