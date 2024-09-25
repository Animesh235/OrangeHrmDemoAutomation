# OrangeHRM Login Test Automation

This project automates the login functionality of the **OrangeHRM** application using Selenium WebDriver with TestNG. It contains various test cases to verify different login scenarios, such as valid and invalid credentials, login with missing fields, and more.

![Screenshot_20](https://github.com/user-attachments/assets/45c8a07e-3085-48e2-beea-210b94172b27)
![Screenshot_19](https://github.com/user-attachments/assets/7d29bdae-7c10-4663-8168-30adc9bcc678)

## Overview

This project is a test automation suite for verifying the login functionality of the OrangeHRM application. It covers various test cases for login and logout scenarios, including:
- Login with valid credentials
- Login with invalid credentials
- Login with only a username or password
- Verifying UI elements like font size and error messages

## Technologies Used

- **Java**: Programming language used for test scripts
- **Selenium WebDriver**: For browser automation
- **TestNG**: Test framework for running the tests
- **Maven**: Dependency management and build tool
- **ExtentReports**: For generating test reports

## Test Scenarios

The following test cases are included in this project:

| Test Case ID   | Test Case Description                          |
|----------------|------------------------------------------------|
| TC002          | Verify font size of username and password fields |
| TC003          | Verify login and logout functionality           |
| TC005          | Verify login with valid credentials             |
| TC006          | Verify login with invalid credentials           |
| TC010          | Verify login attempt with only username         |
| TC011          | Verify login attempt with only password         |

## Setup Instructions

### Prerequisites

- Java (JDK 8 or higher)
- Maven
- Chrome/Firefox browser
- WebDriver for Chrome/Firefox installed
- An IDE such as IntelliJ IDEA or Eclipse


# OrangeHRM Automation Project

This project automates the login functionality of the **OrangeHRM** application using Selenium WebDriver with TestNG and Page Object Model (POM) design patterns. It also generates reports using ExtentReports.

## Overview

The **OrangeHRM Automation** project automates the testing of the login feature in the OrangeHRM application. It covers various login scenarios including successful login, invalid login attempts, and validation of UI elements like font size.

## Project Structure

The project follows a well-organized structure using the **Page Object Model (POM)** design pattern and is built using **Maven** for dependency management.

```bash
orangehrm-automation/
│
├── src/test/java/
│   ├── testcases/             # Contains the test case classes
│   │   └── TC001_verifyLogin.java
│   │   └── TC002_verifyFontSizeOfElements.java
│   │   └── ...
│   └── pages/                 # Page Object Model (POM) classes for the application pages
│       └── LoginPage.java
│       └── HomePage.java
│   
│
├── src/test/java/
|      └── base/
│           └── Browser.java       # Handles browser setup and teardown
│           └── ExtentReport.java  # Contains ExtentReports setup for reporting
|
├── pom.xml                    # Maven configuration file
├── README.md                  # Project README
└── test-output/               # TestNG test reports (generated after running tests)![Screenshot_20](https://github.com/user-attachments/assets/6b0c5391-d3d7-4cf9-a0b3-1ec9870c1e44)
![Screenshot_19](https://github.com/user-attachments/assets/e57df617-9e83-4fde-97ef-38c8debecf7a)


```
