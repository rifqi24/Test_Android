package stepdefinitions;

import hooks.Hooks;
import pages.CheckoutPage;
import io.cucumber.java.en.*;
import static org.testng.Assert.assertTrue;

public class CheckoutSteps {

    CheckoutPage checkoutPage;

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
//        assertTrue(
//                checkoutPage.isTotalPriceCorrect(),
//                "Total price tidak sesuai dengan price x quantity"
//        );
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
        assertTrue(checkoutPage.verifyPaymentaddress());
    }
}
