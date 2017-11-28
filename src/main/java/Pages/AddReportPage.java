package Pages;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddReportPage extends BasePage {
    public AddReportPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//h3[contains(.,'Field Interview Card')]")
    private WebElement headerText;

    @FindBy(xpath = "//li[@class='col-md-1 ph0 active' ]/h4/div[@class='fa fa-user size']")
    private  WebElement subjectInformationTitle;
    @FindBy(xpath = "//li[@class='col-md-1 ph0 active' ]/h4/div[@class='fa fa-binoculars size']")
    private WebElement identifiersTitle;
    @FindBy(xpath = "//li[@class='col-md-1 ph0 active' ]/h4/div[@class='fa fa-newspaper-o size']")
    private WebElement idInformationTitle;
    @FindBy(xpath = "//li[@class='col-md-1 ph0 active' ]/h4/div[@class='fa fa-tree size']")
    private WebElement distributionTitle;
    @FindBy(xpath = "//li[@class='col-md-2 ph0 active' ]/h4/div[@class='fa fa-automobile size']")
    private  WebElement vehicleTitle;
    @FindBy(xpath = "//li[@class='col-md-2 ph0 active' ]/h4/div[@class='fa fa-image size']")
    private WebElement photosTitle;
    @FindBy(xpath = "//li[@class='col-md-2 ph0 active' ]/h4/div[@class='fa fa-check-square size']")//get attribute "title"= Preview
    private WebElement reviewInfo;


    @FindBy(xpath = "//label[@class='ng-binding' and text()='dkvazjta']/span")
    private WebElement entityNameRadioBtn;

    @FindBy(xpath = "(//a[text()='Next'])[1]")
    private WebElement nextBtn1;

    @FindBy(xpath = "//input[@name='caseNumber']")
    private WebElement caseId;


    //for assertion the correct pages
    public String getHeaderText() {
        return headerText.getText();
    }
    public String getSubjectInformationTitle() {
        return subjectInformationTitle.getText();
    }
    public String getIdentifiersTitle() {
        return identifiersTitle.getText();
    }
    public String getIdInformationTitle() {
        return idInformationTitle.getText();
    }
    public String getDistributionTitle() {
        return distributionTitle.getText();
    }
    public String getVehicleTitle() {
        return vehicleTitle.getText();
    }
    public String getPhotosTitle() {
        return photosTitle.getText();
    }
    public String getReviewInfo() {
        return reviewInfo.getAttribute("title");
    }


    public void clickEntityNameRBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(entityNameRadioBtn)).click();
    }
    public void clickNextBtn() {
        Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                executor.executeScript(
                        "arguments[0].scrollIntoView(true);", nextBtn1);
            } catch (Exception e) {

            }
        }
        executor.executeScript("arguments[0].click();",nextBtn1);
    }

    public void setCaseId(String intCaseId){
        wait.until(ExpectedConditions.visibilityOf(caseId)).clear();
        caseId.sendKeys(intCaseId);
    }
}
