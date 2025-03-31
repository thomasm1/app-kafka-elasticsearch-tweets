
## Microservices Introduction
```aiexclude
* Controlled by Kubernetes
* microservice network: 
  - Server-side Processing (java)
    - Ports: 
        - 8761: registry-service
        - 8888: config-server    
        - 9191: api-gateway
        - 8081: client-authorization service
        - 8082: client-rest-cryptomaven
        - 8083: client-rest-dailytech
        - 8084: client-dashboard-service
 
```
## 0 Kubernetes: infra/k8s/*.yaml

## 1 Registry-service: http://localhost:8761/


## Config Server Local Configuration
spring.config.import: optional:configserver:http://localhost:8888
eureka.instance.client.serverUrl.defaultZone: http://localhost:8761/eureka/
eureka.client.register-with-eureka: true
eureka.client.fetch-registry: true

## API Gateway Local Config

Application	AMIs	Availability Zones	Status
#### CONFIG-SERVER	n/a (1)	(1)	UP (1) - 10.0.0.229:CONFIG-SERVER:8888
#### MAPL-GATEWAY	n/a (1)	(1)	UP (1) - 10.0.0.229:MAPL-GATEWAY:9191
#### AUTH-SERVICE	n/a (1)	(1)	UP (1) - host.docker.internal:AUTH-SERVICE:8081
#### DAILYTECH-REST	n/a (1)	(1)	UP (1) - 10.0.0.229:DAILYTECH-REST:8082
#### CRYPTOMAVEN-REST	n/a (1)	(1)	UP (1) - 10.0.0.229:CRYPTOMAVEN-REST:8083
#### MAPL-DASHBOARD	n/a (1)	(1)	UP (1) - 10.0.0.229:MAPL-DASHBOARD:8084
 
 
  ![image](https://github.com/user-attachments/assets/25bd3492-59d4-4a63-8ade-48cd02bac4d5)


## Distributed Tracing Config
                  oo
                 oooo
                oooooo
               oooooooo
              oooooooooo
             oooooooooooo
           ooooooo  ooooooo
          oooooo     ooooooo
         oooooo       ooooooo
        oooooo   o  o   oooooo
       oooooo   oo  oo   oooooo
     ooooooo  oooo  oooo  ooooooo
    oooooo   ooooo  ooooo  ooooooo
oooooo   oooooo  oooooo  ooooooo
oooooooo      oo  oo      oooooooo
ooooooooooooo oo  oo ooooooooooooo
oooooooooooo  oooooooooooo
oooooooo  oooooooo
oooo  oooo

     ________ ____  _  _____ _   _
    |__  /_ _|  _ \| |/ /_ _| \ | |
      / / | || |_) | ' / | ||  \| |
     / /_ | ||  __/| . \ | || |\  |
    |____|___|_|   |_|\_\___|_| \_|

:: version 2.23.19 :: commit 0831f9b ::

2025-03-30 19:54:43.891  INFO [/] 12944 --- [oss-http-*:9411] c.l.a.s.Server                           : Serving HTTP at /[0:0:0:0:0:0:0:0]:9411 - http://127.0.0.1:9411/
