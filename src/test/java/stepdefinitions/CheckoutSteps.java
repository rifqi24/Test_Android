package stepdefinitions;

import hooks.Hooks;
import pages.CheckoutPage;
import io.cucumber.java.en.*;
import static org.testng.Assert.assertTrue;
import pages.LoginPage;

public class CheckoutSteps {

    CheckoutPage checkoutPage;
    LoginPage loginPage ;

//    BERHASIL CHECKOUT

    @Given("user sudah login")
    public void user_sudah_login() {
        checkoutPage = new CheckoutPage(Hooks.driver);

    }

    @When("user melakukan checkout end to end")
    public void user_checkout_e2e() {
        checkoutPage.selectProduct();
        checkoutPage.addProductToCart();
        checkoutPage.openCart();
        checkoutPage.proceedCheckout();
        checkoutPage.loginIfNeeded();
        checkoutPage.fillShipping();
        checkoutPage.fillPayment();
    }

    @When("user melakukan checkout product")
    public void user_checkout_product() {
        checkoutPage.selectProduct();
        checkoutPage.addProductToCart();
        checkoutPage.openCart();
        checkoutPage.proceedCheckout();
        checkoutPage.loginIfNeeded();
        checkoutPage.fillShipping();
        checkoutPage.fillPaymentAmount();
    }

    @Then ("checkout berhasil")
    public void checkout_berhasil() {
        assertTrue(checkoutPage.isCheckoutComplete());
    }

//    GAGAL CHECKOUT

    @When("user melakukan checkout")
    public void user_checkout() {
        checkoutPage.selectProduct();
        checkoutPage.addProductToCart();
        checkoutPage.openCart();
        checkoutPage.proceedCheckout();
        checkoutPage.loginIfNeeded();

    }

    @And ("user tidak mengisi form alamat")
    public void form_tidak_diisi() {
        checkoutPage.clickPayment();
    }

    @Then ("Proses checkout Gagal")
    public void checkout_gagal() {
        assertTrue(checkoutPage.validationPaymentaddress());
//        loginPage.backtocatalog();
    }

    @Then("checkout product berhasil")
    public void checkout_product_berhasil() {
        assertTrue(
                checkoutPage.isTotalPriceCorrect(),
                "Total price tidak sesuai, checkout dibatalkan"
        );

    }
}
