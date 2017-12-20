package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingIDInformation {
    public CreatingIDInformation(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@ng-show='wizard.active(4)']/ul/li[2]/a")
    WebElement nextButton;
    public void clickNextButton(){
        nextButton.click();
    }
}
