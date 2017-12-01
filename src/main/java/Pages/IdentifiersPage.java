package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdentifiersPage {
    WebDriver driver;
    public IdentifiersPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickNextButton() throws InterruptedException {
        Thread.sleep(1000);
        WebElement nextButton = driver.findElement(By.xpath("//div[@ng-show='wizard.active(3)']/ul/li[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();
    }
    public WebElement checkBoxTattoos(){
        return driver.findElement(By.xpath("//div[label/text()='Tattoos']/div/span/label/span"));
    }
    public WebElement insertTattoos(){
        return driver.findElement(By.xpath("//div[label/text()='Tattoos']/div/input"));
    }
    public WebElement checkBoxScars(){
        return driver.findElement(By.xpath("//div[label/text()='Scars']/div/span/label/span"));
    }
    public WebElement insertScars(){
        return driver.findElement(By.xpath("//div[label/text()='Scars']/div/input"));
    }
    public WebElement checkNeedleMarks(){
        return driver.findElement(By.xpath("//div[label/text()='Needle Marks']/div/span/label/span"));
    }
    public WebElement insertNeedleMarks(){
        return driver.findElement(By.xpath("//div[label/text()='Needle Marks']/div/input"));
    }
    public WebElement checkTracks(){
        return driver.findElement(By.xpath("//div[label/text()='Tracks']/div/span/label/span"));
    }
    public WebElement insertTracks(){
        return driver.findElement(By.xpath("//div[label/text()='Tracks']/div/input"));
    }
    public WebElement checkGlasses(){
        return driver.findElement(By.xpath("//div[label/text()='Glasses']/div/span/label/span"));
    }
    public WebElement insertGlasses(){
        return driver.findElement(By.xpath("//div[label/text()='Glasses']/div/input"));
    }
    public WebElement checkMustache(){
        return driver.findElement(By.xpath("//div[label/text()='Mustache']/div/span/label/span"));
    }
    public WebElement insertMustache(){
        return driver.findElement(By.xpath("//div[label/text()='Mustache']/div/input"));
    }
    public WebElement checkBeard(){
        return driver.findElement(By.xpath("//div[label/text()='Beard']/div/span/label/span"));
    }
    public WebElement insertBeard(){
        return driver.findElement(By.xpath("//div[label/text()='Beard']/div/input"));
    }

}
