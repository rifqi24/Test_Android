package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import locators.CheckoutLocators;

import java.time.Duration;

public class CheckoutPage  {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginPage = new LoginPage(driver);
    }

    public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(
                CheckoutLocators.PRODUCT_TSHIRT)).click();
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(
                CheckoutLocators.INCREASE_QTY)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                CheckoutLocators.ADD_TO_CART)).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(
                CheckoutLocators.CART_ICON)).click();
    }

    public void proceedCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(
                CheckoutLocators.CHECKOUT_CONFIRM)).click();
    }

    public void loginIfNeeded() {
        loginPage.login();
    }

    public void fillShipping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                CheckoutLocators.FULLNAME)).sendKeys("QA Automation");
        driver.findElement(CheckoutLocators.ADDRESS1).sendKeys("Jl Test");
        driver.findElement(CheckoutLocators.CITY).sendKeys("Jakarta");
        driver.findElement(CheckoutLocators.STATE).sendKeys("DKI");
        driver.findElement(CheckoutLocators.ZIP).sendKeys("12345");
        driver.findElement(CheckoutLocators.COUNTRY).sendKeys("Indonesia");
        driver.findElement(CheckoutLocators.PAYMENT_BTN).click();
    }

    public void fillPayment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                CheckoutLocators.CARD_NAME)).sendKeys("QA Tester");
        driver.findElement(CheckoutLocators.CARD_NUMBER).sendKeys("4111111111111111");
        driver.findElement(CheckoutLocators.EXP_DATE).sendKeys("1225");
        driver.findElement(CheckoutLocators.CVV).sendKeys("123");
        driver.findElement(CheckoutLocators.PAYMENT_BTN).click();

        wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.PAYMENT_BTN)).click();
    }

    public boolean isCheckoutComplete() {

        boolean completeVisible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        CheckoutLocators.COMPLETE_TEXT
                )
        ).isDisplayed();

        boolean continueVisible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        CheckoutLocators.CONTINUE_SHOPPING
                )
        ).isDisplayed();

        driver.findElement(CheckoutLocators.CONTINUE_SHOPPING).click();

        return completeVisible && continueVisible;
    }

    public boolean isTotalPriceCorrect() {

        String priceText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        CheckoutLocators.PRICE
                )
        ).getText();

        String totalText = driver.findElement(
                CheckoutLocators.TOTAL_PRICE
        ).getText();

        String qtyText = driver.findElement(
                CheckoutLocators.QTY
        ).getText();

        // Contoh text:
        // priceText = "$15.99"
        // totalText = "$31.98"
        // qtyText = "2"

        double price = Double.parseDouble(priceText.replace("$", ""));
        double totalPrice = Double.parseDouble(totalText.replace("$", ""));
        int qty = Integer.parseInt(qtyText);

        double expectedTotal = price * qty;

        // rounding biar aman dari decimal issue
        return Math.round(expectedTotal * 100.0) / 100.0 ==
                Math.round(totalPrice * 100.0) / 100.0;
    }

}
