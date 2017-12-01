package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePublishReport {
WebDriver driver;
public CreatePublishReport(WebDriver driver){
    this.driver=driver;
}
public void clickPublishReport(){
    WebElement nextButton = driver.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']/span"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
    nextButton.click();

}
}
