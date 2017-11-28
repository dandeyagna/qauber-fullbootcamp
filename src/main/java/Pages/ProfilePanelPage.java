package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePanelPage extends BasePage {
    public ProfilePanelPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//button[@ng-click='app.logout()']")
    private WebElement signOut;
    @FindBy(xpath = "//em[@class='icon-user fa-lg']")
    private WebElement userIcon;
    @FindBy(xpath = "//em[@class='icon-equalizer fa-lg']")
    private WebElement subscriptionIcon;
    @FindBy(xpath = "//button[contains(.,'Edit Profile')]")
    private WebElement editProfileBtn;
    @FindBy(xpath = "//button[contains(.,'Edit Company')]")
    private WebElement editCompanyBtn;
    @FindBy(xpath = "//nav[@class= 'ng-scope']")
    private WebElement profilePanelDisplayed;


//    For assertion: changing color of profile icon and subscription icon from gay to blue
    @FindBy(xpath = "//li[@class= 'uib-tab nav-item ng-scope ng-isolate-scope active']/a/uib-tab-heading/em[@class='icon-equalizer fa-lg']")
    private WebElement subscriptionIconActive;
    @FindBy(xpath = "//li[@class= 'uib-tab nav-item ng-scope ng-isolate-scope active']/a/uib-tab-heading/em[@class='icon-user fa-lg']")
    private  WebElement profileIconActive;

    public void clickSignOut(){
        wait.until(ExpectedConditions.visibilityOf(signOut)).click();
    }
    public void clickUserIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
    }
    public void clickSubscriptionIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(subscriptionIcon)).click();
    }
    public void clickEditProfileBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(editProfileBtn)).click();
    }
    public void clickEditCompanyBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(editCompanyBtn)).click();
    }
    public WebElement getProfilePanelDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(profilePanelDisplayed));
    }

    public WebElement getSubscriptionIconActive() {
        return wait.until(ExpectedConditions.visibilityOf(subscriptionIconActive));
    }

    public WebElement getProfileIconActive() {
        return wait.until(ExpectedConditions.visibilityOf(profileIconActive));
    }
    public WebElement getEditCompanyBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(editCompanyBtn));
    }
}
