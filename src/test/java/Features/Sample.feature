Feature: Facebook Login
#  Background: Logo present on Facebook login page
#    Given I open Facebook login page
#    When I enter '<userid>'  in  UserID and '<pwd>' in Password
#    | userid  | pwd |
#    | viewer  | abcd  |
#    Then It should redirect to home page

#  Scenario: Login with invalid credential
#    Given I open Facebook login page
#    When I enter email as 'xyz123@gmail.com'
#    And I click on login button
#    Then It should redirect to login page with error message
  Scenario: Ebay Search by Category
    Given I am on Ebay Home
    When I search for 'Soap' in 'Baby' Category
    Then It should display all items in that Category

    Scenario: Logo present on Google page
      Given I open Google home page
      When I verify that the logo is present on Google page

    Scenario: Login with invalid credential
      Given I open Facebook login page
      When I enter email as 'xyz123@gmail.com'
      And I click on login button
      Then It should redirect to login page with error
      | message |
      | Not Found |
#  Scenario: Login with valid credential
#    Given I open Facebook login page
#    When I enter email as '<userid>' and '<password>'
#    And I click on login button
#    Then It should redirect to login page with error
#      | message |
#      | Not Found |