package Pages;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//FINAL POM FOR ADD REPORT

public class AddReport extends HeaderPage {

    WebDriver wb;
    public AddReport(WebDriver wb) {
        this.wb = wb;
        PageFactory.initElements(wb, this);
    }
    //Header in Field Interview Page
    @FindBy(xpath = "//h3[text()='Field Interview Card']")
    WebElement fieldInterviewText;

    @FindBy(xpath = "//h4/div[@title='Entity']")
    WebElement entityIcon;

    @FindBy(xpath = "//h4/div[@title='Subject Information']")
    WebElement subInfoIcon;

    @FindBy(xpath = "//h4/div[@title='Identifiers']")
    WebElement idenfIcon;

    @FindBy(xpath = "//h4/div[@title='Id Information']")
    WebElement idInfoIcon;

    @FindBy(xpath = "//h4/div[@title='Gang Membership']")
    WebElement gangMemIcon;

    @FindBy(xpath = "//h4/div[@title='Vehicle']")
    WebElement vehicleIcon;

    @FindBy(xpath = "//h4/div[@title='Add Photos']")
    WebElement addPhotoIcon;

    @FindBy(xpath = "//h4/div[@title='Preview']")
    WebElement previewIcon;

    //Radio button for selecting Entity or Department
    @FindBy(xpath = "//label[text()='dps1']/span")
    WebElement dps1radioButton;
    public void addReportEntity() {
        dps1radioButton.click();
    }
    @FindBy(xpath = "//label[text()='dps123']/span")
    WebElement dps123radioButton;
    @FindBy(xpath = "//label[text()='EC']/span")
    WebElement ecRadioButton; //EC radio button
    public void addReportDept() {
        ecRadioButton.click();
    }
    @FindBy(xpath = "//label[text()='SUB-6']/span")
    WebElement SUB6radioButton;
    @FindBy(xpath = "//label[text()='SUB-16']/span")
    WebElement SUB16radioButton;
    @FindBy(xpath = "//div[@ng-show='wizard.active(1)']/ul/li/a")
    WebElement nextButton;
    public void addReportEntityNext(){
        Capabilities cp = ((RemoteWebDriver) wb).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                ((JavascriptExecutor) wb).executeScript("arguments[0].scrollIntoView(true);", nextButton);
            } catch (Exception e) {

            }
        }
        nextButton.click();
    }

    //Subject information
    @FindBy(xpath = "//input[@name='caseNumber']")
    WebElement caseIDTextBox;
    public void typeCaseId(String caseId) {
        caseIDTextBox.sendKeys(caseId);
    }

    public WebElement validation() {
        return caseIDTextBox;
    }

    @FindBy(xpath = "//select[@ng-model='wizard.report.suspectType']")
    WebElement selSuspect;
    public void suspect(String selectSuspectType) throws InterruptedException{
        Select susType = new Select(selSuspect);
        susType.selectByVisibleText(selectSuspectType);
    }
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameTextBox;
    public void typeLastName(String enterLastName){
        lastNameTextBox.sendKeys(enterLastName);
    }
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameTextBox;
    public void typeFirstName(String enterFirstName){
        firstNameTextBox.sendKeys(enterFirstName);
    }
    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleNameTextBox;
    public void typeMiddleName(String enterMiddleName){
        middleNameTextBox.sendKeys(enterMiddleName);
    }
    @FindBy(xpath = "//input[@name='Nickname']")
    WebElement nickNameTextBox;
    public void typeNickName(String enterNickName){
        nickNameTextBox.sendKeys(enterNickName);
    }
    @FindBy(xpath = "//input[@uib-datepicker-popup='MM/dd/yyyy']")
    WebElement dobTextBox;
    @FindBy(xpath = "//input[@name = 'Age']")
    WebElement ageTextBox;
    @FindBy(xpath = "//select[@ng-model='wizard.report.sex']")
    WebElement sex;
    @FindBy(xpath = "//select[@ng-model='wizard.report.race']")
    WebElement race;
    @FindBy(xpath = "//input[@name='Height']")
    WebElement height;
    @FindBy(xpath = "//input[@name='Weight']")
    WebElement weight;
    @FindBy(xpath = "//select[@ng-model='wizard.report.build']")
    WebElement build;
    @FindBy(xpath = "//select[@ng-model='wizard.report.hairColor']")
    WebElement hairColor;
    @FindBy(xpath = "//select[@ng-model='wizard.report.hairLength']")
    WebElement hairLength;
    @FindBy(xpath = "//select[@ng-model='wizard.report.hairStyle']")
    WebElement hairStyle;
    @FindBy(xpath = "//select[@ng-model='wizard.report.eyeColor']")
    WebElement eyeColor;
    @FindBy(xpath = "//select[@ng-model='wizard.report.complexion']")
    WebElement complexion;
    @FindBy(xpath = "//select[@ng-model='wizard.report.teeth']")
    WebElement teeth;
    @FindBy(xpath = "//select[@ng-model='wizard.report.handPreference']")
    WebElement handPreference;
    @FindBy(xpath = "//input[@name='primary-language']")
    WebElement primLang;
    @FindBy(xpath = "//input[@name='street-address']")
    WebElement streetAddress;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityTextBox;
    @FindBy(xpath = "//input[@name='state']")
    WebElement stateTextBox;
    @FindBy(xpath = "//input[@name='zip']")
    WebElement zipTextBox;
    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneTextBox;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTextBox;
    @FindBy(xpath = "//input[@value='driver']")
    WebElement drivRad; //driver radio button
    @FindBy(xpath = "//input[@value='passenger']")
    WebElement passengerRad; //passenger radio button
    @FindBy(xpath = "//input[@value='pedestrian']")
    WebElement pedestrianRad; //pedestrian radio button
    @FindBy(xpath = "//div[@ng-show='wizard.active(2)']/ul/li[2]/a")
    WebElement nextSubjInfo; // Next Button in Subject Information Page
    public void subInfoNext(){
        Capabilities cp = ((RemoteWebDriver) wb).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                ((JavascriptExecutor) wb).executeScript("arguments[0].scrollIntoView(true);", nextSubjInfo);
            } catch (Exception e) {

            }
        }
        nextSubjInfo.click();
    }
