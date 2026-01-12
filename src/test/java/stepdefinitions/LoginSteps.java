package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;


import static org.testng.Assert.assertEquals;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user berada di halaman login")
    public void user_berada_di_halaman_login() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.openLoginPage();
    }
    //Login Berhasil - STANDARD USER
    @When("user login dengan username standard_user dan password secret_sauce")
    public void user_login() {

        loginPage.login();
    }

    @Then("user berhasil login")
    public void user_berhasil_login() {

        assertTrue(loginPage.isUserLoggedIn(), "MY DEMO APP");
    }

    //Login gagal - LOCKED OUT USER
    @When("user login dengan username locked out dan password secret_sauce")
    public void user_login_lockedout() {
        loginPage.userlockedOut();
    }

    @Then("user mendapatkan error locked out")
    public void user_mendapatkan_error_locked_out() {
        assertTrue(loginPage.isUserLockedOut(), "Sorry this user has been locked out.");
        loginPage.backtocatalog();
    }
}
