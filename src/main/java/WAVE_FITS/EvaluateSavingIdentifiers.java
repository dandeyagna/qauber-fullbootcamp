package WAVE_FITS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EvaluateSavingIdentifiers {
    WebDriver driver;
    Helper helper;

    @BeforeTest
    public void openApplication() throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/Users/bindhu/Desktop/Geckodriver/chromedriver");
        driver = new ChromeDriver();
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "iPhone 7 Plus");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "10.0");

        driver = new RemoteWebDriver(new URL(URL), caps);*/
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

    }
    @Test(priority = 0)
    public void loginToApplication() throws InterruptedException {
        helper =new Helper(driver);
        helper.login();
    }
    @Test(dependsOnMethods = {"loginToApplication"})
    public void EvaluationPage() {
        WebElement reportsPage = driver.findElement(By.xpath("//span[text()='Reports']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reportsPage);
        reportsPage.click();
        int entity = 218;
        int count = 1;
        WebElement moveNextButton = driver.findElement(By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']"));
        while (moveNextButton.getText()) {

            boolean exist = false;

            List<WebElement> allElement = driver.findElements(By.xpath("//em[@title='Case ID']/../span"));
            for (WebElement e : allElement) {

                if (e.getText().equals(entity)) {
                    exist = true;
                    System.out.println(entity + " Email id is present in user list");
                    System.out.println(e.getText());

                }

                //Assert.assertEquals(exist, true, "Expected email id is not present");
            }
            if (exist == true) {
                break;

            }
            count++;
            WebElement page = driver.findElement(By.xpath("//a[text()='"+count+"']"));
            page.click();
        }
    }
}
