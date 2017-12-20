package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingDistribution {
    WebDriver dr;

    public CreatingDistribution(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='locationOfStop']")
    WebElement locationOfStop;
    @FindBy(xpath = "//div[@ng-show='wizard.active(5)']/ul/li[2]/a")
    WebElement nextButton;

    public void locationOfStop(String location){
        locationOfStop.sendKeys(location);
    }
    public void clickNextButton(){
        nextButton.click();
    }

}
