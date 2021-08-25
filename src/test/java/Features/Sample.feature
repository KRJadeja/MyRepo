Feature: Facebook Login
  @H1
  Scenario: Logo present on Facebook login page
    Given I open Facebook login page
    When I verify that the logo is present on page

  Scenario: Login with invalid credential
    Given I open Facebook login page
    When I enter email as 'xyz123@gmail.com'
    And I click on login button
    Then It should redirect to login page with error message

  Scenario: Ebay Search by Category
    Given I am on Ebay Home
    When I search for 'Soap' in 'Baby' Category
    Then It should display all items in that Category