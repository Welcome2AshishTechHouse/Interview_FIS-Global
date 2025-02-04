# 🚀 Automation Framework for eBay UI and CoinDesk API Functionalities


## 📋 Introduction
This project encompasses automated testing for both eBay UI functionalities and CoinDesk API functionalities. Utilizing the Maven build tool, the framework incorporates best practices for efficient and reliable test automation. Below is a detailed overview of the project structure, key components, and their respective functionalities.


## 📂 Project Structure

### 1. src/main/java:
#### **commonUtils:**
- **ApiUtils.java:** Contains utility methods for making API requests and processing responses.
- **DriverUtils.java:** Manages WebDriver initialization and teardown processes.
- **ScreenshotUtils.java:** Captures and stores screenshots during test execution, also embeds screenshots in the test report using Base64 encoding.

#### **projectManager:**
- **PropertyManager.java:** Manages loading and retrieval of properties from the configuration file.
- **ScenarioManager.java:** Handles the scenario context during test execution.

#### **webPages:**
- **eBayHomePage.java:** Contains methods to interact with the eBay homepage and perform actions like searching for a book and adding it to the cart.

### 2. src/test/java:
#### **stepDefs:**
- **EBayPageSteps.java:** Step definitions for verifying eBay UI functionalities, including adding a book to the cart.
- **CoinDeskAPIStepDefinitions.java:** Step definitions for verifying CoinDesk API functionalities, including validating BPIs in the response.

#### **runners:**
- **TestRunner.java:** Configures and executes the Cucumber test suite.

### 3. src/test/resources:
#### **features:**
- **eBayAddToCart.feature:** Defines the eBay UI test scenario for adding a book to the cart.
- **CoinDeskAPITest.feature:** Defines the CoinDesk API test scenario for verifying BPIs in the API response.

#### **config:**
- **config.properties:** Contains configuration properties such as URLs and endpoints.
- **extent-config.xml:** Configuration file for the Extent Reports.

## 🌟 Feature Files

### eBayAddToCart.feature
```gherkin


@AllTestCases
Feature: Verify eBay UI functionalities

  @eBay_VerifyAddToCart
  Scenario: Verify add book to the cart on eBay
    Given Open browser navigate to "ebay.url"
    When Search for "book"
    And Select the first book from the search results
    And Add the book to the cart from the item listing page
    Then Validate cart updated with the correct number of items

```

### CoinDeskAPITest.feature
```gherkin
@AllTestCases
Feature: Verify eBay UI functionalities

  @eBay_VerifyAddToCart
  Scenario: Verify add book to the cart on eBay
    Given Open browser navigate to "ebay.url"
    When Search for "book"
    And Select the first book from the search results
    And Add the book to the cart from the item listing page
    Then Validate cart updated with the correct number of items

```

🛠️ Test Execution
To execute the tests, navigate to the project directory and run the following Maven command:
```sh
mvn clean test 
```

## 📊 Test Results
Test results, including detailed logs and embedded screenshots, are generated in the TestAutomationResult folder. The Extent Report provides a comprehensive view of the test execution, including step-by-step details and visual evidence.

## 📚 Conclusion
This automated testing framework ensures reliable and efficient verification of eBay UI functionalities and CoinDesk API functionalities. The modular design and comprehensive logging make it easy to maintain and extend the framework for future testing needs.
