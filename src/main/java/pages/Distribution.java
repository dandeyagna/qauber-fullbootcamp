package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Distribution {
    WebDriver dr;

    public Distribution(WebDriver driver) {

        this.dr = driver;
    }


    public WebElement locationofStop() {
        return dr.findElement(By.xpath("//input[@name='locationOfStop']"));
    }

    public void ScrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("window.scrollBy(0,350)", "");
    }

    public void ScrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("window.scrollBy(0,-350)", "");
    }

    public void nextButton(){
        WebElement ele= dr.findElement(By.xpath("//li{@class='next']/a"));
        ele.click();
    }
    public void gotovehicle() {
        dr.findElement(By.xpath("li[@class='col-md-2 ph0']/h3[@class='text-center']/div[@title='Vehicle']"));
    }
}