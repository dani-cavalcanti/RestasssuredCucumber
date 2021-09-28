Feature: Test consult the via CEP API


  @viaCep
  Scenario: Test Add Place
    Given User calls "viaCEP" with "GET" http request
    Then Status code is 200
    And Validate the schema