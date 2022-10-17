# QATestAutomation

# Title of the Project: QA Automation Test-Amazon

# Description:
Taken Amazon.com to Automate few TC1, TC2, TC3 stated below. I have used Selenium Webdriver with java to automate the test cases.
I have used TestNG to run the tests.

# Testcases:
## Test case 1:
1. Go to the Home Page
2. Select category is Electronics on Search field (Required: if the category isn’t found, please
select the random category)
3. Search item iPhone 14
4. Select Featured Brands is Belkin
5. Input Price min is 100$, max is 2000$
6. Validate all items have 100$ <= price <= 2000$ on the result.
## Test case 2:
1. Go to the Home Page
2. Select category is Electronics on Search field
3. Search item IPhone 14
4. Select price $100 to $200
5. Select Sort: Price High to Low
6. Validate the items on all pages were sorted by price from High to Low
## Test case 3:
1. Go to the Home Page
2. Select category is Electronics on Search field
3. Search item IPhone 14
4. Select price $100 to $200
5. Select random item on the screen
6. On item detail, click on Add to Cart button
7. Click on the Go to Cart button
8. Click on the Proceed to checkout button
9. Validate the Sign In screen is displayed

# Project Information:
I have wrote standalone code for all the above Testcases in class files TestCase1, TestCase2, TestCase3 under QAExams package in src/test/java respectively.

I have refactored the code by using page Objects model, Abstraction and Inheritance by creating class files under src/main/java respectively.

Refactored testcases are in TC1, TC2, TC3 Class files under QAExams package in src/test/java respectively.

BaseTest.java is the file having all before and other methods and driver initializations. It is under QAExams.testComponents under src/test/java. 
GlobalData properties are wrote inGlobalData.properties file under QAExams.resources package.
Each class file TC1, TC2, TC3 extends BaseTest.java file.

Tests.java class file has all the three test cases and it is under QAExams package in src/test/java respectively.

## Tools used:
Selenium Webdriver
Eclipse IDE
TestNG

## Languages used:
Java

## What to run to see the Output:
 
 Run testng.xml file
 
 



