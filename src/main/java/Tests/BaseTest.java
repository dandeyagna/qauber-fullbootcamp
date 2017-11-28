package Tests;

import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
@Test(groups = {"base"})
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;

    @Parameters({"browser", "url"})
    @BeforeSuite
    public void baseBeforeClass(String browser,String url) throws MalformedURLException {
        //Run FireFox
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.get(url);
            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        //run Chrome
        else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
//            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
        //Run Appium
        else if (browser.equalsIgnoreCase("appium")) {
            //Create object of DesiredCapabilities class and specify android platform
            DesiredCapabilities capabilities = DesiredCapabilities.android();
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

            capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");

            capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");

            URL urlHub = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver(urlHub, capabilities);

            driver.get(url);

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        else if ((browser.equalsIgnoreCase("saucelab"))) {
            String USERNAME = "mihaela04";
            String ACCESS_KEY = "4263ab2a-bbcb-4348-a149-c95e9ecbcff1";
            String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Linux");
            caps.setCapability("version", "47.0");
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }
//    @AfterMethod
//
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            System.out.println(testResult.getStatus());
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("C:\\Users\\mcovi\\IdeaProjects\\WaveProject\\src\\test\\java\\ScreenShotFiles\\" + testResult.getName() + "-"
//                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
//
//        }
//    }
    @AfterSuite
    public void baseAfterClass(){
        driver.close();
//        driver.quit();
    }
    @Test
    public void assertLogo(){
        loginPage = new LoginPage(driver);
        assertTrue(loginPage.getLogo().isDisplayed());}
}
