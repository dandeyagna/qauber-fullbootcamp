package Pages;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

//import java.time.LocalDate;
//import java.time.Period;
import java.util.Iterator;
import java.util.List;
public class AddReportPage extends BasePage {
    public AddReportPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//h3[contains(.,'Field Interview Card')]")
    private WebElement headerText;
    //Locators for assertion titles of the pages
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

    //select entity radio button locator
    @FindBy(xpath = "//label[@class='ng-binding' and text()='dkvazjta']/span")
    private WebElement entityNameRadioBtn;

    @FindBy(xpath = "(//a[text()='Next'])[1]")
    private WebElement nextBtn1;
    @FindBy(xpath = "(//a[text()='Next'])[2]")
    private WebElement nextBtn2;
    @FindBy(xpath = "(//a[text()='Next'])[3]")
    private WebElement nextBtn3;
    @FindBy(xpath = "(//a[text()='Next'])[4]")
    private WebElement nextBtn4;

    //subject information
    @FindBy(xpath = "//input[@name='caseNumber']")
    private WebElement caseId;
    @FindBy(xpath = "//select[@ng-model='wizard.report.suspectType']")
    private WebElement suspectType;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleName;
    @FindBy(xpath = "//input[@name='Nickname']")
    private WebElement nickname;
    @FindBy(xpath = "//div[2]/div/div/p/input")
    private WebElement dob;
    @FindBy(xpath = "//input[@name='Age']")
    private WebElement age;
    @FindBy(xpath = "//select[@ng-model='wizard.report.sex']")
    private WebElement sex;
    @FindBy(xpath = "//select[@ng-model='wizard.report.race']")
    private WebElement race;
    @FindBy(xpath = "//input[@name='Height']")
    private WebElement height;
    @FindBy(xpath = "//input[@name='Weight']")
    private WebElement weight;
    @FindBy(xpath = "//select[@ng-model='wizard.report.build']")
    private  WebElement build;
    @FindBy(xpath = "//select[@ng-model='wizard.report.hairColor']")
    private WebElement hairColor;
    @FindBy(xpath = "//select[@ng-model='wizard.report.hairLength']")
    private WebElement hairLength;
    @FindBy(xpath = "//select[@ng-model='wizard.report.hairStyle']")
    private WebElement hairStyle;
    @FindBy(xpath = "//select[@ng-model='wizard.report.eyeColor']")
    private WebElement eyeColor;
    @FindBy(xpath = "//select[@ng-model='wizard.report.complexion']")
    private WebElement complexion;
    @FindBy(xpath = "//select[@ng-model='wizard.report.teeth']")
    private WebElement teeth;
    @FindBy(xpath = "//select[@ng-model='wizard.report.handPreference']")
    private WebElement handPreference;
    @FindBy(xpath = "//input[@name='primary-language']")
    private WebElement primaryLanguage;
    @FindBy(xpath = "//input[@name='street-address']")
    private WebElement streetAddress;
    @FindBy(xpath = "//select[@ng-model='wizard.report.country']")
    private WebElement country;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;
    @FindBy(xpath = "//select[@name='state']")
    private WebElement state;
    @FindBy(xpath = "//input[@name='zip']")
    private WebElement zip;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//label[text()= 'Driver']")
    private WebElement driver;//pedestrian or passenger

    @FindBy(xpath = "//span[@class='fa fa-check']")
    private List<WebElement> checkBox;

    //id information page locators
    @FindBy(xpath = "//input[@name='socialSecurity']")
    private WebElement socialSecurity;
    @FindBy(xpath = "//input[@name='driverLicense']")//text
    private WebElement driverLicense;
    @FindBy(xpath = "//select[@ng-model='wizard.report.dlState']")//select
    private WebElement idState;
    @FindBy(xpath = "//input[@name='other-id']")
    private WebElement otherId;//number
    @FindBy(xpath = "//select[@name='otherIdCountry']")
    private WebElement otherIdCountry;
    @FindBy(xpath = "//input[@name='otherIdState']")
    private WebElement otherIdState;
    @FindBy(xpath = "//input[@name='other-id-type']")
    private WebElement otherIdType;

