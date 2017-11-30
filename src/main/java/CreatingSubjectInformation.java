package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatingSubjectInformation {
    WebDriver dr;
public CreatingSubjectInformation(WebDriver dr){
    this.dr=dr;
}
public WebElement caseID(){

    return dr.findElement(By.xpath("//input[@name='caseNumber']"));
}
public WebElement lastName(){

    return dr.findElement(By.xpath("//input[@name='lastName']"));
}
public WebElement FirstName(){

    return dr.findElement(By.xpath("//input[@name='firstName']"));
}
public WebElement radioButton(){
    return dr.findElement(By.xpath("//div[@class='radio c-radio']/label/span"));
}
public WebElement SelectingDriver(){

    return dr.findElement(By.xpath("//label[text()='Driver']/span"));
}
    public WebElement SelectingPassenger(){

    return dr.findElement(By.xpath("//label[text()='Passenger']/span"));
    }
    public WebElement SelectingPedestrian(){

        return dr.findElement(By.xpath("//label[text()='Pedestrian']/span"));
    }
public void clickNextButton(){
    WebElement nextButton = dr.findElement(By.xpath("//div[@ng-show='wizard.active(2)']/ul/li[2]/a"));
    ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", nextButton);
    nextButton.click();
}
}

