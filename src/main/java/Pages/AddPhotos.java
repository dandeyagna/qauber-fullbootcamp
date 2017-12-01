package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPhotos {
    WebDriver driver;
    public AddPhotos(WebDriver driver){
        this.driver=driver;

    }
    public void clickNextButton(){
        WebElement nextButton = driver.findElement(By.xpath("//div[@ng-show='wizard.active(7)']/ul/li[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();
    }
}
