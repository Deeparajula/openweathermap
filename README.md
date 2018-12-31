# openweathermap
AutomationAssignment

Automation Task : 

Tool - Eclipse Oxygen
Automation Framework - Selenium WebDriver with TestNG and Java
Browser - Chrome
Website - https://openweathermap.org/

Test cases covered :

Verifies that all important information is present.
Verifies that website suggests city is “Not found”.
Verifies that website successfully returns weather details for the city.
Verify user sign up(additional test).

Prerequisites to run above tests :

Java and Eclipse 
Chrome browser
Selenium dependency files
ChromeDriver jar file

How to run above tests :

Open Eclipse, create Java project and add all external jar files and TestNG library file while creating the project.
Create TestNG class.

I have used BeforeMethod and AfterMethod annotations of TestNG framework to execute end to end test in single class.

We could also create separate TestNG classes for each test case.

If you had more time what you would do differently or additionally

If I had more time, I would have covered positive and negative cases and I would have used data driven framework.
