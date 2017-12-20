package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ".//*[@id='exampleInputEmail1']")
    WebElement emailId;
    @FindBy(xpath = ".//*[@id='exampleInputPassword1']")
    WebElement passWord;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    //*[@id='exampleInputEmail1']
    public void userEmailId(String enterEmailId){
        emailId.sendKeys(enterEmailId);
    }

    public void userPassword(String enterPassword){
        passWord.sendKeys(enterPassword);
    }
    public void loginButton(){
        submitButton.click();
    }
    //For Cucumber test
    public WebElement cucumberEmailId(){
        return emailId;
    }
    public WebElement cucumberPassword(){
        return passWord;
    }
}
