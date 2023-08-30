<!DOCTYPE html>
<html>
<head>
    
</head>
<body>

<h1>Orange HRM Automation Testing Project</h1>

<img src="https://opensource-demo.orangehrmlive.com/web/images/ohrm_branding.png?v=1689053487449">

<p>This repository contains an automation testing project for the <strong>Orange HRM</strong> website using <a href="https://www.selenium.dev/">Selenium</a> and <a href="https://testng.org/doc/">TestNG</a>. The project aims to automate the testing of various functionalities of the Orange HRM web application to ensure its quality and functionality across different scenarios.</p>

<h2>Table of Contents</h2>
<ul>
    <li><a href="#introduction">Introduction</a></li>
    <li><a href="#setup">Setup</a></li>
    <li><a href="#features">Features</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#extent-report">Extent Report</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
</ul>

<h2 id="introduction">Introduction</h2>

<p>Orange HRM is a widely used Human Resource Management (HRM) system that helps organizations manage their workforce efficiently. This automation testing project focuses on ensuring the correct behavior of the Orange HRM website by automating the testing of its features. The project utilizes Selenium for interacting with the web pages and TestNG for structuring and managing test cases.</p>

<h2 id="setup">Setup</h2>

<p>To set up the project locally, follow these steps:</p>

<ol>
    <li>Clone the repository: <code>git clone https://github.com/Arif-Uz-Zaman/Orange-HRM-Automation.git</code></li>
    <li>Install the necessary dependencies, including Selenium and TestNG.</li>
    <li>Download the appropriate WebDriver (e.g., ChromeDriver) and make sure it's accessible from your system's PATH.</li>
    <li>Update the configuration file with your test environment details, such as URLs and credentials.</li>
</ol>

<h2 id="features">Features</h2>

<p>The project currently includes automated tests for the <strong>Login Page</strong> and <strong>Home/Dashboard Page</strong> of the Orange HRM website.For Login page it covers scenarios like:</p>

<ul>
    <li><strong>Verify log in with valid username and valid password:</strong> This test ensures that a user can successfully log in using a valid username and password combination.</li>
    <li><strong>Verify login with invalid username and valid password:</strong> This test checks if the system handles the scenario where an invalid username is provided along with a valid password.</li>
    <li><strong>Verify login with invalid username and Invalid password:</strong> This test examines the system's response when both the username and password provided are invalid.</li>
    <li><strong>Verify login with valid username and Invalid password:</strong> This test validates the behavior of the system when a valid username is entered along with an invalid password.</li>
    <li><strong>Verify Login while leaving the password field empty:</strong> This test ensures that the system handles the case where a user tries to log in without entering a password, and a "Required" text popup is displayed under the password field.</li>
    <li><strong>Verify Login while leaving the Username field empty:</strong> Similar to the previous test, this one ensures the system's response when the username field is left empty, and a "Required" text popup is displayed under the username field.</li>
    <li><strong>Verify Login while leaving Username and password field empty:</strong> This test covers the scenario where both the username and password fields are left empty during a login attempt.</li>
    <li><strong>Verify alert message pop up when using invalid username:</strong> The goal of this test is to verify if the system displays an appropriate alert message when an invalid username is used to log in.</li>
    <li><strong>Verify alert message pop up when using invalid Password:</strong> Similarly, this test checks if the system shows an alert message when an invalid password is used.</li>
    <li><strong>Verify Enter key works as an alternative to the Login button:</strong> This test ensures that pressing the Enter key after entering credentials has the same effect as clicking the Login button.</li>
    <li><strong>Verify Redirect of "Forgot your password?" Link:</strong> This test confirms that clicking on the "Forgot your password?" link redirects the user to the password recovery page.</li>
</ul>

<h3>Next we have Home Page/Dashboard Page.</h3>

<p>The Home Page (also known as the Dashboard Page) tests include:</p>

