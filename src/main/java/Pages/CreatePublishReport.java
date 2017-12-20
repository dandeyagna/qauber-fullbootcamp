package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePublishReport {
public CreatePublishReport(WebDriver driver){
    PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//button[@ng-click='wizard.commitReport()']/span")
WebElement nextButton;
public void clickPublishReport(){
    nextButton.click();
}
}
