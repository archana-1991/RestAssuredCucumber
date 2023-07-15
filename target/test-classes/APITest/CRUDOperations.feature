Feature: This feature will be used to test the  operations on employee springbooot application using Rest Assured

  Scenario: This scenario will test the Get operation on Example DB
    Given I have the end point as "http://3.84.15.226:8088/employees"
    When I perform the get operation
    Then I should get the response as 200

  Scenario: This scenario will test the post operation on Example DB
    Given I have the end point as "http://3.84.15.226:8088/employees"
    When I perform the post operation with below data
      | firstName | Tushar      |
      | lastName  | Gupta       |
      | salary    |        3000 |
      | email     | abc@xyz.com |
    Then I should get the response as 201
    And The firstname should be "Tushar" in response
