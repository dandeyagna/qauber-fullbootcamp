package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubjectInformation {
    WebDriver dr;
    public SubjectInformation(WebDriver driver){

        this.dr = driver;
    }

    public WebElement getLastName(){
        return dr.findElement(By.xpath("//input[@name ='lastName']"));


    }

    public WebElement getFirstName(){
        return dr.findElement(By.xpath("//input[@name ='firstName']"));
    }

    public void gotoidentifiers_information(){
        WebElement element = dr.findElement(By.xpath("//li[@class='col-md-1 ph0' ][2]"));
        element.click();


    }
}
