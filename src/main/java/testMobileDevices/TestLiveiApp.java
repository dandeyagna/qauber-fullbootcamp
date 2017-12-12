package testMobileDevices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestLiveiApp {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "J6686A1R61083456");
        capabilities.setCapability("appPackage", "com.liveimobile.apk");
        capabilities.setCapability("appActivity", "com.liveinews.apk.livevideo.activity.LoginActivity");

        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //email

        //neew to create an account for this application
        driver.findElement(By
                .id("com.liveimobile.apk:id/loginEditText"))
                .sendKeys("miha@yahoo.com");

        // password
        driver.findElement(By
                .id("com.liveimobile.apk:id/passwordEditText"))
                .sendKeys("12345asd");

        // Click login button.
        driver.findElement(By
                .id("com.liveimobile.apk:id/loginButton"))
                .click();

    }
}
