@moemax
Feature: Moemax  Filter marke
  Background:
    Given I am on the Search page

  Scenario Outline: Search Filter
    When I search for the <make>
    And I am checking the <quantity> of goods
    Then I see the filter <make> is applied

    Examples:
      | make  |   quantity   |
      | AEG   |   46 Artikel |
      | Amica |   16 Artikel |


  Scenario: Search Farbe and Marke
    When I apply filters:
      | Marke| Farbe|
      | AEG  | silber |
    Then I see quantity of goods 15
    Then I see the filters are applied:
      | marke  | farbe |
