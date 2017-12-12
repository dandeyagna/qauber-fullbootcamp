package testMobileDevices;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestAppium {


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Chrome is not supported any more on Emualated Device or real device
        // https://github.com/appium/appium/issues/1702
        //can be used Browser instead of Chrome

        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "J6686A1R61083456");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("recreateChromeDriverSessions", true);

        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("Testing");
        System.out.println(driver.getTitle());

        driver.quit();

    }

}