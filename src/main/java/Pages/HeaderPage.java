package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {
    public HeaderPage(WebDriver driver){ super(driver);}
    @FindBy(xpath = "//img[@src='app/img/logo.png']")
    private WebElement appLogo;
    @FindBy(xpath = "/html/body/div[2]/header/nav/div[2]/ul[1]/li/a[1]")
    private WebElement hamburgerMenu;
    @FindBy(xpath = "//span[@class='mr-sm ng-binding']")
    private WebElement userLink;

    public void clickLogo(){
        wait.until(ExpectedConditions.visibilityOf(appLogo)).click();
    }
    public void clickHamburgerIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
    }
    public void clickUserLink(){
        wait.until(ExpectedConditions.elementToBeClickable(userLink)).click();
    }

    public WebElement getAppLogo() {
        return wait.until(ExpectedConditions.visibilityOf(appLogo));
    }
}
