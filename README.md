# JustEat
Just Eat is an online food order and delivery service which acts as an intermediary between independent take-out food outlets and customers. JUST EAT website can be use to find open takeaway restaurants by using postcode area
JUST EAT has a website available at http://www.just-eat.co.uk/

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
 
### Introduction
 In this project we are automating the **JUST EAT** website to achieve the below scenario:
  ```
  Feature: Use the website to find restaurants
           So that I can order food
           As a hungry customer
           I want to be able to find restaurants in my area
  Scenario: Search for restaurants in an area
           Given I want food in "AR51 1AA"
           When I search for restaurants
           Then I should see some restaurants in "AR51 1AA"
  ```

### Technologies
To automate the project, I have used Selenium WebDriver with Cucumber framework as we have already got the scenario for Ghekin file.
Based on the Ghekin file scenario I have generated the StepDefinition file where I have used Java Language to automate the Just Eat Site for each steps of the Scenario. Below is the structure of the automation project:
* 