<ul>
    <li><strong>Verify User's Navigation to Dashboard Page after login:</strong> This test confirms that a user is redirected to the Dashboard Page after a successful login.</li>
    <li><strong>Verify Visibility of Time at Work Board on Dashboard page:</strong> This test checks if the "Time at Work" board is visible on the Dashboard.</li>
    <li><strong>Verify Redirection to Timer Page from Stopwatch Icon in "Time at Work" Board:</strong> This test confirms that clicking on the stopwatch icon in the "Time at Work" board leads to the Timer page.</li>
    <li><strong>Verify Visibility of My Actions Board on Dashboard page:</strong> This test checks if the "My Actions" board is visible on the Dashboard.</li>
    <li><strong>Verify Visibility of Quick Launch Board on Dashboard page:</strong> This test ensures that the Quick Launch board is visible on the Dashboard.</li>
    <li><strong>Verify Visibility of "Assign Leave" Icon inside Quick Launch Board:</strong> This test confirms the presence of the "Assign Leave" icon within the Quick Launch board.</li>
    <li><strong>Verify Functionality of "Assign Leave" Icon inside Quick Launch Board:</strong> This test checks the functionality of the "Assign Leave" icon within the Quick Launch board.</li>
    <li><strong>Verify Visibility of "Leave List" Icon inside Quick Launch Board:</strong> This test confirms the presence of the "Leave List" icon within the Quick Launch board.</li>
    <li><strong>Verify Functionality of "Leave List" icon inside Quick Launch Board:</strong> This test checks the functionality of the "Leave List" icon within the Quick Launch board.</li>
    <li><strong>Verify Visibility of "TimeSheets" Icon inside Quick Launch Board:</strong> This test confirms the presence of the "TimeSheets" icon within the Quick Launch board.</li>
    <li><strong>Verify Functionality of "TimeSheets" icon inside Quick Launch Board:</strong> This test checks the functionality of the "TimeSheets" icon within the Quick Launch board.</li>
    <li><strong>Verify Visibility of "Apply Leave" Icon inside Quick Launch Board:</strong> This test confirms the presence of the "Apply Leave" icon within the Quick Launch board.</li>
    <li><strong>Verify Functionality of "Apply Leave" icon inside Quick Launch Board:</strong> This test checks the functionality of the "Apply Leave" icon within the Quick Launch board.</li>
    <li><strong>Verify Visibility of "My Leave" Icon inside Quick Launch Board:</strong> This test confirms the presence of the "My Leave" icon within the Quick Launch board.</li>
    <li><strong>Verify Functionality of "My Leave" icon inside Quick Launch Board:</strong> This test checks the functionality of the "My Leave" icon within the Quick Launch board.</li>
    <li><strong>Verify Visibility of "My TimeSheet" Icon inside Quick Launch Board:</strong> This test confirms the presence of the "My TimeSheet" icon within the Quick Launch board.</li>
    <li><strong>Verify Functionality of "My TimeSheet" icon inside Quick Launch Board:</strong> This test checks the functionality of the "My TimeSheet" icon within the Quick Launch board.</li>
    <li><strong>Verify Visibility of "Buzz Latest Posts" Board on Dashboard page:</strong> This test checks if the "Buzz Latest Posts" board is visible on the Dashboard.</li>
    <li><strong>Verify Visibility of "Employees on Leave Today" Board on Dashboard page:</strong> This test confirms that the "Employees on Leave Today" board is visible on the Dashboard.</li>
    <li><strong>Verify Visibility of "Employee Distribution by Sub Unit" Board on Dashboard page:</strong> This test checks if the "Employee Distribution by Sub Unit" board is visible on the Dashboard.</li>
    <li><strong>Verify Visibility of Pie Chart within "Employee Distribution by Sub Unit" Board on Dashboard Page:</strong> This test confirms the presence of a pie chart within the "Employee Distribution by Sub Unit" board.</li>
    <li><strong>Verify Visibility of "Employee Distribution by Location" Board on Dashboard page:</strong> This test checks if the "Employee Distribution by Location" board is visible on the Dashboard.</li>
    <li><strong>Verify Visibility of Pie Chart within "Employee Distribution by Location" Board on Dashboard Page:</strong> This test confirms the presence of a pie chart within the "Employee Distribution by Location" board.</li>
    <li><strong>Verify the Functionality of Toggle bar icon:</strong> This test ensures the toggle bar icon functions correctly.</li>
    <li><strong>Verify the functionality of "Search bar" Menu item in Sidepanel:</strong> This test checks the functionality of the "Search bar" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Admin Menu item in Sidepanel:</strong> This test checks the functionality of the "Admin" menu item in the side panel.</li>
    <li><strong>Verify the functionality of PIM Menu item in Sidepanel:</strong> This test checks the functionality of the "PIM" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Leave Menu item in Sidepanel:</strong> This test checks the functionality of the "Leave" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Time Menu item in Sidepanel:</strong> This test checks the functionality of the "Time" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Recruitment Menu item in Sidepanel:</strong> This test checks the functionality of the "Recruitment" menu item in the side panel.</li>
    <li><strong>Verify the functionality of My Info Menu item in Sidepanel:</strong> This test checks the functionality of the "My Info" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Performance Menu item in Sidepanel:</strong> This test checks the functionality of the "Performance" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Directory Menu item in Sidepanel:</strong> This test checks the functionality of the "Directory" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Maintenance Menu item in Sidepanel:</strong> This test checks the functionality of the "Maintenance" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Claim Menu item in Sidepanel:</strong> This test checks the functionality of the "Claim" menu item in the side panel.</li>
    <li><strong>Verify the functionality of Buzz Menu item in Sidepanel:</strong> This test checks the functionality of the "Buzz" menu item in the side panel.</li>
    <li><strong>Verify the functionality of "Search bar" Menu item while Slidepanel is toggled:</strong> This test ensures the "Search bar" menu item works as expected when the Slidepanel is toggled.</li>
    <!-- ... Additional Dashboard-related test cases ... -->
