package WAVE_FITS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestingLogin {
    WebDriver driver;
    Helper helper;

    @BeforeTest
    public void openApplication() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/bindhu/Desktop/Geckodriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

    }
    @DataProvider
    public Object[][] giveUserNameAndPasswords() throws Exception{
        Object[][] testObjectArray = {{"yagna.bitspilani","1234"},
                {"yagna@elephant-tamers.com","2345"}
        };
        return testObjectArray;
    }

}