    //School information
    @FindBy(xpath = "//input[@name='school-name']")
    private WebElement schoolName;
    @FindBy(xpath = "//input[@name='school-address']")
    private WebElement schoolAddress;
    @FindBy(xpath = "//input[@name='school-city']")
    private WebElement schoolCity;
    @FindBy(xpath = "//select[@ng-model='wizard.report.schoolState']")
    private WebElement schoolState ;
    @FindBy(xpath = "//input[@name='school-zip']")
    private WebElement schoolZip;
    @FindBy(xpath = "//input[@name='schoolTelephone']")
    private WebElement schoolPhone;

    //Parent information
    @FindBy(xpath = "//input[@name='parent-name']")
    private WebElement parentName;
    @FindBy(xpath = "//input[@name='parent-address']")
    private WebElement parentAddress;
    @FindBy(xpath = "//input[@name='parent-city']")
    private WebElement parentCity;
    @FindBy(xpath = "//select[@ng-model='wizard.report.parentState']")
    private WebElement parentState ;
    @FindBy(xpath = "//input[@name='parentZip']")
    private WebElement parentZip;
    @FindBy(xpath = "//input[@name='parentTelephone']")
    private WebElement parentPhone;

    //employer information
    @FindBy(xpath = "//input[@name='occupation']")
    private WebElement occupation;
    @FindBy(xpath = "//input[@name='employer-name']")
    private WebElement employerName;
    @FindBy(xpath = "//input[@name='employer-address']")
    private WebElement employerAddress;
    @FindBy(xpath = "//input[@name='employer-city']")
    private WebElement employerCity;
    @FindBy(xpath = "//select[@ng-model='wizard.report.employerState']")
    private WebElement employerState;
    @FindBy(xpath = "//input[@name='employer-zip']")
    private WebElement employerZip;
    @FindBy(xpath = "//input[@name='employerTelephone']")
    private WebElement employerPhone;
    /*
    @FindBy(xpath = "")
    private WebElement;
    */





    //for assertion the correct pages
    public String getHeaderText() {
        return headerText.getText();
    }
    public String getSubjectInformationTitle() {
        return subjectInformationTitle.getAttribute("title");
    }
    public String getIdentifiersTitle() {
        return identifiersTitle.getAttribute("title");
    }
    public String getIdInformationTitle() {
        return idInformationTitle.getAttribute("title");
    }
    public String getDistributionTitle() {
        return distributionTitle.getAttribute("title");
    }
    public String getVehicleTitle() {
        return vehicleTitle.getAttribute("title");
    }
    public String getPhotosTitle() {
        return photosTitle.getAttribute("title");
    }
    public String getReviewInfo() {
        return reviewInfo.getAttribute("title");
    }

    //select entity
    public void clickEntityNameRBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(entityNameRadioBtn)).click();
    }

    //move to next page
    public void clickNextBtn() {
//        Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
//        if (cp.getBrowserName().equals("chrome")) {
//            try {
//                executor.executeScript(
//                        "arguments[0].scrollIntoView(true);", nextBtn1);
//            } catch (Exception e) {
//            }
//        }
        executor.executeScript("arguments[0].scrollIntoView(true);",nextBtn1);
        executor.executeScript("arguments[0].click();",nextBtn1);
    }
    public void clickNextBtn2(){
        executor.executeScript("arguments[0].scrollIntoView(true);",nextBtn2);
        executor.executeScript("arguments[0].click();",nextBtn2);
    }
    public void clickNextBtn3(){
        executor.executeScript("arguments[0].scrollIntoView(true);",nextBtn3);
        executor.executeScript("arguments[0].click();",nextBtn3);
    }
    public void clickNextBtn4(){
        executor.executeScript("arguments[0].scrollIntoView(true);",nextBtn4);
        executor.executeScript("arguments[0].click();",nextBtn4);
    }

    //methods for adding information about suspect
    public void setCaseId(String intCaseId){
        wait.until(ExpectedConditions.visibilityOf(caseId)).clear();
        caseId.sendKeys(intCaseId);
    }

    public void setSuspectType(String strSuspectType){
        Select s = new Select(suspectType);
        s.selectByValue(strSuspectType);
    }

    public void setLastName(String strlastName) {
        lastName.sendKeys(strlastName);
    }

    public void setFirstName(String strfirstName) {
        firstName.sendKeys(strfirstName);
    }

    public void setMiddleName(String strmiddleName) {
        middleName.sendKeys(strmiddleName);
    }
    public void setNickName(String strNickName) {
        nickname.sendKeys(strNickName);
    }
    public void setDOB(String intDOB) {
        dob.click();
        dob.sendKeys(intDOB);
    }

