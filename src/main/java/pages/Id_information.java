package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Id_information {
    WebDriver dr;
    public Id_information(WebDriver driver){
        this.dr = driver;
    }

    public void gotodistributionpage(){
        WebElement element = dr.findElement(By.xpath("//h3/div[@title='Gang Membership']"));
        element.click();


    }
    public void nextButton(){
       WebElement ele= dr.findElement(By.xpath("//a[text()='Next']"));
       ele.click();
    }
    public void ScrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("window.scrollBy(0,450)", "");
    }

    public void gotoVehicle_page(){
        WebElement element = dr.findElement(By.xpath("html/body/div[2]/aside[1]/div/nav/ul/li[5]/a/span]"));
        element.click();
    }

    public void ScrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("window.scrollBy(0,-450)", "");
    }
}