/*
    //Xpaths for Identifiers
    @FindBy(xpath = "//div[label/text()='Tattoos']/div/span/label/span")
    WebElement tattoos; //tattoos checkbox
    @FindBy(xpath = "//input[@name='Tattoos']")
    WebElement tattoosTextBox; //tattoos textbox
    @FindBy(xpath = "//div[label/text()='Scars']/div/span/label/span")
    WebElement scars; //scars checkbox
    @FindBy(xpath = "//input[@name='Scars']")
    WebElement scarsTextBox; //scars textbox
    @FindBy(xpath = "//div[label/text()='NeedleMarks']/div/span/label/span")
    WebElement needleMarks; //NeedleMarks checkbox
    @FindBy(xpath = "//input[@name='Tattoos']")
    WebElement tattoosTextBox; //tattoos textbox
    @FindBy(xpath = "//div[label/text()='Scars']/div/span/label/span")
    WebElement scars; //scars checkbox
    @FindBy(xpath = "//input[@name='Scars']")
    WebElement scarsTextBox; //scars textbox
    @FindBy(xpath = "//div[label/text()='Tattoos']/div/span/label/span")
    WebElement tattoos; //tattoos checkbox
    @FindBy(xpath = "//input[@name='Tattoos']")
    WebElement tattoosTextBox; //tattoos textbox
    @FindBy(xpath = "//div[label/text()='Scars']/div/span/label/span")
    WebElement scars; //scars checkbox
    @FindBy(xpath = "//input[@name='Scars']")
    WebElement scarsTextBox; //scars textbox

*/



    public void addReportSubjInfo() {   //h4/div[@title='Subject Information']"
        System.out.println("Add Report - Subject information");
    }
    public void addReportIdentifiers() {    //h4/div[@title='Identifiers']
        System.out.println("Add Report - Identifiers");
    }
    public void addReportIdInformation() {  //h4/div[@title='Id Information']
        System.out.println("Add Report - Id information");
    }
    public void addReportGangMembership() { //h4/div[@title='Gang Membership']
        System.out.println("Add Report - Gang Membership");
    }
    public void addReportVehicle() { //h4/div[@title='Vehicle']
        System.out.println("Add Report - vehicle");
    }
    public void addReportPhotos() {
        System.out.println("Add Report - photos");
    }
    public void addReportPreview() {
        System.out.println("Add Report - preview");
    }
}