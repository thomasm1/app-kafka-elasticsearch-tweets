#Authors: thomas.maestas@hotmail.com, et al.
#Keywords Summary : DoggyWood Client Login
#Feature: Existing DoggyWood Customer should be able to login into account, enter info 
#Scenario: Business rule through list of steps with arguments.
#Given: User navigates to doggywood website
#When: User clicks on the login button on homepage AND User enters uname and pw
#Then: User should be taken to the successful client landing page  
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Register as a DoggyWood Customer
  Online person should be able to register with first and last name, email, password, phone and url.

@tag1
Scenario: Register with email, password, first and last name.
  Given User navigates to doggywood website
  And User clicks on the register button on homepage
  And User provides a first name
  And User provides a last name
  And User provides a valid email
  And User provides a valid password
  And User provides a phone number
  And User provides a photo url
  When User clicks on submit button
  Then User is redirected to login page 
	   
  #@tag2 
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
