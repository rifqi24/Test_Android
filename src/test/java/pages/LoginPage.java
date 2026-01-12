package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // locator
    private WebElement menu() {
        return driver.findElement(
                AppiumBy.accessibilityId("View menu")
        );
    }

    private WebElement backtoCatalog() {
        menu().click();
        return driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"Catalog\")"
                )
        );
    }

    private WebElement loginMenu() {
        return driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"Log In\")"
                )
        );
    }

    private WebElement username() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("com.saucelabs.mydemoapp.android:id/username1TV")
                )
        );
    }

    public boolean isUserLockedOut() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV")
                    )
            ).isDisplayed();
        } catch (Exception e) {
            return false; // element error tidak muncul
        }
    }


    private WebElement loginButton() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn")
                )
        );
    }


    public boolean isUserLoggedIn() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("View menu")
                )
        ).isDisplayed();
    }

    public WebElement lockedOutError() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("com.saucelabs.mydemoapp.android:id/username2TV")
                )
        );
    }

    // actions
    public void openLoginPage() {
        menu().click();
        loginMenu().click();

        // pastikan login screen sudah kebuka
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("com.saucelabs.mydemoapp.android:id/username1TV")
                )
        );
    }

    public void login() {
        username().click();
        loginButton().click();
    }
    public void userlockedOut() {
        lockedOutError().click();
        loginButton().click();

    }
    public void backtocatalog() {
        backtoCatalog().click();

    }
}
