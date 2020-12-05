Feature: Contact Via The Form

  Background:
    Given The user on contact page

  Scenario: The user sends the contact form
    When The user completes the contact form
    Then The user sees a message that the message has been successfully sent

  Scenario: The user sends the contact form without message content
    When The user completes the contact form without message content
    Then The user sees the message that the message was not sent

  Scenario: The user sends the contact form without email
    When The user completes the contact form without email address
    Then The user sees the alert message that the message was not sent

  Scenario: The user sends the contact form without subject heading
    When The user completes the contact form without subject heading
    Then The user sees the alert message that subject of the report isn't selected

