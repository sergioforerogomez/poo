Feature: Request movies
  As a programmer
  I want to request movies in the API and UI
  So that I ensure data consistency

  Scenario Outline: Get page movies
    Given I request movies from page number "<page>"
    When I see the movies from page number "<page>"
    Then the movies "<attribute>" match
    Examples:
      | page | attribute |
      | 1    | title     |