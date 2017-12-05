package WAVE_FITS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestingLogin {
    public static final String USERNAME = "bindhu8";
    public static final String AUTOMATE_KEY = "WjM2kovJwTyFxYGwsiMC";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    WebDriver driver;
    Helper helper =new Helper(driver);

    @Test
    public void openApplication() throws InterruptedException, MalformedURLException {
      /* System.setProperty("webdriver.chrome.driver", "/Users/bindhu/Desktop/Geckodriver/chromedriver");
        driver = new ChromeDriver();*/
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "10.1");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Sierra");
        caps.setCapability("resolution", "1024x768");

        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.get("http://fits.qauber.com/#/page/login");
       // driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        helper.pageResources.getLoginpage().userNamefield().sendKeys("cubo@nada.ltd");
        helper.pageResources.getLoginpage().userPassword().sendKeys("abcdefgh");
        Thread.sleep(1000);
        helper.pageResources.getLoginpage().loginButton();

    }
}
