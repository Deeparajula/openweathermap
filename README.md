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



Test Case Writing Task
1.       Define Company Codes and file versions which were loaded on the previous or previous of
the previous month end and should be rolled further to the daily processing:
1.1.    Previous Month end identifiers:
        - Reporting Date is equal to the Reporting Date of the previous month end;
        - Frequency of the load MONTH;
        - It’s latest file loaded for the entity (Latest Flag ‘Y’);
        - Region Code = ASIA;.


Solution :
1.1.1 Verify company codes and file version, when the Reporting date is equal to the Reporting date of the previous month end
1.1.2 Verify company codes and file version, when the Reporting date is not equal to the Reporting date of the previous month end
1.1.3 Verify company codes and file version, when the Reporting date and Frequency of the load MONTH matches with the previous month end reporting date and Frequency of the load MONTH
1.1.4 Verify company codes and file version, when the Reporting date and Frequency of the load MONTH doesn’t match with the previous month end reporting date and Frequency of the load MONTH
1.1.5 Verify company codes and file version, with reporting date is equal to the reporting date of the previous month end and file loaded with Flag Y
1.1.6 Verify company codes and file version, with reporting date is equal to the reporting date of the previous month end and file loaded with Flag other than Y
1.1.7 Verify company codes and file version, with reporting date is equal to the reporting date of the previous month end and file loaded with Flag Y and frequency of the load MONTH
1.1.8 Verify company code and file version, with region code ASIA and reporting date is same as previous month end
1.1.9 Verify company code and file version, with region code other than ASIA and reporting date is same as previous month end 
1.1.10 Verify company code and file version, with all the combinations of identifiers of previous month end



2. Define companies which were loaded for the current reporting date:
        - Reporting Date is equal to the today date;
        - Frequency of the load DAILY
        - It's latest file loaded for the entity (Latest Flag ‘Y’);
        - Region Code = ‘ASIA’.

Solution :
2.1 Verify companies with the reporting date is equal to the today date
2.2 Verify companies with the reporting date not equal to the today date
2.3 Verify companies with the reporting date is in future dates
2.4 Verify companies with the Frequency of the load is Daily
2.5 Verify companies with the latest file loaded for the entity with Flag Y
2.6 Verify companies with the latest file loaded for the entity with Flag not equal to Y
2.7 Verify companies with the Region code as ASIA
2.8 Verify companies with the region code as ASIA and reporting date is equal to the today date
2.9 Verify companies with the region code as ASIA, reporting date is equal to the today date and Frequency of the load is DAILY
2.10 Verify companies, with all the right combinations.



3. Construct the list of companies and file versions which should be processed:
  - Create a distinct list of Companies which are assigned to the region ‘ASIA’ (use
reference data table COMPANY);
  - Exclude all companies defined on the #2 because they were explicitly loaded by users
for the current reporting date.

Solution : 
3.1 SELECT DISTINCT Companies FROM COMPANY WHERE Region="ASIA";
3.2 SELECT * FROM COMPANY
WHERE NOT Rank = 2
Note: I have considered Rank as a column in COMPANY table.


I wasn't clear with the requirement of writing test cases task, so I have compeleted as per my understanding.
Please let me know I am missing anything.


