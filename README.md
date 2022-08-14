About:
------
This project created to automate the API tasks

Designed Automation Framework using Java,RestAssured,TestNG

Project Structure:
------------------
src
  test
     java
       com.task
           config
             ConfigFileReader - To load property files
             ConfigManager    - To make sure have single instance of ConfigFileReader across test
           Reports
             ExtentReport        - To create a Reports
             ExtentReportManger  - To make sure Reports work parallel running
           test
             TaskTests           - Test Methods for given tasks
           RestUtil              - To initialize ConfigFileReader Instance before running each test and having RestAssured HTTP methods
           TestLister            - Contains TestNG methods to mark to given test fail or pass and same will be displayed in report

How Run Tests:
--------------
Clone the project from GitHub
Make sure install maven,And run tests using mvn test -DsuiteXmlFile="src/test/resources/suites/local.xml"
After running tests verify the report generated under target/extent-reports folder
             

