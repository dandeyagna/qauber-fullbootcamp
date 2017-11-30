package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddingEntity {
    WebDriver driver;
    public AddingEntity(WebDriver driver){
        this.driver=driver;
    }
    public void creatingEntity(){
        driver.findElement(By.xpath("//span[text()='Entities']"));
        driver.findElement(By.xpath("//button[text()='Add Entity']"));
    }
    public WebElement selectingEntity() {

        return driver.findElement(By.xpath("//label[text()='cubo@nada.ltd']/span"));
    }
    public void clickNextButton(){
        WebElement nextButton = driver.findElement(By.xpath("//div[@ng-show='wizard.active(1)']/ul/li/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();
    }
}
