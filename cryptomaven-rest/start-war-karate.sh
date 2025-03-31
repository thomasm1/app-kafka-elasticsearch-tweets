#!/bin/bash
cd src/test/java/functional-tests && \
mvn clean package && \
java -jar target/*.jar
