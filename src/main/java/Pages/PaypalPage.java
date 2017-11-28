package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PaypalPage extends BasePage {
    public PaypalPage(WebDriver driver){super(driver);}
    public void paypalSwitchAndPay(){
        executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@value='Pay with my PayPal account']")));
        //Thread.sleep(10000);
        driver.findElement(By.id("login_email")).sendKeys("nabyqug-buyer@banit.me");
        driver.findElement(By.id("login_password")).sendKeys("kisulea123");
        driver.findElement(By.id("submitLogin")).click();
        //Thread.sleep(10000);
        Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView(true);", driver.findElement(By.id("continue")));
            } catch (Exception e) {

            }
        }
        driver.findElement(By.id("continue")).click();
    }
}
