# JustEat
Just Eat is an online food order and delivery service which acts as an intermediary between independent take-out food outlets and customers. JUST EAT website can be used to find open takeaway restaurants by using postcode area
JUST EAT has a website available at http://www.just-eat.co.uk/

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Setup](#setup)
 
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
To automate the project, I have used Selenium WebDriver with Cucumber framework as I have already got the scenario for Ghekin file.
Based on the Ghekin file scenario I have generated the StepDefinition file where I have used Java Language to automate the Just Eat Site for each steps of the Scenario. Below is the structure of the automation project:

1. **Code Structure**: All the java files are available in `src\test\java` folder
   - `\PageObjects\TestBase.java` : With base class we can avoid code duplication and can reuse the code as much we want. Here all the common methods are written which are been called in the StepDefinitions class file like Clicking on button, Enter the text in textbox etc. I have extended this class in the StepDefinitions class to call the custom methods directly as needed. It also helps in inplementation of Lazy evaluation
   - `\Runners\MainRunner.java` :  Test runner class is used here to run Cucumber feature file either through TestNG or Junit. In addition to running a cucumber feature file, it acts as an interlink between feature files and step definition classes.
   - `\stepDefinitions\searchrest.java` : StepDefinition (searchrest) class maps the Scenario Steps of the feature files(written in the format of Given/When/Then) with the code. This executes the steps of the scenarios provided in the Gherkin file and checks the outcomes against expected results.

2. **Resources structure**: All the resources used in the project are present in `src\test\resources` folder including Gheking feature file
   - `\executables` : This folder is used to store all the drivers which can be used in the project. I have used `chromedriver.exe` for the execution of the project. In case you need to execute the script in IE driver then the .exe file for the same should be present in this folder and the IE driver should be initiated instead of Chrome driver in `searchrest.java` file
   - `\features` : This folder consists of all the feature files with the extension `.feature`. Currently it consist of \searchrest.feature which defines the scenario mentioned in `Introduction`
   - `\properties` : This folder consist of the property files with extension as `.properties`. Here I have mentioned all the locators which are used in the project, the browser which I used, the website URL and the implicit wait. It is the central repository so if we have to change the details we can change it from here directly without going inside each java files.
  
3. **Maven POM file**:
   - `\pom.xml` : This XML file contains the project configuration details used by Maven. It provides all the configuration required for a project like cucumber jar, testng jar etc
   
4. **Test output**: The result of the test are present in the `\test-output` folder. It consist of 2 html files (`emailable-report.html` and `index.html`) which we can use to see the test result report by opening it in browser.

### Setup
1. **Install Java on your computer**
Download and install the Java Software Development Kit (JDK) [here](http://www.oracle.com/technetwork/java/javase/downloads/index.html). Please note you have downloaded the version based on your OS type. For example download Windows x64	JDK file if you are using 64-bit version of Windows.

2. **Install Eclipse IDE**
Download latest version of "Eclipse IDE for Java Developers" [here](http://www.eclipse.org/downloads/). Be sure to choose correctly between Windows 32 Bit and 64 Bit versions.
Double-click on "eclipse-inst-win64" exe downloaded file to Install the Eclipse. A new window will open. Click Eclipse IDE for Java Developers. Then select the path where you want to install and install. After successful completion of the installation procedure, click on Launch to open the Eclipse IDE. Select your workspace where you want to store the code before launching the Eclipse IDE

3. **Import Github project**
Click on File>Import. Select Git> Projects from Git. Then click on Next. Click on Clone URI and Next. Enter the URI as SSH link provided. Click on Next. Select `master` and click on Next. Select the directory where you want to store the code file, click on Clone submodules and Click on Next. Select Import existing eclipse project, select the working tree and click on Next. Click on Finish.

4. **Executing**
Open the folder `\JustEat\src\test\java\Runners\MainRunner.java`. Right click on `MainRunner.java` file.  Select Run As> TestNG Test. Wait for the execution to complete.
Once you get the Passed status in Eclipse IDE cosole, open the `\JustEat\test-output` folder. Copy the location of 2 html files (`emailable-report.html` and `index.html`) by right click on the file and click on properties. 
Open the copied location path in the browser. You will view the result report.


