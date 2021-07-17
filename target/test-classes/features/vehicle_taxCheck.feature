Feature: Compare vehicles from car tax check

  Scenario: Comparisons of Vehicle type
    Given I retrieve vehicle registration numbers from "car_input.txt"
    And I retrieve vehicle identity from output file "car_output.txt"
    When I search for vehicle registration number and extract "Vehicle Identity" information
    Then I compare data with outputFile
