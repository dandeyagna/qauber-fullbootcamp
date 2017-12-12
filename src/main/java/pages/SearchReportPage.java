package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchReportPage extends BasePage {
    public SearchReportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@ng-model='slnSearchKey']")
    private WebElement lnSearchKey;
    @FindBy(xpath = "//input[@ng-model='sfnSearchKey']")
    private WebElement fnSearchKey;
    @FindBy(xpath = "//input[@ng-model='ciSearchKey']")
    private WebElement ciSearchKey;
    @FindBy(xpath = "//select[@ng-model='stSearchKey']")
    private WebElement stSearchKey;
    @FindBy(xpath = "//label[text()='Published On']")
    private WebElement publishedCheckBox;
    @FindBy(xpath = "//input[@is-open='openedSearchFrom']")
    private WebElement openedSearchFrom;
    @FindBy(xpath = "//*[@id='datepicker-679-936-7']/button/span")
    private WebElement clickOnDate;
    @FindBy(xpath = "//input[@ng-model='ctSearchKey']")
    private WebElement ctSearchKey;
    @FindBy(xpath = "//a[@class='btn btn-info btn-sm mt-sm ng-scope' and @title= 'View']")
    private WebElement clickView;
    @FindBy(xpath = ".//*[@id='reportBody']/div[1]/div/div[2]/div[1]/div")
    private WebElement validateLastName;
    @FindBy(xpath = ".//*[@id='reportBody']/div[1]/div/div[1]/div[1]/div")
    private WebElement validateCaseId;
    @FindBy(xpath = ".//*[@id='reportBody']/div[11]/div/div/div")
    private WebElement validateTextContent;

    /*
    @FindBy(xpath = "")
    private WebElement ;
     */

    public String getValidateLastName() {
        return validateLastName.getText();
    }

    public String getValidateCaseId() {
        return validateCaseId.getText();
    }

    public String getValidateTextContent() {
        executor.executeScript("arguments[0].scrollIntoView(true);", validateTextContent);
        return validateTextContent.getText();
    }

    public void setLnSearchKey(String strLnSearchKey) {
        lnSearchKey.sendKeys(strLnSearchKey);
    }

    public void setFnSearchKey(String strFnSearchKey) {
        fnSearchKey.sendKeys(strFnSearchKey);
    }

    public void setCiSearchKey(String strCiSearchKey) {
        ciSearchKey.sendKeys(strCiSearchKey);
    }

    public void setOpenedSearchFrom() {
        openedSearchFrom.click();
        driver.switchTo().activeElement();
        executor.executeScript("arguents[0].click()", clickOnDate);
    }

    public void setCtSearchKey(String strCtSearchKey) {
        ctSearchKey.sendKeys(strCtSearchKey);
    }

    public void clickPublishedCheckBox() {
        publishedCheckBox.click();
    }

    public void setStSearchKey(String status) {
        Select s = new Select(stSearchKey);
        s.selectByValue(status);
    }

    public void clickView() {
        wait.until(ExpectedConditions.visibilityOf(clickView));
        executor.executeScript("arguments[0].scrollIntoView(true);", clickView);
        clickView.click();
    }

}
