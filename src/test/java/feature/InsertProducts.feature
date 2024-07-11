Feature: Insert products using POST api

  Scenario Outline: Verify the POST api for the products
    Given Hit the URL of post products api endpoint
    When Pass the request body of product title "<ProductTitle>"
    Then Receive the response code as 200
    Examples:
    | ProductTitle |
    | Shoes        |


  Scenario Outline: Verify the POST api response body for the products
    Given Hit the URL of post products api endpoint
    When Pass the request body of product title "<ProductTitle>"
    Then Receive the response bode with id as "<id>"
    Examples:
      | ProductTitle | id |
      | Shoes        | 21 |
