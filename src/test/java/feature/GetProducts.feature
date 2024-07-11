Feature: Get all the products from the api

  Scenario: Verify the get api for the products
    Given Hit the URL of get products api endpoint
    When Pass the URL of products in the request
    Then Receive the response code as 200

  Scenario Outline: Verify the rate of the first product
    Given Hit the URL of get products api endpoint
    When Pass the URL of products in the request
    Then Verify the rate of the product is "<FirstProductRate>"
    Examples:
      | FirstProductRate |
      | 3.9              |
