## groot-app

Java Application for Friends of Groot Society
<a style="margin-left:35%;" href="https://friendsofgroot.com">
<img width="100" src="https://friends-of-groot-society.s3.amazonaws.com/assets/grootsmall.png" title="Friends_of_Groot_Society_App" alt="Friends_of_Groot_Society_Image"></a>

### Groot Society Fan Club Groot NFT Tracker

 <a style="text-decoration:none;color:black;" href="https://friendsofgroot.com">
Friends_of_Groot_Society - https://friendsofgroot.com</a>

### Full-Stack application that manages Groot Fan Club News and Features

### Author

> Thomas Maestas

### Application Overview

The mission of the app is to organize and persist Groot Fan Club News and NFT-related Activies.

#### Features
#### NOTES:
 * 6/26 - Spring-Data-Rest 
 * 6/27 - SpringDoc -- https://springdoc.org/v2/getting-started
   * available at http://server:port/context-path/swagger-ui.html
   * descriptioN: http://server:port/context-path/v3/api-docs
   * docs: in YML: http://server:port/context-path/v3/api-docs.yaml
   

#### Data Structures

Address -> NftAddress -> nfts[] Nft-> Metadata

### Technologies

| Fx           |       Tools       |         URLS |
|--------------|:-----------------:|-------------:|
| Database     | Oracle DB 19c St. | [Oracle 19c] | 
| Cloud Data   |    Amazon RDS     |    [AWS-RDS] | 
| Cloud ASsets |     Amazon S3     |     [AWS-S3] |
| User Data    |     Angular 8     |    [Angular] |
| UI/UX        | Angular-Bootstrap |        [BS4] |
| E2E Testing  |     Selenium      |   [Selenium] |
| CI/CD        |      Jenkins      |    [Jenkins] |
| Pipeline     |   AWS Codebuild   |  [CodeBuild] |

 
## ENVIRONMENT PRODUCTION
### AWS-RDS _  ORACLE

DBMS: Oracle (ver. Oracle Database 19c Standard Edition 2 Release 19.0.0.0.0 - Production
Version 19.15.0.0.0)
Case sensitivity: plain=upper, delimited=exact
Driver: Oracle JDBC driver (ver. 21.5.0.0.0, JDBC4.3)
 
## ENVIRONMENT QA 
### Containerization
### Docker MySQL

mysql thomas1/mysql9
DBMS: MySQL (ver. 8.0.31)
Case sensitivity: plain=exact, delimited=exact
Driver: MySQL Connector/J (ver. mysql-connector-java-8.0.25 (Revision: 08be9e9b4cba6aa115f9b27b215887af40b159e0), JDBC4.2)
 
### ENVIRONMENT DEV 
### H2 MYSQL
## ENVIRONMENT

### Vendor-neutral application observability facade:
## Spring Framework 6.0
### spring cloud sleuth with zipkin
#### https://cloud.spring.io/spring-cloud-sleuth/reference/html/#zipkin
### spring cloud
#### https://cloud.spring.io/spring-cloud-static/spring-cloud.html
### spring boot
#### https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
### spring framework
#### https://docs.spring.io/spring-framework/docs/current/reference/html/
### micrometer
#### https://micrometer.io/docs
 
#

##### Angular8:

Typescript development Framework that integrates HTML5 templates, CSS styling, which compiles Typescript into JavaScript
using WebPack, taskrunner module bundler

##### Jenkins:

Open source automation server which enables us to reliably build, test, and deploy their software-->grabs .

##### AWS Relational Databases

Cloud-based dynamic servers hosting Apache Tomcat, dataBase endpoints

##### AWS EC2:

hosting application for Jenkins to run tests

##### AWS S3

hosts static assets like our

##### AWS CodeBuild:

        fully managed continuous integration service that compiles #source code, runs tests, and produces software packages 

##### AWS RDS:

set up, operate, and scale a DB in the cloud. Cost-efficient and resizable capacity automating administration tasks such
as hardware provisioning, database setup, patching and backups.

##### PostMan

complete API development environment. Today we have 8 million developers and over 400K companies using our comprehensive
set of built-in tools to support every stage of the API lifecycle. With Postman you can design, mock, debug, test,
document, monitor, and publish your APIs all in one place.

#### TomCat Server

Apache Tomcat is an open-source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and
WebSocket technologies. Tomcat provides a "pure Java" HTTP web server environment in which Java code can run.

#### Hibernate Object Relational Mapper

ORM enables developers to more easily write applications whose data outlives the application process. As an
Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational
databases (via JDBC)

#### Testing Libraries:

```json
{
  "Jenkins": "2.0",
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
  "tslint": "~5.15.0"
}
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
* As a user, I can view the nfts on the lot. 
* As a user, I can make an offer for a nft. 
* As a user, I am alerted if offer APPROVED/DECLINED
* As a user, I can view the nfts that I own. 
* As a user, I can view my remaining payments for a nft(s) I own.
```

** Software **

[Oracle]: <https://www.oracle.com/database/technologies/112010-win64soft.html>

[AWS-RDS]: <https://aws.amazon.com/rds/>

[AWS-S3]: <https://aws.amazon.com/s3/>

[Angular]: <https://angular.io/>

[BS4]: <https://numpy.org/>

[Selenium]: <https://selenium.dev/documentation/en/>

[Jenkins]: <https://jenkins.io/>

[CodeBuild]:<https://aws.amazon.com/codebuild/>

website: [groot.io](https://friendsofgroot.com)

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
