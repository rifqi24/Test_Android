package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setPlatformName("Android")
                        .setDeviceName("emulator-5554")
                        .setApp("C:/Users/HP/Downloads/mda-1.0.13-15.apk")
                        .setAutomationName("UiAutomator2");

                driver = new AndroidDriver(
                        new URL("http://127.0.0.1:4723"),
                        options
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
