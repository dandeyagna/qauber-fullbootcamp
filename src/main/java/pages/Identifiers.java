package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Identifiers {
    WebDriver dr;
    public Identifiers(WebDriver driver){
        this.dr = driver;
    }

    public void gotoid_information(){
        WebElement element = dr.findElement(By.xpath("//li[@class='col-md-1 ph0' ][3]"));
        element.click();


    }
}
