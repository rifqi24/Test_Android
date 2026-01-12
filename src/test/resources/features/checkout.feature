
Feature: Checkout End To End

  @Qcheckout @checkout_success
  Scenario: User berhasil checkout
    Given user sudah login
    When user melakukan checkout end to end
    Then checkout berhasil

  @Qcheckout @verifyAmount
  Scenario: Verify total harga product
    Given user sudah login
    When user melakukan checkout product
    Then checkout product berhasil

  @Qcheckout @checkout_fail
  Scenario: User gagal Checkout Products
    Given user sudah login
    When user melakukan checkout
    And user tidak mengisi form alamat
    Then Proses checkout Gagal

