package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class EditCompanyPage extends BasePage {
    public EditCompanyPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//input[@ng-model='$ctrl.company.name']")
    private WebElement companyName;
    @FindBy(xpath = "//select[@name='country']")
    private WebElement country;
    @FindBy(xpath = "//input[@ng-model='$ctrl.company.address1']")
    private WebElement address1;
    @FindBy(xpath = "//input[@ng-model='$ctrl.company.address2']")
    private WebElement address2;
    @FindBy(xpath = "//input[@ng-model='$ctrl.company.city']")
    private WebElement city;
    @FindBy(xpath = "//select[@name='state']")
    private WebElement state;
    @FindBy(xpath = "//input[@type ='text' and @name = 'state']")
    private WebElement stateTextField;
    @FindBy(xpath = "//input[contains(@ng-model,'$ctrl.company.zip')]")
    private WebElement zip;
    @FindBy(xpath = "//input[@ng-model='$ctrl.company.phone']")
    private  WebElement phone;
    @FindBy(xpath = "//input[@ng-model='$ctrl.company.email']")
    private WebElement email;
    @FindBy(xpath = "//textarea[@ng-model='$ctrl.company.notes']")
    private WebElement notes;
    @FindBy(xpath = "//button[contains(@ng-click,'$ctrl.submitAction()')]")
    private WebElement update;
    @FindBy(xpath = "//div[@class='uk-notify-message alert-dismissable alert alert-success']")//was update successfully
    private WebElement successUpdateMessage;
    @FindBy(xpath = "//span[@class = 'text-danger' and text()='This field is required']")
    private List<WebElement> requiredFields;

    public List<WebElement> getAllRequiredFields() {
        wait.until(ExpectedConditions.visibilityOfAllElements(requiredFields));
        return requiredFields;
    }
    public int countRequiredFields(){
        Iterator<WebElement> iterator =requiredFields.iterator();
        int counter = 0;
        while (iterator.hasNext()){
            counter= counter+1;
            iterator.next();
        }
        return counter;
    }

    public void setStateTextField(String strStateTextField) {
        stateTextField.clear();
        stateTextField.sendKeys(strStateTextField);
    }
    //methods for update information about company

    public void setCompanyName(String strCompanyName) {
        companyName.clear();
        companyName.sendKeys(strCompanyName);
    }

    public void setAddress1(String strAddress1) {
        address1.clear();
        address1.sendKeys(strAddress1);
    }

    public void setAddress2(String strAddress2) {
        address2.clear();
        address2.sendKeys(strAddress2);
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

    public void setNotes(String strNotes) {
        notes.clear();
        notes.sendKeys(strNotes);
    }

    public void clickUpdateBtn() {
        update.click();
    }

    public void setCountry(String strCountry) {
        Select countryDropdown = new Select(country);
        countryDropdown.selectByVisibleText(strCountry);
    }

    public void setState(String strState) {
        Select stateDropdown = new Select(state);
        stateDropdown.selectByVisibleText(strState);
    }

    public WebElement getSuccessUpdateMessage() {
        return successUpdateMessage;
    }
}
