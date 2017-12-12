package browserStack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrowserStackMultiBrowserWindowsTests {
    public static final String USERNAME = "millania1";
    public static final String AUTOMATE_KEY = "drTCQW5wgRWccV9ANzMk";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test(dataProvider = "givePlatformAndBrowsers")
    public static void testSearch(String browser, String version, String platform) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", version);
        caps.setCapability("platform", platform);
        caps.setCapability("browserstack.debug", "true");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();

    }

    @DataProvider
    public Object[][] givePlatformAndBrowsers() throws Exception {
        Object[][] testObjectArray = {{"IE", "7.0", "Windows"},
                {"Firefox", "47.0", "Windows"}
        };
        return testObjectArray;
    }
}