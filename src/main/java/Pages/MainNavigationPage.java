package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainNavigationPage extends BasePage{
    public MainNavigationPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//span[@class='ng-binding' and text()='Entities']")//("//span[@class='ng-binding'])[1]", "//span[contains(.,'Entities')]"
    private WebElement entitiesLink;
    @FindBy(xpath = "//span[@class='ng-binding' and text()='Users']")//"(//span[@class='ng-binding'])[2]"
    private WebElement usersLink;
    @FindBy(xpath = "//span[@class='ng-binding' and text()='Add Report']")//"(//span[@class='ng-binding'])[3]"
    private WebElement addReportLink;
    @FindBy(xpath = "//span[@class='ng-binding' and text()='Reports']")//"(//span[@class='ng-binding'])[4]"
    private WebElement reportsLink;

    public void clickEntitiesLink(){
        wait.until(ExpectedConditions.visibilityOf(entitiesLink)).click();
    }
    public void clickUsersLink(){
        wait.until(ExpectedConditions.visibilityOf(usersLink)).click();
    }
    public void clickAddReportLink(){
        wait.until(ExpectedConditions.visibilityOf(addReportLink)).click();
    }
    public void clickReportsLink(){
        wait.until(ExpectedConditions.visibilityOf(reportsLink)).click();
    }
    public WebElement getEntitiesLink() {
        return entitiesLink;
    }
    public WebElement getUsersLink() {
        return usersLink;
    }
    public WebElement getAddReportLink() {
        return addReportLink;
    }
    public WebElement getReportsLink() {
        return reportsLink;
    }

}
