<a style="margin-left:20%;" href="http://doggywood.s3-website-us-east-1.amazonaws.com
">
<img width="200" src="https://doggywood.s3.amazonaws.com/assets/style6.png" title="Doggywood_Veterinary_App" alt="Doggywood_Veterinary_Image"></a>

### Doggywood Veterinarian Data Tracker 
> <a style="text-decoration:none;color:black;" href="http://doggywood.s3-website-us-east-1.amazonaws.com">Appointment and Pet Records Management URL</a>

> Full-Stack application that manages clients' and employees' appointments and records
 
### Authors
> Thomas Maestas
> Brendan Wilson
> Davis Cowles
> Ruben Colons

### Application Overview
The mission of the app is to organize and persist health and appointment information relating to clients and the client's pets. The architecture provides a service-based design managing both customers' and receptionists' data-related tasks. The system maintains vaccination records dynamically by tracking expiration dates, with notifications to customers of upcoming vaccination expiries and other information. 

#### Purposes
The veterinarians are able to record notes based off the clients visits, and those notes will be tied to the client's pet in the graphical user interface. The goal of this application is to reduce the workload of data entry on the employees, as well as maintain a structured note system and portable vaccination record for the pets that visit the practice using an intuitive interface.

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
```
#### Application User Stories
```sh 
As an employee, I can login.
As an employee, I can add appointments.
As an employee, I can add notes about the pets.
As an employee, I add notes about the pets appointment.
As an employee, I can view my upcoming appointments.
As an employee, I can view information about the client.
As an employee, I can view information about the pet.
As an employee, I can add customers.
As an employee, I can add pets to the customer
As an employee, I can add vaccinations to an pet
As an employee, I can view the weights of the pet on the dates of their appointment.
 
As a customer, I can login to an account.
As a customer, I can fill out a form with my information.
As a customer, I can see notes on what my pet was treated for.
As a customer, I can view a list of my owned pets.
As a customer, I add a new pet.
As a customer I can book an appointment    
As a customer, I can upload relevant documents about my dog into the system.
As a customer, I download copies of my vaccination/health records.
As a customer, I can see the age of my pet. 

As a system, it will notify us in some way if the vaccination record has expired.
As a system, it will notify us if the vaccination record will expire before the scheduled visit.
```
 
** Software **

* [Oracle]: <https://www.oracle.com/database/technologies/112010-win64soft.html>
* [AWS-RDS]: <https://aws.amazon.com/rds/>
* [AWS-S3]: <https://aws.amazon.com/s3/>
* [Angular]: <https://angular.io/>
* [BS4]: <https://numpy.org/>
* [Selenium]: <https://selenium.dev/documentation/en/>
* [Jenkins]: <https://jenkins.io/> 
* [CodeBuild]:<https://aws.amazon.com/codebuild/> 
   
  website: [doggywood.io](http://doggywood.s3-website-us-east-1.amazonaws.com/t)
 

#### URLS for Angular/Material:
#### https://material.io
#### https://angular.io 
This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.21. 


### INSTRUCITONS:  Development server
 
## JSON SERVER
npm install -g json-server
json-server info.json --watch

 
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

 
