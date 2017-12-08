package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Vehicle {
    WebDriver dr;
    public Vehicle(WebDriver driver){
        this.dr = driver;
    }
    public void gotoPreviewpage(){
        WebElement element = dr.findElement(By.xpath("//div[@title ='Preview']"));
    }


    }

