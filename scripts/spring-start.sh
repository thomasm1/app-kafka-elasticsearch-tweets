#!/bin/bash
spring init --build maven --dependencies=web,webflux,data-jpa,h2 -g "xyz.cryptomaven" -n HierarchyApi ha
unzip -o hierarchyapi.zip -d .
rm hierarchyapi.zip
