package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Photos {
    WebDriver dr;
    public Photos(WebDriver driver){
        this.dr = driver;
    }

    public void gotoPhotos(){
        WebElement element =dr.findElement(By.xpath("html/body/div[2]/aside[1]/div/nav/ul/li[5]/a/span"));
    }
}
