Feature: division numbers

Scenario: divide numbers successfully (positive test)
	Given I am at the calculator page
	When I type in the number 100.0 into the left divide input
	When I type in the number 20.0 into the right divide input
	And I click the divide button
	Then I should see an division result of 5.0
	
Scenario: Only left input missing (negative test)
	Given I am at the calculator page
	When I type in the number 20.3 into the right divide input
	And I click the divide button
	Then I should see an error message in the division output area of "Left input is missing"

Scenario: Only right input missing (negative test)
	Given I am at the calculator page
	When I type in the number 7.5 into the left divide input
	And I click the divide button
	Then I should see an error message in the division output area of "Right input is missing"
	
Scenario: Both inputs missing (negative test)
	Given I am at the calculator page
	And I click the divide button
	Then I should see an error message in the division output area of "Both inputs are missing"