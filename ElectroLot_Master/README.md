### _E-Cars Car Lot Management Application  
```sh
	#======================# 
 	#====All-Star_E-Cars===# 
   #======================# 
```
  
### URL:  

### AUTHOR:
-Thomas Maestas

## INSTRUCTIONS:
		String adminUsername = "admin"; 
		String adminPassword = "pass";  

		String tempUsername = "cust";
		String tempPassword = "pass";

```sh
mvn clean test
mvn package
```
...Logging by Log4j2.

MUST: 
1. update OJDBC driver & configure in src
2. update string location below on local
class oracle.jdbc.driver.OracleDriver
... JDBC Drive successfully connected.
Main class in UserMain, Run as Java Application
userMain.java --> line 83. update path
	Welcome script file not found: 	C://Users/thoma/w/www/java-devops/project0/src/main/java/systemUser/scannertext.txt

## Mathematics and Optimization: 
This app uses hashing algorithms to optimize the calculations of the inventory demo dataset. 

This app uses structs, in the formal sense of Solidity language, rather that C, etc. 
Structs, by definition. (computing, programming) A data structure, especially one that serves to group a number of fields (in contrast to an object-oriented class with methods) or one that is passed by value rather than by reference. noun.	
]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
The Car Dealership app is a console-based application that facilitates the purchasing of cars. An employee can add cars to the lot and manage offers for those cars, while a customer can view the cars on the lot and make offers.
## Functionalities: 
2. Data is stored in a Oracle database. 
3. A custom-stored-procedure is called to perform some portion of the functionality.  
4. Data Access is performed through use of JDBC data layer consisting of Data Access Objects.
5. All input is received using the java.util.Scanner class.
### Logging 
6. Log4j is implemented to log events to a file, which logs info, warnings, exceptions, and events, i.e., adding car to db, offers made by customers, etc.)
### Testing 
7. All DAOs should have JUnit tests.  ## CRUD (takes 20 mins)
8. 80% Code Coverage 15 JUnit test is written to test some functionality outside of DAOs. ## can test/assert ...

## Primary Goal:
The goal of this application is to reduce the workload of data entry on the employees, as well as maintain a structured note system and portable vaccination record for the pets that visit the practice using an intuitive interface.
## Architecture:
Java & SQL-based data-management includes Service layer that instantiates static methods to implement DAO interface methods. 
## Data Layer: 
These DAO methods connect to the Data Layer using JDBC Interface methods to access the database operated from AWS RDS-housed Oracle servers. 
## Database Server
AWS RDS hosts Oracle 11se servers 
## Data Tables:
3 Foreign-Keys-linked tables, 4 custom-stored procedures, and 1 stored function. 
My SQL tables are sufficiently atomic, non-redundant, and functionally independent to achieve 1st, 2nd, and 3rd forms normalization. 

## User Stories:
* As a user, I can login.  
* As a user, I can register for a customer account. 

* As a customer, I can view the cars on the lot. 
* As a customer, I can make an offer for a car. 
* As a customer, I can view the cars that I own. 
* As a customer, I can view my remaining payments for a car.

* As an employee, I can add a car to the lot.
* As an employee, I can accept or reject an offer for a car.
* As an employee, I can remove a car from the lot.
* As an employee, I can view all payments.

* As the system, I reject all other pending offers for a car when an offer is accepted.
* As the system, I can calculate the monthly payment. 

### TECHNOLOGIES
| Fx | Tools | URLS |
|------------|:------------:|---------:|
| Database | Oracle SE 11 | [Oracle]  | 
| Cloud Data | Amazon RDS |  [AWS] | 
| Cloud Assets | Amazon S3 |  [S3]  |
| User Data | Angular 8 |  [Angular]  |
| UI/UX | Angular-Bootstrap |  [BS4] |
| E2E Testing | Selenium | [Selenium] |
| CI/CD | Jenkins | [Jenkins] |
| Pipeline | AWS Codebuild | [CodeBuild] |
   
### Testing Libraries:
"Jenkins" : "2.0",
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
"tslint": "~5.15.0",

### Software **

* [Oracle]: <https://www.oracle.com/database/technologies/112010-win64soft.html>
* [AWS-RDS]: <https://aws.amazon.com/rds/>
* [AWS-S3]: <https://aws.amazon.com/s3/>
* [Angular]: <https://angular.io/>
* [BS4]: <https://numpy.org/>
* [Selenium]: <https://selenium.dev/documentation/en/>
* [Jenkins]: <https://jenkins.io/> 
* [CodeBuild]:<https://aws.amazon.com/codebuild/> 
  
 ### NOTES AND TODOS

6/26
Results :

Tests in error:
  get_car_make(serviceTests.CarServiceTest)
  add_new_car(serviceTests.CarServiceTest)
  update_car(serviceTests.CarServiceTest)
  get_car(serviceTests.CarServiceTest)
  delete_car(serviceTests.CarServiceTest)
  update_offer(serviceTests.OfferServiceTest)
  delete_offer(serviceTests.OfferServiceTest)
  add_new_offer(serviceTests.OfferServiceTest)
  get_offer(serviceTests.OfferServiceTest)
  delete_user(serviceTests.UserServiceTest)
  add_new_user(serviceTests.UserServiceTest)
  update_user(serviceTests.UserServiceTest)
  get_user(serviceTests.UserServiceTest)

Tests run: 20, Failures: 0, Errors: 13, Skipped: 0


 