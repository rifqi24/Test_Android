package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.TimeoutException;
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

    public void fillPaymentAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                CheckoutLocators.CARD_NAME)).sendKeys("QA Tester");
        driver.findElement(CheckoutLocators.CARD_NUMBER).sendKeys("4111111111111111");
        driver.findElement(CheckoutLocators.EXP_DATE).sendKeys("1225");
        driver.findElement(CheckoutLocators.CVV).sendKeys("123");
        driver.findElement(CheckoutLocators.PAYMENT_BTN).click();

//        wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.PAYMENT_BTN)).click();
    }

    public void clickPayment() {

        wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.PAYMENT_BTN)).click();

    }
    public boolean validationPaymentaddress() {

        try {
            // Tunggu sampai error muncul
            return wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.VALIDATION_ADDRESS))
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
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

    private void scrollToText(String text) {
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"
                )
        );
    }

    private double parseDollar(String priceText) {
        return Double.parseDouble(
                priceText.replace("$", "").trim()
        );
    }

    public boolean isTotalPriceCorrect() {
        try {
            // Ambil harga dan qty (biasanya selalu visible)
            String priceText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.PRICE)
            ).getText();

            String qtyText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.QTY)
            ).getText();


            scrollToText("DHL Standard Delivery");

            String shippingText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.SHIPPING_PRICE)
            ).getText();

            String totalText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.TOTAL_PRICE)
            ).getText();

            // Parse text menjadi angka
            double price = parseDollar(priceText);
            int qty = Integer.parseInt(qtyText.replaceAll("\\D+", ""));
            double shipping = parseDollar(shippingText);
            double totalUI = parseDollar(totalText);

            double expectedTotal = (price * qty) + shipping;


            boolean isTotalCorrect = Math.abs(expectedTotal - totalUI) < 0.01;

            // 🔍 DEBUG LOG
            System.out.println("PRICE     : " + price);
            System.out.println("QTY       : " + qty);
            System.out.println("SHIPPING  : " + shipping);
            System.out.println("EXPECTED  : " + expectedTotal);
            System.out.println("UI TOTAL  : " + totalUI);


            if (isTotalCorrect) {
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                CheckoutLocators.PAYMENT_BTN
                        )
                ).click();
            }
            boolean continueVisible = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            CheckoutLocators.CONTINUE_SHOPPING
                    )
            ).isDisplayed();

            if (continueVisible) {
                driver.findElement(CheckoutLocators.CONTINUE_SHOPPING).click();
            }
            return isTotalCorrect;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
