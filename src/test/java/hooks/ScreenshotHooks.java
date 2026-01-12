//package hooks;
//
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Scenario;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.OutputType;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import hooks.Hooks;
//
//public class ScreenshotHooks {
//
//    @AfterStep
//    public void takeScreenshotAfterStep(Scenario scenario) {
//        AndroidDriver driver = Hooks.driver; // ambil driver dari Hooks utama
//        byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
//
//        // attach ke report
//        scenario.attach(screenshot, "image/png", "step-screenshot");
//
//        // optional: simpan ke folder
//        try {
//            String folder = "screenshots/" + scenario.getName();
//            new File(folder).mkdirs();
//            File file = new File(folder + "/" + System.currentTimeMillis() + ".png");
//            try (FileOutputStream fos = new FileOutputStream(file)) {
//                fos.write(screenshot);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
