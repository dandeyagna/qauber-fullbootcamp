package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPhotos {
    public AddPhotos(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@ng-show='wizard.active(7)']/ul/li[2]/a")
    WebElement nextButton;

    public void clickNextButton(){
        nextButton.click();
    }
}
