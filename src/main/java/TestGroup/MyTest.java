package TestGroup;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class MyTest {
        private WebDriver driver;

        @Test
        public void loginBeforeClass() throws InterruptedException {
                System.setProperty("webdriver.chrome.driver", "C:/Users/ravi.eluri/Downloads/chromedriver_win32/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("http://fits.qauber.com/#/page/login");
                Thread.sleep(5000);
                WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
                WebElement passwordTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
                WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
                login.click();
                driver.close();
        }

        @DataProvider
        public Object[][] giveUserNameAndPasswords() throws Exception{
                Object[][] testObjectArray = {{"jyotsnas54a@gmail.com","robsnoop"},
                        {"hudhud@mailinator.com","robsnoop"},{"yarada@mailinator.com","hudhudhudhud"}
                };
                return testObjectArray;

        /*@Test(priority = 1)
        public void testLogin() throws InterruptedException {

                Thread.sleep(5000);
                WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
                emailTextBox.sendKeys("jyotsnas54a@gmail.com");

                WebElement passwordTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
                passwordTextBox.sendKeys("robsnoop");

                Thread.sleep(5000);

                WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
                login.click();

                Thread.sleep(5000);

                WebElement profile = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
                String a = profile.getText();
                Assert.assertEquals(a, "jyo");

        }

        @Test(priority = 2)
        public void testEntity() throws InterruptedException, AWTException {
                WebElement entitiesComp = driver.findElement(By.xpath("//a[@title='Entities']/span"));
                Thread.sleep(5000);
                entitiesComp.click();

                }

        @Test(priority = 3)
        public void addReport() throws InterruptedException, AWTException {

                WebElement addReport = driver.findElement(
                        By.xpath("//a[@title='Add Report']/span"));
                String d = addReport.getText();

                Thread.sleep(5000);

                addReport.click();*/

        }

        }