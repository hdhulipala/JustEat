# JustEat
Just Eat is an online food order and delivery service which acts as an intermediary between independent take-out food outlets and customers. JUST EAT website can be use to find open takeaway restaurants by using postcode area
JUST EAT has a website available at http://www.just-eat.co.uk/

## Table of contents
* [Introduction](#introduction)
* [Technologies and Folder structure](#technologies and folder structure)
 
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

### Technologies and Folder structure
To automate the project, I have used Selenium WebDriver with Cucumber framework as I have already got the scenario for Ghekin file.
Based on the Ghekin file scenario I have generated the StepDefinition file where I have used Java Language to automate the Just Eat Site for each steps of the Scenario. Below is the structure of the automation project:

1. Code Structure: All the java files are available in `src\test\java` folder
   - `\PageObjects\TestBase.java` : With base class we can avoid code duplication and can reuse the code as much we want. Here all the common methods are written which are been called in the StepDefinitions class file like Clicking on button, Enter the text in textbox etc. I have extended this class in the StepDefinitions class to call the custom methods directly as needed. It also helps in inplementation of Lazy evaluation
   - `\Runners\MainRunner.java` :  Test runner class is used here to run Cucumber feature file either through TestNG or Junit. In addition to running a cucumber feature file, it acts as an interlink between feature files and step definition classes.
   - `\stepDefinitions\searchrest.java` : StepDefinition (searchrest) class maps the Scenario Steps of the feature files(written in the format of Given/When/Then) with the code. This executes the steps of the scenarios provided in the Gherkin file and checks the outcomes against expected results.

2. Resources structure: All the resources used in the project are present in `src\test\resources` folder including Gheking feature file
   - `\executables` : This folder is used to store all the drivers which can be used in the project. I have used `chromedriver.exe` for the execution of the project. In case you need to execute the script in IE driver then the .exe file for the same should be present in this folder and the IE driver should be initiated instead of Chrome driver in `searchrest.java` file
   - `\features` : This folder consists of all the feature files with the extension `.feature`. Currently it consist of \searchrest.feature which defines the scenario mentioned in `Introduction`
   - `\properties` : This folder consist of the property files with extension as `.properties`. Here I have mentioned all the locators which are used in the project, the browser which I used, the website URL and the implicit wait. It is the central repository so if we have to change the details we can change it from here directly without going inside each java files.
  
3. Maven POM file:
   - `\pom.xml` : This XML file contains the project configuration details used by Maven. It provides all the configuration required for a project like cucumber jar, testng jar etc
   
4. Test output: The result of the test are present in the `\test-output` folder. It consist of 2 html files (`emailable-report.html` and `index.html` which we can use to see the test result by opening it in browser.

### Setup
Test
