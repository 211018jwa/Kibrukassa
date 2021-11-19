Feature: multiply numbers

Scenario: multiplying numbers successfully (positive test)
	Given I am at the calculator page
	When I type in the number 10.0 into the left multiply input
	When I type in the number 20.0 into the right multiply input
	And I click the multiply button
	Then I should see an multiplication result of 200.0
	
Scenario: Only left input missing (negative test)
	Given I am at the calculator page
	When I type in the number 20.0 into the right multiply input
	And I click the multiply button
	Then I should see an error message in the multiplication output area of "Left input is missing"

Scenario: Only right input missing (negative test)
	Given I am at the calculator page
	When I type in the number 10.0 into the left multiply input
	And I click the multiply button
	Then I should see an error message in the multiplication output area of "Right input is missing"
	
Scenario: Both inputs missing (negative test)
	Given I am at the calculator page
	And I click the add button
	Then I should see an error message in the addition output area of "Both inputs are missing"