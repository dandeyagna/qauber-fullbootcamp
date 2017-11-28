package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EntitiesPage extends BasePage {
    public EntitiesPage(WebDriver driver){super(driver);}


    @FindBy(xpath = "//button[contains(.,'Add Entity')]")
    private WebElement addEntityBtn;
    @FindBy(name = "name")
    private WebElement name;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(xpath = "//select[@name='country']")
    private WebElement country;
    @FindBy(name = "address1")
    private WebElement address1;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(xpath = "//select[@name='state']")
    private WebElement state;
    @FindBy(name = "zip")
    private WebElement zip;
    @FindBy(xpath = "//span[text()='Next step']")
    private WebElement nextStepBtn;
    @FindBy(xpath = "//span[text()='Finish']")
    private WebElement finishBtn;

    //next page ,add emails for subscription
    @FindBy(xpath = "//div[@class='bootstrap-tagsinput']/input[@type='text']")
    private WebElement addEmailFieldRU;
    @FindBy(xpath = "(//div[@class='bootstrap-tagsinput']/input[@type='text'])[2]")
    private WebElement addEmailFieldAU;

    //switch to dialog window
    @FindBy(xpath = "//div[@class='text-right']")
    private WebElement dialogBox;


    public void clickAddEntityBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addEntityBtn)).click();
    }
    public void setCompanyName(String strName) {
        name.clear();
        name.sendKeys(strName);
    }
    public void setAddress1(String strAddress1) {
        address1.clear();
        address1.sendKeys(strAddress1);
    }
    public void setCity(String strCity) {
        city.clear();
        city.sendKeys(strCity);
    }

    public void setZip(String intZip) {
        zip.clear();
        zip.sendKeys(intZip);
    }

    public void setPhone(String intPhone) {
        phone.clear();
        phone.sendKeys(intPhone);
    }

    public void setEmail(String strEmail) {
        email.clear();
        email.sendKeys(strEmail);
    }
    public void clickNextStepBtn() {
        Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                executor.executeScript(
                        "arguments[0].scrollIntoView(true);", nextStepBtn);
            } catch (Exception e) {

            }
        }
        executor.executeScript("arguments[0].click();",nextStepBtn);
    }

    public void clickFinishBtn() {
        Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                executor.executeScript(
                        "arguments[0].scrollIntoView(true);", finishBtn);
            } catch (Exception e) {

            }
        }
        executor.executeScript("arguments[0].click();",finishBtn);
    }

    public void setCountry(String strCountry) {
        Select countryDropdown = new Select(country);
        countryDropdown.selectByVisibleText(strCountry);
    }

    public void setState(String strState) {
        Select stateDropdown = new Select(state);
        stateDropdown.selectByVisibleText(strState);
    }

    public void setAddEmailRU(String strEmails) {
        //addEmailFieldRU.clear();
        wait.until(ExpectedConditions.visibilityOf(addEmailFieldRU)).sendKeys(strEmails);
//        executor.executeScript("arguments[0].sendKeys(strEmails)", addEmailFieldRU);
    }

    public void setAddEmailFieldAU(String strAddEmailAU) {
        wait.until(ExpectedConditions.visibilityOf(addEmailFieldAU)).sendKeys(strAddEmailAU);
    }
}
