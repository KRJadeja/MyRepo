Feature: Ebay Home Page Scenarios
#Background: Facebook login page
#  Given I am on Facebook Login page
#  When I enter valid credential in given textbox and click login button
#  Then It should redirect me to page

#    Scenario Outline: Facebook login page
#      Given I am on Facebook Login page
#      When I enter '<Userid>' and '<Pwd>' in given textbox and click login button
#      Then It should redirect me to page
#    Examples:
#      | Userid  | Pwd |
#      | FViewer | P@ssw@rd  |

 # @P1 @P2
 @H1
  Scenario: Advanced Search Link
    Given I am on Eaby Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @smoke
    Scenario: Login with basic auth
      Given I launch herokuapp with basic auth
      Then I navigate to Welcome page

  #@P1 @setCookies @Test

  Scenario: Seach items count
    Given I am on Eaby Home Page
    When I serach for 'iPhone 11'
    Then I validate atleast 10000 search items present

  #@P24 @setCookies

  Scenario: Seach items count2
    Given I am on Eaby Home Page
    When I serach for 'Toy Cars'
    Then I validate atleast 100 search items present

  #@P240 @setCookies

  Scenario: Search an item in category
    Given I am on Eaby Home Page
    When I serach for 'soap' in 'Baby' category
    Then I validate atleast 50 search items present

	#@P500
 # @H1
#  Scenario Outline: Home page links
#    Given I am on Eaby Home Page
#    When I click on '<link>'
#    Then I validate that page navigates to '<url>' and title contains '<title>'
#
#    Examples:
#      | link    | url                                                            | title       |
#      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | eBay Motors: Auto Parts and Vehicles |
#      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856                   | Fashion products for sale |
#      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             | Toys & Hobbies products for sale |


  Scenario Outline: Home page links
    Given I am on Eaby Home Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>'
    Examples:
      | link    | url                                                            |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 |
      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856                   |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             |