@checkout
Feature: Checkout End To End
  Scenario: User berhasil checkout
    Given user sudah login
    When user melakukan checkout end to end
    Then checkout berhasil