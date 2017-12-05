package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewReports {
    WebDriver driver;
    public ViewReports(WebDriver driver){
        this.driver=driver;
    }
    public WebElement tattoosIsChecked() {

        return driver.findElement(By.xpath("//span[text()='Tattoos']/../span[1]"));
    }
    public WebElement scarsIsChecked() {

        return driver.findElement(By.xpath("//span[text()='Scars']/../span[1]"));
    }
    public WebElement needleMarksIsChecked() {

        return driver.findElement(By.xpath("//span[text()='Needle Marks']/../span[1]"));
    }
    public WebElement tracksIsChecked() {

        return driver.findElement(By.xpath("//span[text()='Tracks']/../span[1]"));
    }
    public WebElement glassesIsChecked() {

        return driver.findElement(By.xpath("//span[text()='Glasses']/../span[1]"));
    }
    public WebElement mustacheIsChecked() {

        return driver.findElement(By.xpath("//span[text()='Mustache']/../span[1]"));
    }
    public WebElement beardIsChecked() {

        return driver.findElement(By.xpath("//span[text()='Beard']/../span[1]"));
    }
    public WebElement tattoosVerified(){
        return driver.findElement(By.xpath("//span[text()='Tattoos']/../div"));
    }
    public WebElement scarsVerified() {

        return driver.findElement(By.xpath("//span[text()='Scars']/../div"));
    }
    public WebElement needleMarksVerified() {

        return driver.findElement(By.xpath("//span[text()='Needle Marks']/../div"));
    }
    public WebElement tracksVerified() {

        return driver.findElement(By.xpath("//span[text()='Tracks']/../div"));
    }
    public WebElement glassesVerified() {

        return driver.findElement(By.xpath("//span[text()='Glasses']/../div"));
    }
    public WebElement mustacheVerified() {

        return driver.findElement(By.xpath("//span[text()='Mustache']/../div"));
    }
    public WebElement beardVerified() {

        return driver.findElement(By.xpath("//span[text()='Beard']/../div"));
    }

}
