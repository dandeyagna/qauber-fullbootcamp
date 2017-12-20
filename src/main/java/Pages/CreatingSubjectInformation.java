package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingSubjectInformation {
    WebDriver dr;
public CreatingSubjectInformation(WebDriver driver){
    PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//input[@name='caseNumber']")
WebElement caseNumber;
@FindBy(xpath = "//input[@name='lastName']")
WebElement lastName;
@FindBy(xpath = "//input[@name='firstName']")
WebElement firstName;
@FindBy(xpath = "//div[@ng-show='wizard.active(2)']/ul/li[2]/a")
WebElement nextButton;

public void caseID(String caseId){
caseNumber.sendKeys(caseId);
}
public void lastName(String reportLastname){
    lastName.sendKeys(reportLastname);
}
public void FirstName(String reportFisrstName){
    firstName.sendKeys(reportFisrstName);
}
public void clickNextButton(){
        nextButton.click();
}
/*public WebElement radioButton(){
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
    }*/

}