</ul>

<p>Out of the total 48 test cases for the Login Page and Dashboard, 47 tests have passed successfully, demonstrating the robustness of the automated testing suite. However, one test case resulted in a failure, which is being investigated to identify the root cause and address the issue promptly.</p>

<p>In the future, the project can be extended to cover additional functionalities such as:</p>

<ul>
    <li>Employee management tests (add, update, delete employees).</li>
    <li>Leave management tests.</li>
    <li>Timesheet submission tests.</li>
    <li>Reporting module tests.</li>
</ul>

<h2 id="usage">Usage</h2>

<p>To run the tests, use the following steps:</p>

<ol>
    <li>Navigate to the project directory: <code>cd Orange-HRM-Automation</code></li>
    <li>Run the tests using your preferred build tool (e.g., TestNG) .</li>
</ol>

<pre><code># Navigate to the 'Src' folder, and inside the folder, you will find a file called 'testing.xml'. 
 Run it as a TestNG Suite, and you're good to go.
</code></pre>

<p>Make sure to review the test results and logs to identify any failures or issues.</p>
<p>Also, if you want to access the test Scripts</p>
<pre><code># Navigate to the 'Src' folder, and inside the folder, you will find a package called 'com.test'. 
 Inside that package, you will find all the test scripts.
</code></pre>

<h2 id="extent-report">Extent Report</h2>

After running the automated tests, you can view the Extent Report to get detailed insights into the test execution results. To access the Extent Report:

1. Navigate to the root folder of this project.
2. Inside the root folder, locate the `test-output` directory.
3. In the `test-output` directory, you will find a file named `Extent.html`.
4. Simply open the `Extent.html` file in a web browser to view the Extent Report.

The Extent Report provides a comprehensive overview of the test execution, including test pass/fail statuses, test durations, and more.

<p align="center">
    <a href="https://ibb.co/XZF4TS0"><img src="https://i.ibb.co/N6W3zZD/Screenshot-2023-08-24-171958.png" alt="Screenshot-2023-08-24-171958" border="0" /></a>
</p>

Make sure to review the Extent Report after running your tests to quickly assess the test outcomes and identify any issues.

Feel free to reach out if you have any questions about interpreting the Extent Report or the test results.


<h2 id="contributing">Contributing</h2>

<p>Contributions to this automation testing project are welcome! If you find any bugs or want to add new features, feel free to open an issue or submit a pull request. Make sure to follow the project's coding style and guidelines.</p>

<h2 id="license">License</h2>

<p>This project is licensed under the <a href="LICENSE">MIT License</a>.</p>

<hr>

<p>Happy testing!</p>

<p>For questions or support, contact <a href="mailto:shoboh72@gmail.com">shoboh72@gmail.com</a>.</p>

</body>
</html>
