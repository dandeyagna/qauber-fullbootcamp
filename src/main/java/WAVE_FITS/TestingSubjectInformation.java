package WAVE_FITS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestingSubjectInformation {
    WebDriver driver;
    Helper helper;

    @BeforeTest
    public void openApplication() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/bindhu/Desktop/Geckodriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

    }

    @Test(priority = 0)
    public void loginToApplication() throws InterruptedException {
        helper = new Helper(driver);
      //  helper.login();
    }
 /*   @Test(groups = {"SelectingDriver"})
    public void selectingDriver(){
        helper.selectingDriver();
    }*/
}
