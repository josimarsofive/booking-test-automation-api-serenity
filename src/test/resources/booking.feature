@regresion
Feature: RESTFUL - BOOKER
  RestFul-Booker contains end-points that allow Create, Read, Update and
  Delete reservations. The Web API comes with authentication features and is loaded with a bunch of bugs.
  so you can explore. The API comes preloaded with 10 registers so you can work and reset
  every 10 minutes to that default state.

  @Owner_Joss @Automated
  Scenario: Create Token
    Given Josimar to use restful booker contains end-points
    When he sends the information required for registration
      | username | password    |
      | admin    | password123 |
    And create token booking
    Then response del service to the status code "200"
    Then he must obtain a token in order to authorize the services

  @Owner_Joss @Automated
  Scenario Outline: Create Booking
    Given Josimar to use restful booker contains end-points
    When he sends the information required for create booking
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    And create booking
    Then response del service to the status code "200"
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Josimar   | Leon     | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
      | José      | Cuentas  | 34         | true        | 2022-02-12 | 2022-02-12 | Pencil          |