//    public static int calculateAge() {
//        LocalDate birthDate = LocalDate.of(1992, 4, 27);
//        LocalDate currentDate = LocalDate.of(2017, 11, 28);
//        if ((birthDate != null) && (currentDate != null)) {
//            return Period.between(birthDate, currentDate).getYears();
//        } else {
//            return 0;
//        }
//    }
    public void setAge(String intAge){
        age.sendKeys(intAge);
    }
    public void setSex(String strSex){
        Select s =new Select(sex);
        s.selectByValue(strSex);
    }
    public void setRace(String strRace){
        Select s =new Select(race);
        s.selectByValue(strRace);
    }
    public void setHeight(String strHeight) {
        height.sendKeys(strHeight);
    }
    public void setWeight(String strWeight) {
        weight.sendKeys(strWeight);
    }
    public void setBuild(){
        Select s =new Select(build);
        s.selectByIndex(2);
    }
    public void setHeirColor(String strHairColor){
        executor.executeScript("arguments[0].scrollIntoView(true);",hairColor);
        Select s =new Select(hairColor);
        s.selectByValue(strHairColor);
    }
    public void setHeirLength(String strHairLength){
        executor.executeScript("arguments[0].scrollIntoView(true);",hairLength);
        Select s =new Select(hairLength);
        s.selectByValue(strHairLength);
    }
    public void setHeirStyle(String strHairStyle){
        executor.executeScript("arguments[0].scrollIntoView(true);",hairStyle);
        Select s =new Select(hairStyle);
        s.selectByValue(strHairStyle);
    }
    public void setEyeColor(String strEyeColor){
        executor.executeScript("arguments[0].scrollIntoView(true);",eyeColor);
        Select s =new Select(eyeColor);
        s.selectByValue(strEyeColor);
    }
    public void setComplexion(String strComplexion){
        executor.executeScript("arguments[0].scrollIntoView(true);",complexion);
        Select s =new Select(complexion);
        s.selectByValue(strComplexion);
    }
    public void setTeeth(String strTeeth){
        executor.executeScript("arguments[0].scrollIntoView(true);",teeth);
        Select s =new Select(teeth);
        s.selectByValue(strTeeth);
    }
    public void setHandPreference(String strHandPreference){
        executor.executeScript("arguments[0].scrollIntoView(true);",handPreference);
        Select s =new Select(handPreference);
        s.selectByValue(strHandPreference);
    }
    public void setPrimaryLanguage(String strPrimaryLanguage){
        wait.until(ExpectedConditions.visibilityOf(primaryLanguage)).clear();
        primaryLanguage.sendKeys(strPrimaryLanguage);
    }
    public void setStreetAddress(String strStreetAddress){
        wait.until(ExpectedConditions.visibilityOf(streetAddress)).clear();
        streetAddress.sendKeys(strStreetAddress);
    }
    public void setCountry(String strCountry){
        executor.executeScript("arguments[0].scrollIntoView(true);",country);
        Select s =new Select(country);
        s.selectByValue(strCountry);
    }
    public void setCity(String strCity){
        wait.until(ExpectedConditions.visibilityOf(city)).clear();
        city.sendKeys(strCity);
    }
    public void setState(String strState){
        executor.executeScript("arguments[0].scrollIntoView(true);",state);
        Select s =new Select(state);
        s.selectByValue(strState);
    }
    public void setZip(String strZip){
        wait.until(ExpectedConditions.visibilityOf(zip)).clear();
        zip.sendKeys(strZip);
    }
    public void setPhone(String strPhone){
        wait.until(ExpectedConditions.visibilityOf(phone)).clear();
        phone.sendKeys(strPhone);
    }
    public void setEmail(String strEmail){
        wait.until(ExpectedConditions.visibilityOf(email)).clear();
        email.sendKeys(strEmail);
    }
    public void clickDriverRadioBtn(){
        driver.click();
    }

    public List<WebElement> getCheckBoxPage3(){
        wait.until(ExpectedConditions.visibilityOfAllElements(checkBox));
        return checkBox;
    }
    public void clickCheckBoxes(){
        Iterator<WebElement> iterator =checkBox.iterator();
        int count=0;
        while (iterator.hasNext()){
            count = count+1;
            iterator.next().click();
            if(count==7){ break; }
        }
    }
    //id information methods
    public void setSocialSecurity(String strSocialSecurity){
        wait.until(ExpectedConditions.visibilityOf(socialSecurity)).sendKeys(strSocialSecurity);
    }
    public void setDriverLicense(String strDriverLicense){
        wait.until(ExpectedConditions.visibilityOf(driverLicense)).sendKeys(strDriverLicense);
    }
    public void setIdState(String strIdState){
        executor.executeScript("arguments[0].scrollIntoView(true);",idState);
        Select s =new Select(idState);
        s.selectByValue(strIdState);
    }
    public void setOtherId(String strOtherId){
        wait.until(ExpectedConditions.visibilityOf(otherId)).sendKeys(strOtherId);
    }
    public void setOtherIdCountry(String strOtherIdCountry){
        executor.executeScript("arguments[0].scrollIntoView(true);",otherIdCountry);
        Select s =new Select(otherIdCountry);
        s.selectByValue(strOtherIdCountry);
    }
    public void setOtherIdState(String strOtherIdState){
        wait.until(ExpectedConditions.visibilityOf(otherIdState)).sendKeys(strOtherIdState);
    }
    public void setOtherIdType(String strOtherIdType){
        wait.until(ExpectedConditions.visibilityOf(otherIdType)).sendKeys(strOtherIdType);
    }

    //school information methods
    public void setSchoolName(String strSchoolName){
        wait.until(ExpectedConditions.visibilityOf(schoolName)).sendKeys(strSchoolName);
    }
    public void setSchoolAddress(String strSchoolAddress){
        wait.until(ExpectedConditions.visibilityOf(schoolAddress)).sendKeys(strSchoolAddress);
    }
    public void setSchoolCity(String strSchoolCity){
        wait.until(ExpectedConditions.visibilityOf(schoolCity)).sendKeys(strSchoolCity);
    }
    public void setSchoolState(String strSchoolState){
        executor.executeScript("arguments[0].scrollIntoView(true);",schoolState);
        Select s =new Select(schoolState);
        s.selectByValue(strSchoolState);
    }
    public void setSchoolZip(String strSchoolZip){
        wait.until(ExpectedConditions.visibilityOf(schoolZip)).sendKeys(strSchoolZip);
    }
    public void setSchoolPhone(String strSchoolPhone){
        wait.until(ExpectedConditions.visibilityOf(schoolPhone)).sendKeys(strSchoolPhone);
    }

    //parent information methods
    public void setParentName(String strParentName){
        wait.until(ExpectedConditions.visibilityOf(parentName)).sendKeys(strParentName);
    }
    public void setParentAddress(String strparentAddress){
        wait.until(ExpectedConditions.visibilityOf(parentAddress)).sendKeys(strparentAddress);
    }
    public void setparentCity(String strparentCity){
        wait.until(ExpectedConditions.visibilityOf(parentCity)).sendKeys(strparentCity);
    }
    public void setparentState(String strparentState){
        executor.executeScript("arguments[0].scrollIntoView(true);",parentState);
        Select s =new Select(parentState);
        s.selectByValue(strparentState);
    }
    public void setparentZip(String strparentZip){
        wait.until(ExpectedConditions.visibilityOf(parentZip)).sendKeys(strparentZip);
    }
    public void setparentPhone(String strparentPhone){
        wait.until(ExpectedConditions.visibilityOf(parentPhone)).sendKeys(strparentPhone);
    }

    //employer information methods
    public void setOccupation(String strOccupation){
        wait.until(ExpectedConditions.visibilityOf(occupation)).sendKeys(strOccupation);
    }
    public void setEmployerName(String strEmployerName){
        wait.until(ExpectedConditions.visibilityOf(employerName)).sendKeys(strEmployerName);
    }
    public void setEmployerAddress(String strEmployerAddress){
        wait.until(ExpectedConditions.visibilityOf(employerAddress)).sendKeys(strEmployerAddress);
    }
    public void setEmployerCity(String strEmployerCity){
        wait.until(ExpectedConditions.visibilityOf(employerCity)).sendKeys(strEmployerCity);
    }
    public void setEmployerState(String strEmployerState){
        executor.executeScript("arguments[0].scrollIntoView(true);",employerState);
        Select s =new Select(employerState);
        s.selectByValue(strEmployerState);
    }

    public void setEmployerZip(String strEmployerZip){
        wait.until(ExpectedConditions.visibilityOf(employerZip)).sendKeys(strEmployerZip);
    }
    public void setEmployerPhone(String strEmployerPhone){
        wait.until(ExpectedConditions.visibilityOf(employerPhone)).sendKeys(strEmployerPhone);
    }
}
