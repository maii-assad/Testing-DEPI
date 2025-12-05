# AutomationExercise Selenium Test Project

This is a ready-to-open Maven + Selenium + TestNG project that automates Login & Signup test cases for:
**https://www.automationexercise.com/login**

Files created:
- `pom.xml` - Maven configuration
- `testng.xml` - TestNG suite configuration
- `src/test/java/base/BaseTest.java` - WebDriver setup & teardown (uses WebDriverManager)
- `src/test/java/pages/LoginPage.java` - Page Object for login & initial signup actions
- `src/test/java/pages/SignupPage.java` - Page Object for the account information (signup) page
- `src/test/java/tests/LoginTests.java` - Login test cases (4 tests)
- `src/test/java/tests/SignupTests.java` - Signup & account-creation test cases (10 tests as provided)
- `testng.xml` - Suite runner

## How to open and run in IntelliJ
1. Unzip `automationexercise_project.zip` and open the folder as a Maven project in IntelliJ.
2. Let Maven download dependencies (Selenium, TestNG, WebDriverManager).
3. Run the tests via:
   - Right click `testng.xml` -> Run, OR
   - `mvn test` in the project directory.

## Notes & tips
- ChromeDriver is managed automatically with WebDriverManager (no need to download driver manually). If you prefer a manual driver, download the driver and set system property `webdriver.chrome.driver`.
- Java 17+ is configured in `pom.xml`. Make sure your IntelliJ project SDK is set to Java 17 (or change pom properties to match your JDK).
- The project runs tests against `https://www.automationexercise.com/login`.

## Uploaded image (reference)
The testcases were provided as an image by the user. It's included here as reference path:
`/mnt/data/1a697b3e-79c4-4819-8e92-dfac6bfc67e9.png`

## What I implemented
- All test cases from your provided list were implemented as TestNG tests.
- Page Object pattern for maintainability.
- Tests make assertions where possible; some checks (UI validations) may require manual verification or more specific locators depending on site behavior.

If you want:
- I can add Maven profiles for headless runs.
- Add ExtentReports or Allure reporting.
- Convert to JUnit or Python (pytest + Selenium / Playwright).

Enjoy — download the project and open it in IntelliJ.

