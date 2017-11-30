package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VehicalDetails {
    WebDriver dr;
    public VehicalDetails(WebDriver dr){

        this.dr=dr;
    }
    public void clickNextButton(){
        WebElement nextButton = dr.findElement(By.xpath("//div[@ng-show='wizard.active(6)']/ul/li[2]/a"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();
    }
}
