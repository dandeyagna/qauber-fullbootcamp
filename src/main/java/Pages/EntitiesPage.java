package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EntitiesPage extends BasePage {
    public EntitiesPage(WebDriver driver) {
        super(driver);
    }


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
    @FindBy(xpath = "/html/body/div[2]/section/div/div/div[1]/div[2]/form/div/div/input")
//"//div[@class='bootstrap-tagsinput']/input[@type='text']"
    private WebElement addEmailFieldRU;
    @FindBy(xpath = "/html/body/div[2]/section/div/div/div[1]/div[3]/form/div/div/input")
//"(//div[@class='bootstrap-tagsinput']/input[@type='text'])[2]"
    private WebElement addEmailFieldAU;

    //switch to dialog window
    @FindBy(xpath = "//div[@class='text-right']")
    private WebElement dialogBox;


    public void clickAddEntityBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addEntityBtn)).click();
    }

    public void setCompanyName(String strName) {
        //executor.executeScript("arguments[0].scrollIntoView(true);",name);
        name.clear();
        name.sendKeys(strName);
    }

    public void setAddress1(String strAddress1) {
        //executor.executeScript("arguments[0].scrollIntoView(true);",address1);
        address1.clear();
        address1.sendKeys(strAddress1);
    }

    public void setCity(String strCity) {
        //executor.executeScript("arguments[0].scrollIntoView(true);",city);
        city.clear();
        city.sendKeys(strCity);
    }

    public void setZip(String intZip) {
        executor.executeScript("arguments[0].scrollIntoView(true);", zip);
        zip.clear();
        zip.sendKeys(intZip);
    }

    public void setPhone(String intPhone) {
        executor.executeScript("arguments[0].scrollIntoView(true);", phone);
        phone.clear();
        phone.sendKeys(intPhone);
    }

    public void setEmail(String strEmail) {
        executor.executeScript("arguments[0].scrollIntoView(true);", email);
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
        executor.executeScript("arguments[0].scrollIntoView(true);", nextStepBtn);
        executor.executeScript("arguments[0].click();", nextStepBtn);
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
        executor.executeScript("arguments[0].scrollIntoView(true);", finishBtn);
        executor.executeScript("arguments[0].click();", finishBtn);
    }

    public void setCountry(String strCountry) {
        executor.executeScript("arguments[0].scrollIntoView(true);", country);
        Select countryDropdown = new Select(country);
        countryDropdown.selectByValue(strCountry);
    }

    public void setState(String strState) {
        executor.executeScript("arguments[0].scrollIntoView(true);", state);
        Select stateDropdown = new Select(state);
        stateDropdown.selectByValue(strState);
    }

    public void setAddEmailRU(String strEmails) {
        //addEmailFieldRU.clear();
        wait.until(ExpectedConditions.visibilityOf(addEmailFieldRU)).sendKeys(strEmails);
//        executor.executeScript("arguments[0].sendKeys(strEmails)", addEmailFieldRU);
    }

    public void setAddEmailFieldAU(String strAddEmailAU) {
        //executor.executeScript("arguments[0].scrollIntoView(true);",addEmailFieldAU);
        wait.until(ExpectedConditions.visibilityOf(addEmailFieldAU)).sendKeys(strAddEmailAU);
    }
}
