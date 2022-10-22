#Authors: thomas.maestas@hotmail.com, et al.
#Keywords Summary : DoggyWood Client Login
#Feature: Existing DoggyWood Customer should be able to login into account, enter info 
#Scenario: Business rule through list of steps with arguments.
#Given: User navigates to doggywood website
#When: User clicks on the login button on homepage AND User enters uname and pw
#Then: User should be taken to the successful client landing page  
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples:  
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login into Doggywood account
	Existing DoggyWood Customer should be able to login into account using correct credentials

@tag1
Scenario: Login into account with correct details
	Given User navigates to doggywood website
	And User clicks on the login button on homepage
	And User enters a valid username
	And User enters a valid password
	When User clicks on the login button
	Then User should be taken to the successful client landing page  
	
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
