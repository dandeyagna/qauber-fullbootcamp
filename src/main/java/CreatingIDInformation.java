package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatingIDInformation {
    WebDriver dr;
    public CreatingIDInformation(WebDriver dr){
        this.dr=dr;
    }
    public void clickNextButton() throws InterruptedException {
        Thread.sleep(1000);
        WebElement nextButton = dr.findElement(By.xpath("//div[@ng-show='wizard.active(4)']/ul/li[2]/a"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();
    }
}
