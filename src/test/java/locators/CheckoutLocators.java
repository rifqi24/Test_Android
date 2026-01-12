package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutLocators {

    // PRODUCT
    public static final By PRODUCT_TSHIRT =
            AppiumBy.accessibilityId("Sauce Lab Bolt T-Shirt");

    public static final By INCREASE_QTY =
            AppiumBy.accessibilityId("Increase item quantity");

    public static final By ADD_TO_CART =
            AppiumBy.accessibilityId("Tap to add product to cart");

    public static final By CART_ICON =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");

    public static final By PRICE =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV");

    public static final By TOTAL_PRICE =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/totalPriceTV");

    public static final By QTY =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/noTV");

    public static final By CHECKOUT_CONFIRM =
            AppiumBy.accessibilityId("Confirms products for checkout");

    // LOGIN
    public static final By USERNAME =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/username1TV");

    public static final By LOGIN_BTN =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn");

    // SHIPPING
    public static final By FULLNAME =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/fullNameET");
    public static final By ADDRESS1 =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/address1ET");
    public static final By ADDRESS2 =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/address2ET");
    public static final By CITY =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/cityET");
    public static final By STATE =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/stateET");
    public static final By ZIP =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/zipET");
    public static final By COUNTRY =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/countryET");

    // PAYMENT
    public static final By PAYMENT_BTN =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
    public static final By CARD_NAME =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    public static final By CARD_NUMBER =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
    public static final By EXP_DATE =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
    public static final By CVV =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/securityCodeET");

    // COMPLETE
    public static final By COMPLETE_TEXT =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/completeTV");

    public static final By CONTINUE_SHOPPING =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/shoopingBt");
}
