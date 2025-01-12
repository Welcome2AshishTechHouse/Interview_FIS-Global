@AllTestCases
Feature: Verify CoinDesk API functionalities

  @api_CoinDesk_APITest
  Scenario: Verify BPIs in CoinDesk API response
    Given API endpoint is "coinDesk.endpoint"
    When Sent GET request to the endpoint
    Then Response status code equal to 200
    And Response should contain 3 BPIs:
      | BPIs |
      | USD  |
      | GBP  |
      | EUR  |
    And Validate "GBP" description should equal "British Pound Sterling"




