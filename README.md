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

1. Code Structure: All the java files are available in `src\test\java` folder
   - `\PageObjects\TestBase.java` : With base class we can avoid code duplication and can reuse the code as much we want. Here all the common methods are written which are been called in the StepDefinitions class file like Clicking on button, Enter the text in textbox etc. I have extended this class in the StepDefinitions class to call the custom methods directly as needed. It also helps in inplementation of Lazy evaluation
   - `\Runners\MainRunner.java` :  Test runner class is used here to run Cucumber feature file either through TestNG or Junit. In addition to running a cucumber feature file, it acts as an interlink between feature files and step definition classes.
   - `\stepDefinitions\searchrest.java` : StepDefinition (searchrest) class maps the Scenario Steps of the feature files(written in the format of Given/When/Then) with the code. This executes the steps of the scenarios provided in the Gherkin file and checks the outcomes against expected results.

2. Resources structure: All the resources used in the project are present in `src\test\resources` folder including Gheking feature file
   - `\executables` : This folder is used to store all the drivers which can be used in the project. I have used `chromedriver.exe` for the execution of the project. In case you need to execute the script in IE driver then the .exe file for the same should be present in this folder and the IE driver should be initiated instead of Chrome driver in `searchrest.java` file
   - `\features` : This folder consists of all the feature files with the extension `.feature`. Currently it consist of \searchrest.feature which defines the scenario mentioned in **Introduction**

