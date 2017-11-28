package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/a/img")
    private WebElement logo;
    @FindBy(xpath = "//input[@name='account_email']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='account_password']")
    private WebElement password;
    @FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/div[2]/header/nav/div[2]/ul[2]/li/a/span")
    private WebElement userProfileLink;
    @FindBy(xpath = "//p[contains(.,'SIGN IN TO CONTINUE.')]")
    private WebElement signToContinue;

    public WebElement getLogo() {
        return wait.until(ExpectedConditions.visibilityOf(logo));
    }
    public void setUsername(String strUsername){
        username.clear();
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(strUsername);
    }
    public void setPassword(String strPassword){
        password.clear();
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(strPassword);
    }
    public void clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        executor.executeScript("arguments[0].click();",loginBtn);
    }
    public void getUsername(){
        username.getAttribute("value");
    }
    public WebElement getUserProfileLink(){
        return wait.until(ExpectedConditions.visibilityOf(userProfileLink));
    }
    public WebElement getSignInToContinue(){
        return wait.until(ExpectedConditions.visibilityOf(signToContinue));
    }


}
