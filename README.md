API Automation Using RestAssured
Behaviour driven rest assured tests

**Pre Requisites:**
-Maven
-Java

**Dependencies Used:**
Following are the libraries used to write tests, Execute tests and generate reports:
Maven : Used as Build tool
Rest assured : Used to develop the API test cases
Cucumber : To enable write BDD tests in Gherkin language
Serenity : To Run the tests and generate reports of execution

**How to read test scenarios:**
Test scenario files are located in following folder path: src/test/resources/features/DetailsAPI.feature.
This feature file is written in Gherkin format and has 3 test scenarios based on requested acceptance criterias. 
The entire feature file is tagged with name as @DetailsJson and each test case is tagged based on Acceptance criteria like @name and element type like @Boolean.
**Feature**: is the decription of what are the tests involved in the entire feature file
**Background**: These are the common steps which are applicable to all the test scenarios and will be executed before each scenario.
**Scenario outline**: These are the actual tests. These tests are driven by examples below each scenario outline.

**Generic tests**
All the tests could have been written without Scenario outline and Examples but that would have made the tests specific to one acceptance criteria and would have increased coding effort.
Hence to make these tests generic, I have added examples which can be extended to test other elements in the json response with same type(String/Boolean/Int etc) without any extra code to be written.

Example below:All boolean elements can be verified with one single test scenario by just adding in examples and not writing any code.

  @CanRelist @Boolean
  Scenario Outline: Verify CanRelist to be equal to true in Details Service
    And Verify <Element> should be <Expected result>
    Examples:
      | Element             | Expected result |
      | CanRelist           | true            |
      | CanListAuctions     | true            |
      | CanListClassifieds  | true            |
      
**How to execute the tests:**
Using Maven(in terminal/command line):
mvn clean verify "-Dcucumber.options = --tags @DetailsJson"

Using IDE like intellij Idea:
In which you can directly go to runCucumber file, Change the tag that you want to run and click on run button in the file
or
Add run configuration for Maven in intellIj and add command line as clean verify "-Dcucumber.options = --tags @DetailsJson" and click on run
 
Tags behaviour when you run the tests: 
@DetailsJson: This tag will run all the tests in feature file DetailsAPI.feature
@Name: This tag will run only the scenario outline for name
@StringEquals: This tag will run only the scenario outline for name
@CanRelist: This tag will run only the scenario outline for CanRelist
@Boolean: This tag will run only the scenario outline for CanRelist
@Description: This tag will run only the scenario outline for Description
@StringContains: This tag will run only the scenario outline for Description

**How to read reports(When executed with maven command):**
Go to target--> site --> serenity --> index.html(right click and open in browser)

Once opened, this will show you the total test scenarios executed and total test scenarios passed/failed.
Pie chart gives the percentage of pass/fail and table next to it shows the count of Automated tests passed and failed.
If any test in feature file is marked with tag @manual then this will be shown in reports table under manual count(usually helpful for UI automation tests)

Tests can be also browsed based on tags/features (next to pie chart)

Section below pie chart in the generated report shows the actual test execution.
Click on any test listed there  --> It shows the test page with more details about the test
Click on + icon --> this will show the steps executed for that test

If the test is failed then the report will show details logs after clicking on any test.


