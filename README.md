# SauceDemo UI Automation Framework

This project is a UI test automation framework for [SauceDemo](https://www.saucedemo.com/), built using **Java**, **Selenium**, **Cucumber**, and **TestNG**. It demonstrates the use of Page Object Model (POM), multi-browser support, parallel execution, and data-driven testing.

---

## 🔧 Technologies Used

- Java
- Maven
- Selenium WebDriver
- Cucumber (Gherkin)
- TestNG
- WebDriverManager
- Git

---

## 📁 Project Structure
saucedemo-ui-tests/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/
│   │           └── ConfigReader.java
│   │           └── DriverFactory.java
│   ├── test/
│   │   ├── java/
│   │   │   └── runners/
│   │   │   └── stepdefinitions/
│   │   │   └── pages/
│   │   └── resources/
│   │       └── features/
│   │       └── testdata/
│   │       │   └── loginData.csv
│   └── testng.xml
├── config.properties
├── pom.xml
├── README.md



🚀 How to Run Tests
1. Clone the Repo
2. Install Dependencies
3. Run Tests (Default: Chrome)
4. Run Tests in Parallel
   Edit testng.xml to run tests across multiple browsers simultaneously.

🧪 Test Scenarios Covered
✅ Scenario 1: Invalid Login (Data-driven with 4 datasets)
1.     Open SauceDemo site
2.     Try logging in with different invalid credentials
3.     Verify error messages for each

✅ Scenario 2: Valid Login + Full Purchase Flow
1.     Login with valid credentials
2.     Add the 2 most expensive products to the cart
3.     Verify cart contents
4.     Complete checkout 
5.     Verify totals and thank-you message

📂 Test Data:

    Test data is stored in src/test/resources/testdata/loginData.csv.

✅ Features Implemented
*     Page Object Model 
*     Cucumber + Gherkin Scenarios
*     Multi-browser support (Chrome, Firefox)
*     Parallel execution using TestNG
*     Configurable properties
*     Data-driven testing
*     Git integrated

📌 Author
Sondos Alsokary
Lead Automation Test Engineer
