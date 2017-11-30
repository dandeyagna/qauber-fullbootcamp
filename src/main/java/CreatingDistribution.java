package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatingDistribution {
    WebDriver dr;

    public CreatingDistribution(WebDriver dr){
        this.dr=dr;

    }
    public WebElement locationOfStop(){
        return dr.findElement(By.xpath("//input[@name='locationOfStop']"));
    }
    public void clickNextButton(){
        WebElement nextButton = dr.findElement(By.xpath("//div[@ng-show='wizard.active(5)']/ul/li[2]/a"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();
    }

}
