
Feature: Login

  @Login @Login_success
  Scenario: Login berhasil
    Given user berada di halaman login
    When user login dengan username standard_user dan password secret_sauce
    Then user berhasil login

  @Login @Login_Gagal
  Scenario: Login locked out
    Given user berada di halaman login
    When user login dengan username locked out dan password secret_sauce
    Then user mendapatkan error locked out



