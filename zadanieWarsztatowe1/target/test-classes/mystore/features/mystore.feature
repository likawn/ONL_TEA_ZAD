Feature: mystore
  Scenario Outline: Login to mystore and adding new address
    Given an open browser on page 'https://mystore-testlab.coderslab.pl/'
    And user logged into account with lidia.testerska@test.test and Aa123456
    When user adds new address: <alias>, <address>, <city>, <zipCode>, <phone>
    Then message about successful adding address is displayed
    And added address <alias>, <address>, <city>, <zipCode>, <phone> is displayed correctly
    And close the browser

    Examples:
      |alias   |address |city  |zipCode |phone     |
      |address1|Test123 |Test  |001122A |123456789|
      |address2|LoremIp |sum   |001122B |234567891|
      |address3|Ex 2a   |London|9955AA2 |345678912|

  Scenario Outline: Adding and deleting address
    Given an open browser on page 'https://mystore-testlab.coderslab.pl/'
    And user logged into account with lidia.testerska@test.test and Aa123456
    When user adds new address: <alias>, <address>, <city>, <zipCode>, <phone>
    And user deletes added address
    Then message about successful deleting address is displayed
    And deleted address with <alias>, <address>, <city>, <zipCode>, <phone> is not displayed
    And close the browser

    Examples:
      | alias | address | city | zipCode | phone |
      |address3|Test124 |Testt |001122C |423456789|
      |address4|LoremI  |psum  |001122D |534567891|
      |address5|Ex 2aa  |Londyn|9955AA3 |645678912|

  Scenario: Deleting address
      Given an open browser on page 'https://mystore-testlab.coderslab.pl/'
      And user logged into account with lidia.testerska@test.test and Aa123456
      And user has added address
      When user deletes added address
      Then message about successful deleting address is displayed
      And close the browser
