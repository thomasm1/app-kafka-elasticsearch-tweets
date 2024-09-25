#!/bin/bash
cd src/test/java/functional-tests && \
mvn package && \
java -jar target/*.jar
