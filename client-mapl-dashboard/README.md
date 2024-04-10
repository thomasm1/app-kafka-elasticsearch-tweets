### April 30, 2024
### MICROSERVICES - Notes
##### Conversion to separate micro-apps for modularity/scalability
Client-mapl-dashboard:
Functional Requirements:
I.(0th layer) unique User Accounts: email based <i>example@anymail.ca </i>
II.(1st layer) Intra-Chain-based blockchain-based NFTs [for example, ERC-721] Tokens <i>on</i>- chain. <i>42-digit hexadecimal token ID</i>
III.(2nd layer) Intra-Chain, Layer-2-based blockchain-based NFTs [for example, Polygon] Tokens <i>off</i>-chain. <i>42-digit hexadecimal token ID</i> Concatenated on ChainId Ethereum
IV. (3rd layer) Inter-Chain-based [cross-bridge] blockchain-based NFTs & Token Balances.    
V.ERC-20 Token Balances
4th Dimensional Matrix custodial database structure, which makes for a challenging Java Security and Authentication Framework.
```json
{
  "User": {
    "email": "  ,,,",
    "password": "  ,,,,,",
    "token": "  ,,,,,,",
    "nfts-ethereum-layer1 custody": [
      {
        "nft1": {
          "chain": "  ,,,,,,",
          "token": "  ,,,,,,,",
          "metadata": "  ,,,,,,,,",
          "balance": "  ,,,,,,,,,",
          "price": "  ,,,,,,,,,,,",
          "status": "  ,,,,,,,,,,,, ",
          "date": "  ,,,,,,,,,,,,, ",
          "time": "  ,,,,,,,,,,,,,,, ",
          "location": "  ,,,,,,,,,,,,,,,,",
          "event": "  ,,,,,,,,,,,,,,,,,, ,"
        }
      },
      {
        "nft2": {
          "chain": "  ,,,,,,",
          "token": "  ,,,,,,,,",
          "metadata": "  ,,,,,,,,,"
        }
      }
    ],
    "nfts-ethereum-layer2-polygon custody": [
      {
        "nft1": {
          "chain": "  ,,,,,,",
          "token": "  ,,,,,,,"
        }
      },
      {
        "nft2": {
          "chain": "  ,,,,,,",
          "token": "  ,,,,,,,,"
        }
      }
    ],
    "nfts-Solana-cross-chain-layer3-custody": [
      {
        "nft1": {
          "chain": "  ,,,,,,",
          "token": "  ,,,,,,,"
        }
      },
      {
        "nft2": {
          "chain": "  ,,,,,,",
          "token": "  ,,,,,,,,"
        }
      }
    ]
  }
}
```

I. User Account Security - Authentication
A. User Account Creation
1. should allow users to create using email and password
2. app login is disabled until email is verified
3. App should send email with link to confirm new user account

B. Reset Password
1. should allow users to reset password
2. app should send a link to user email to reset password, link should expire in 1 hour or when clicked.
3. app should present scren with a form to reset password when above email link is clicked.

C. MFA  
1. should allow users to enable MFA from sms message/QR code to secure account
2. MFA uses QR code to enable Google Authenticator or Authy
3. The app should allow users to scan QR code using authenticator app on their phone to set up MFA
3. the app should ask users to enter QR code from mobile phone authenticator app in order to log in successfully

D. Login
1. should allow users to login using email and password
2. If MFA is enabled, app should ask for QR code after email and password are entered

II. User Information Management
A. User Management
1. should allow users to update their profile information, email, password, and MFA settings
2. should allow users to delete, view their account information. 

B.. User Profile Management 
2. Token and Login variables

B. User NFT Management

III. Access-Control Lists  User Document-Style for Data Structure Management
A. Design -->  Secure Document Management System is store, update, updload and delte documents. addreses need for centralized and secure repository for sensicive information --encrypted keys, offering  
a solution for intra-chain, intra-cross-chain and inter-cross-chain address types containing NFTs and token balances.
B. Public keys only are stored for data management, and public keys are secondly used to look up (upon initial user setup) and subsequent monitoring for on-chain behavior, displayed locally
 
B. Role-based access control allows to define user privileges based on their roles and permissions, maintaining data integrity. 
   Authorized users can perform actions (update, delete, etc ) on documents [i.e. access to data <i>within<i> the encrypted envelope.

C. User Role
app gives roles to users.
App roles should contain specific permissions (authorities).    
Roles grant different access levels.
app should only allow users with the correct role to perform certain actions:update, delete. 
App onlhy allows non-user roles to view other user's out-facing documents. 
So, for example, a user with the role of "admin" can perform all actions, while a user with the role of "user" can only view, edit own documents. But module "system-viewer" is command interface for viewing across public users (nft collections on display)

D. Audit Trail 
App keeps track of who creaed an entitty user, document, time stamps, etc. 

C. Document Upload
User can upload documents to the system, formats include DOC, DOCX, XLS, PDF, CSV, JSON.  Data stored in the database.
D. Dashboard screen: 
1. Upper left quadrant of Navbars: User Profile
2. Upper right quadrant of Navbars: User NFTs, Token Balances, and Transactions - Ethereum Layer 1
3. Lower left quadrant of Navbars: User NFTs, Token Balances, and Transactions - Polygon Layer 2
4. Lower right quadrant of Navbars: User NFTs, Token Balances, and Transactions - Solana Layer 3
5. Center of Navbars: User Document Management System
6. Footer: User Logout 



### Security
1. User Authentication
Original: UsernamePasswordAuthenticationFilter->AuthenticationManager->AuthenticationProvider->UserDetailsService
    a. Security Flow: UPAFilter->ProviderManager[Authentication Manager]->DaoAuthenticationProvider[AuthenticationProvider]->InMemoryUserDetailsManager[UserDetailsService]
New: JWTAuthenticationFilter->JWTAuthorizationFilter->AuthenticationManager->AuthenticationProvider->UserDetailsService
    b. Security Filters: JWT
2. User Authorization
3. User Role Management
4. User Document Management
5. User Document Upload
6. User Document Download
7. User Document Update
8. User Document Delete
9. User Document Access Control Lists


### Cloud Native Microservices 
### Eureka Server
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
