package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    public LogOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class='mr-sm ng-binding']")
    WebElement userName;
    @FindBy(xpath = "//button[@class='btn btn-labeled btn-primary btn-sm']")
    WebElement logOutButton;
    public void clickOnLogOut(){
        logOutButton.click();
    }

    public void clickOnUserName() {
        userName.click();
    }

}
