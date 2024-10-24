Feature: Table Data Validation

	Scenario: Inserting data and verifying their presence in the table
    Given I navigate to the URL
    When I click on the Table Data button
    Then A new input text box is displayed
    When I insert the data into the input text box
    And I click the Refresh Table button
    And the inserted data should match the displayed data in the table