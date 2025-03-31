#!/bin/bash
mvn clean package -Dmaven.test.skip=true  && \
java -jar build/libs/*0.jar
