
### November 20, 2023
### MICROSERVICES - Notes
##### Conversion to separate micro-app; replication.
1. Separate service-registry
2. Remove @EnableEurekaServer
3. Disable Eureka Server as Client
4. Launch eureka server 5
5. Register Dep
## mapl-app
Java Application: "My Personal Librarian": MaPL
<a style="margin-left:20%;" href="https://mapl.app">
<img width="200" src="https://friends-of-groot-society.s3.amazonaws.com/assets/grootsmall.png" title="Friends_of_Groot_Society_App" alt="Friends_of_Groot_Society_Image"></a>

### Groot Society Fan Club Groot NFT Tracker 
> <a style="text-decoration:none;color:black;" href="https://mapl.app">Friends_of_Groot_Society - https://mapl.app</a>

> Full-Stack application that manages Groot Fan Club News and Features
 
### Author 
> Thomas Maestas 



### Application Overview
The mission of the app is to organize and persist Groot Fan Club News and NFT-related Activies.

#### Features

#### Data Structures
Address -> NftAddress -> nfts[] Nft-> Metadata

#### Application User Stories
```sh

* -----------
* As an society-administrator, I can login.
* As an society-administrator, I can add news-bulletins.
* As an society-administrator, I can add notes about Groot and the Guardians.
* As an society-administrator, I add notes about Groot and the Guardians news-bulletins.
* As an society-administrator, I can view my upcoming news-bulletins.
* As an society-administrator, I can view information about the members.
* As an society-administrator, I can view information about Groot and the Guardians.
* As an society-administrator, I can add society-member (fan)s.
* As an society-administrator, I can add badges to the society-member (fan)
* As an society-administrator, I can add news-updates to society-members
* As an society-administrator, I can view the status of Groot and the Guardians on the dates of events.
* -----------
* As a society-member (fan), I can login to an account.
* As a society-member (fan), I can fill out a form with my information. 
* As a society-member (fan), I can view a list of my owned badges.
* As a society-member (fan), I add a new badge.
* As a society-member (fan) I can sign up for news-bulletins    
* As a society-member (fan), I can upload my photo into the system.  
* --------------
* As a system, it will notify members if an event is upcoming.
* As a system, it will notify members of a co-awarded badge.
--------------
* As a customer, I can view the nfts on the lot. 
* As a customer, I can make an offer for a nft. 
* As a customer, I am alerted if offer APPROVED/DECLINED
* As a customer, I can view the nfts that I own. 
* As a customer, I can view my remaining payments for a nft(s) I own.
```
### Technologies 
| Fx | Tools | URLS |
|-----------------|:-----------------:|---------:|
| Database | Oracle SE 11 | [Oracle]  | 
| Cloud Data | Amazon RDS |  [AWS-RDS] | 
| Cloud ASsets | Amazon S3 |  [AWS-S3]  |
| User Data | Angular 8 |  [Angular]  |
| UI/UX | Angular-Bootstrap |  [BS4] |
| E2E Testing | Selenium | [Selenium] |
| CI/CD | Jenkins | [Jenkins] |
| Pipeline | AWS Codebuild | [CodeBuild] |
   
##### Angular8: 
Typescript development Framework that integrates HTML5 templates, CSS styling, which compiles Typescript into JavaScript using WebPack, taskrunner module bundler
##### Jenkins:  
Open source automation server which enables us to reliably build, test, and deploy their software-->grabs .
#####  AWS Relational Databases
Cloud-based dynamic servers hosting Apache Tomcat, dataBase endpoints
##### AWS EC2:  
hosting application for Jenkins to run tests
##### AWS S3  
hosts static assets like our 
##### AWS CodeBuild:  
        fully managed continuous integration service that compiles #source code, runs tests, and produces software packages 
##### AWS RDS:  
set up, operate, and scale a DB in the cloud. Cost-efficient and resizable capacity automating administration tasks such as hardware provisioning, database setup, patching and backups. 
##### PostMan
complete API development environment. Today we have 8 million developers and over 400K companies using our comprehensive set of built-in tools to support every stage of the API lifecycle. With Postman you can design, mock, debug, test, document, monitor, and publish your APIs all in one place.
#### TomCat Server
Apache Tomcat is an open-source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and WebSocket technologies. Tomcat provides a "pure Java" HTTP web server environment in which Java code can run.
#### Hibernate Object Relational Mapper
ORM enables developers to more easily write applications whose data outlives the application process. As an Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational databases (via JDBC)
#### Testing Libraries:
```json
{"Jenkins" : "2.0",
  "codelyzer": "^5.0.0",
  "jasmine-core": "~3.4.0",
  "jasmine-spec-reporter": "~4.2.1",
  "karma": "~4.1.0",
  "karma-chrome-launcher": "~2.2.0",
  "karma-coverage-istanbul-reporter": "~2.0.1",
  "karma-jasmine": "~2.0.1",
  "karma-jasmine-html-reporter": "^1.4.0",
  "protractor": "~5.4.0",
  "ts-node": "~7.0.0",
  "tslint": "~5.15.0"}
```
INNER-ARCHITECTURE
CliApplication => ServletInitializer()

CliApplication => 
    View() => 
        [singleton]Controller() => 
            [singleton]Manager()  => 
                DaoImpl => DataStore

CliApplication =>
    MainDashboard.mainUser(args) => [[VARS: DRIVER, SRC_DATA_STARTUP_TEXT_TXT]]

CliLogger => [Singleton Logger Log4j]


 
** Software **

  [Oracle]: <https://www.oracle.com/database/technologies/112010-win64soft.html>
  [AWS-RDS]: <https://aws.amazon.com/rds/>
  [AWS-S3]: <https://aws.amazon.com/s3/>
  [Angular]: <https://angular.io/>
  [BS4]: <https://numpy.org/>
  [Selenium]: <https://selenium.dev/documentation/en/>
  [Jenkins]: <https://jenkins.io/> 
  [CodeBuild]:<https://aws.amazon.com/codebuild/> 
   
  website: [groot.io](https://mapl.app)
#### TESTS
##### Behavior-Driven Design Tests
> Cucumber feature usability testing

##### Test-Driven Design
> Front: Selenium (Protractor)-automated Jasmine tests
> Server: Selenium-TestNG automated JUnit tests

#### URLS for Angular/Material:
#### https://material.io
#### https://angular.io 
This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.21. 


### INSTRUCITONS:  Development server
 
## JSON SERVER
npm install -g json-server
json-server info.json --watch

  

INFRASTRUCTURE

###   Documentation
###   REGISTRY
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)
* [Eureka Server](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server)

* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)




###   Gateway
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)
* [Gateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)
* 
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#actuator)
* [Using Spring Cloud Gateway](https://github.com/spring-cloud-samples/spring-cloud-gateway-sample)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

###   CONFIG-SERVER


* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)
* [Config Server](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_spring_cloud_config_server)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#actuator)
*
* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

* 
###   REST MVC

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
