Feature: Test consult the via CEP API


  @viaCep
  Scenario: Test Get viaCEP
    Given User calls "viaCEP" with "GET" http request
    Then Status code is 200
    And Validate the schema

  @viaCep
  Scenario: Test Get viaCEP 1
    Given User calls "viaCEP1" with "GET" http request
    Then Status code is 200
    And Validate the schema

  @viaCep
  Scenario: Test Get viaCEP 2
    Given User calls "viaCEP2" with "GET" http request
    Then Status code is 200
    And Validate the schema