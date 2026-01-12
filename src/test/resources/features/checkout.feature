
Feature: Checkout End To End

  @checkout @checkout_success
  Scenario: User berhasil checkout
    Given user sudah login
    When user melakukan checkout end to end
    Then checkout berhasil

  @checkout @checkout_fail
  Scenario: User gagal Checkout Products
    Given user sudah login
    When user melakukan checkout
    And user tidak mengisi form alamat
    Then Proses checkout Gagal