
#### Spring Cloud Netflix Eureka
#### Spring Cloud Zuul
#### Spring Cloud Config
#### Spring Security OAuth2
#### Spring Cloud Gateway

```SH
curl http://localhost:8761/eureka/apps
 ```

Port(s): 8761 (http) with context path ''
REGISTRY (Eureka)
http://localhost:8761/

GATEWAY (Zuul)
http://10.0.0.139:9191/actuator/info
{"app": {
"name": "Gateway Server",
"description": "Mapl Server Application",
"version": "1.0.0" }}

CONFIG SERVER (Spring Cloud Config)
http://10.0.0.139:8888/actuator
"self": {
"href": "http://10.0.0.139:8888/actuator",
"templated": false
},
"health": {
"href": "http://10.0.0.139:8888/actuator/health",
"templated": false
},
"health-path": {
"href": "http://10.0.0.139:8888/actuator/health/{*path}",
"templated": true
}

AUTHENTICATION SERVER (Spring Security)
