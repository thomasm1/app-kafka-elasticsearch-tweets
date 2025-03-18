#!/bin/bash

# AFter aws configure....
aws dynamodb create-table \
    --table-name DailyTech \
    --attribute-definitions \
    AttributeName=Id,AttributeType=S \
    AttributeName=did,AttributeType=S \
    --key-schema \
    AttributeName=Id,KeyType=HASH \
    AttributeName=did,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
  
aws dynamodb batch-write-item --request-items file://items-dailytech.json

aws dynamodb get-item \
  --table-name DailyTech \
  --key '{"Id": {"S": "472e94ce-8e10-4403-ac4b-e19b12ce4c51"}, "did": {"S": "18-04-07"}}'
