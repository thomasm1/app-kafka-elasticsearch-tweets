Feature: To create job description in the test application <a>

  Background:
    * print "-======================== customJson ======================================="

  Scenario Outline: Print the passed information
    # * def customJson = { "address": "", "email": '#(localContent)'}
    * def customJson = { "address": "", "email": '#(__row)'}

    Examples:
      | read('../data/JsonResponse.json') |
