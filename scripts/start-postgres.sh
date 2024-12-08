#!/bin/bash
if ! command -v docker &> /dev/null
then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi
docker --version
docker pull postgres:16-alpine
docker images 
docker run --name=myPostgresContainer -p 5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=password -e POSTGRES_DB=n8n -d postgres:16-alpine
docker logs myPostgresContainer # !! save generated root password 
docker exec -it myPostgresContainer psql -U root n8n
	
    
    
    
