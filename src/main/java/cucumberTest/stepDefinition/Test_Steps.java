package cucumberTest.stepDefinition;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
    private WebDriver driver;
    private String url;
    private WebDriverWait wait;
    private EditCompanyPage editCompanyPage;
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private MainNavigationPage mainNavigationPage;
    private PaypalPage paypalPage;
    private EntitiesPage entitiesPage;
    private EditProfilePage editProfilePage;
    private SearchReportPage searchReportPage;
    private AddReportPage addReportPage;


    //Test Login functionality
    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() {
        driver = new FirefoxDriver();
        url = "http://fits.qauber.com/#/page/login";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);

    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_Username_and_Password(String username, String password) throws InterruptedException {

        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
        //driver.findElement(By.id("login")).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(.,'Login')]")));

    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() {
        String title = driver.getTitle();
        System.out.println(title);
        String x = driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[2]/ul[2]/li/a/span")).getText();
        System.out.println(x);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[2]/ul[2]/li/a/span")).isDisplayed());
        driver.quit();
    }

    //Test change name test case

    @Given("^User is logged into application$")
    public void user_is_logged_into_application() {
        driver = new FirefoxDriver();
        url = "http://fits.qauber.com/#/page/login";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("buquxahu@cars2.club");
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("kisulea");
        //driver.findElement(By.id("login")).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(.,'Login')]")));
    }

    @When("^Click on user's link$")
    public void click_on_users_link() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']")).click();
        Thread.sleep(3000);
    }

    @When("^Click on editProfile button$")
    public void click_on_editProfile_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Edit Profile')]"))).click();

        //driver.findElement(By.xpath("//button[contains(.,'Edit Profile')]")).click();
    }

    @When("^Type name into Name textInput field$")
    public void type_name_into_changeName_textField() {
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Lina");

    }

    @When("^Click update Button$")
    public void click_on_update_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@ng-click='$ctrl.submitGeneralForm()']")).click();
        Thread.sleep(2000);
    }

    @Then("^Successful message is displayed$")
    public void success_message_is_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]")));
        String sMessage = driver.findElement(By.xpath("/html/body/div[3]")).getText();
        Assert.assertEquals(sMessage, "The profile has been updated.");
        driver.quit();
    }

    @When("^Type all required fields$")
    public void typeAllRequiredFields() throws InterruptedException {

        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        Thread.sleep(3000);
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditCompanyBtn();
        Thread.sleep(3000);
        editCompanyPage = new EditCompanyPage(driver);
        editCompanyPage.setCompanyName("Telecomunication");
        editCompanyPage.setCountry("Albania");
        editCompanyPage.setAddress1("123 adbfgr ");
        editCompanyPage.setAddress2("4 apt");
        editCompanyPage.setCity("tampa");
        editCompanyPage.setStateTextField("kjiogjidjfa");
        editCompanyPage.setZip("567676");
        editCompanyPage.setPhone("6578767877");
        editCompanyPage.setEmail("tampa@yahoo.com");
        editCompanyPage.setNotes("notes");
        editCompanyPage.clickUpdateBtn();
        Thread.sleep(2000);
    }

    @Then("^Successfully updated company info$")
    public void companyUpdateAssertion() throws InterruptedException {
        editCompanyPage = new EditCompanyPage(driver);
        Assert.assertTrue(editCompanyPage.getSuccessUpdateMessage().isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }

    @When("^Type required fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and pay subscription$")
    public void testAddEntity(String name, String country, String address1, String city, String state,
                              String zip, String phone, String email, String RUemail, String AUemail) throws InterruptedException {
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickEntitiesLink();
        entitiesPage = new EntitiesPage(driver);
        entitiesPage.clickAddEntityBtn();
        entitiesPage.setCompanyName(name);
        entitiesPage.setCountry(country);
        entitiesPage.setAddress1(address1);
        entitiesPage.setCity(city);
        entitiesPage.setState(state);
        entitiesPage.setZip(zip);
        entitiesPage.setPhone(phone);
        entitiesPage.setEmail(email);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(4000);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(8000);
        entitiesPage.setAddEmailRU(RUemail);
        Thread.sleep(8000);
        entitiesPage.clickNextStepBtn();
        entitiesPage.setAddEmailFieldAU(AUemail);
        entitiesPage.clickNextStepBtn();
        entitiesPage.clickFinishBtn();
        Thread.sleep(20000);
        paypalPage = new PaypalPage(driver);
        paypalPage.paypalSwitchAndPay();
        Thread.sleep(10000);

    }

    @Then("^Successful paymant message is displayed$")
    public void successfulPaymentMessage() throws InterruptedException {
        String title = driver.getTitle();
        Thread.sleep(3000);
        System.out.println(title);
        Assert.assertTrue(title.equalsIgnoreCase("FITS - FITS Web Application"));

        driver.quit();
    }

    //Change password
    @When("^Change password positive \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void testChangePasswordPositive(String currentPassword, String newPassword, String repeatNewPassword) throws InterruptedException {
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();

        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditProfileBtn();

        editProfilePage = new EditProfilePage(driver);
        editProfilePage.setCurrentPassword(currentPassword);
        editProfilePage.setNewPassword(newPassword);
        editProfilePage.setConfirmNewPassword(repeatNewPassword);
        editProfilePage.clickChangePassBtn();
        String successMessage = editProfilePage.getSuccessMessage();
        Thread.sleep(4000);
        Assert.assertEquals(successMessage, "The password has been changed.");
    }

    @Then("^Password is updated message is displayed$")
    public void password_is_updated() throws InterruptedException {
        editProfilePage = new EditProfilePage(driver);
        String successMessage = editProfilePage.getSuccessMessage();
        Thread.sleep(4000);
        Assert.assertEquals(successMessage, "The password has been changed.");

        driver.quit();
    }


    //search report by id
    @When("^Search report by \"([^\"]*)\"$")
    public void searchByCaseIdTest(String id) throws InterruptedException {
        //1) Search by case id
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickReportsLink();
        searchReportPage = new SearchReportPage(driver);
        searchReportPage.setCiSearchKey(id);
        searchReportPage.clickPublishedCheckBox();
        searchReportPage.clickView();

    }

    @Then("^correct report is opened$")
    public void assertCorrectReport() throws InterruptedException {
        searchReportPage = new SearchReportPage(driver);
        String x = searchReportPage.getValidateCaseId();
        System.out.println("This is what i get: " + x + " And this is what i expect: 780 caseId");
        Assert.assertEquals(x, "780");
        // mainNavigationPage.clickReportsLink();
        Thread.sleep(3000);
    }

    //add report steps:

    @When("^Click AddReportBtn, select entity and click nextBtn$")
    public void selectEntityStep() {
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickAddReportLink();
        //click on add report link
        addReportPage = new AddReportPage(driver);
        String title = addReportPage.getHeaderText();
        Assert.assertEquals(title, "Field Interview Card");
        //select an entity
        addReportPage.clickEntityNameRBtn();
        //move to next page
        addReportPage.clickNextBtn();
        String title2 = addReportPage.getSubjectInformationTitle();
        Assert.assertEquals(title2, "Subject Information");
    }

    @When("^Provide personal information and click nextBtn, Select identifiers and click next \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void providePersonalInformation(String caseId, String suspectType, String lastName, String firstName,
                                           String middleName, String nickname, String dob, String sex, String race, String height,
                                           String weight, String hairColor, String hairLength, String hairStyle, String eyeColor,
                                           String complexion, String teeth, String handPreference, String language, String streetAddress,
                                           String country, String city, String state, String zip, String phone, String email) {
        //Add information about suspect
        addReportPage = new AddReportPage(driver);
        addReportPage.setCaseId(caseId);
        addReportPage.setSuspectType(suspectType);
        addReportPage.setLastName(lastName);
        addReportPage.setFirstName(firstName);
        addReportPage.setMiddleName(middleName);
        addReportPage.setNickName(nickname);
        addReportPage.setDOB(dob);
//        int age = addReportPage.calculateAge();//fir this fields need to import something.is not working in this new version
//        addReportPage.setAge(" " + age);
        addReportPage.setSex(sex);
        addReportPage.setRace(race);
        addReportPage.setHeight(height);
        addReportPage.setWeight(weight);
        addReportPage.setBuild();
        addReportPage.setHeirColor(hairColor);
        addReportPage.setHeirLength(hairLength);
        addReportPage.setHeirStyle(hairStyle);
        addReportPage.setEyeColor(eyeColor);
        addReportPage.setComplexion(complexion);
        addReportPage.setTeeth(teeth);
        addReportPage.setHandPreference(handPreference);
        addReportPage.setPrimaryLanguage(language);
        addReportPage.setStreetAddress(streetAddress);
        addReportPage.setCountry(country);
        addReportPage.setCity(city);
        addReportPage.setState(state);
        addReportPage.setZip(zip);
        addReportPage.setPhone(phone);
        addReportPage.setEmail(email);
        addReportPage.clickDriverRadioBtn();
        addReportPage.clickNextBtn2();
        String title3 = addReportPage.getIdentifiersTitle();
        Assert.assertEquals(title3, "Identifiers");
        addReportPage.clickCheckBoxes();
        addReportPage.clickNextBtn3();
        String title4 = addReportPage.getIdInformationTitle();
        Assert.assertEquals(title4, "ID Information");

    }

    @When("^Provide id, school and other information.Click nextBtn \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void provideSchoolAndIdInfo(String ssn,
                                       String driverLicenseN, String idState, String otherId, String otherCountry, String otherIdState,
                                       String otherIdType, String schoolName, String schoolAddress, String schoolCity, String schoolState,
                                       String schoolZip, String schoolPhone, String parentName, String parentAddress, String parentCity,
                                       String parentState, String parentZip, String parentPhone, String occupation, String employerName, String employerAddress,
                                       String employerCity, String employerState, String employerZip, String employerPhone) {
        addReportPage = new AddReportPage(driver);
        addReportPage.setSocialSecurity(ssn);
        addReportPage.setDriverLicense(driverLicenseN);
        addReportPage.setIdState(idState);
        addReportPage.setOtherId(otherId);
        addReportPage.setOtherIdCountry(otherCountry);
        addReportPage.setOtherIdState(otherIdState);
        addReportPage.setOtherIdType(otherIdType);
        //adding school information
        addReportPage.setSchoolName(schoolName);
        addReportPage.setSchoolAddress(schoolAddress);
        addReportPage.setSchoolCity(schoolCity);
        addReportPage.setSchoolState(schoolState);
        addReportPage.setSchoolZip(schoolZip);
        addReportPage.setSchoolPhone(schoolPhone);
        //parent information
        addReportPage.setParentName(parentName);
        addReportPage.setParentAddress(parentAddress);
        addReportPage.setparentCity(parentCity);
        addReportPage.setparentState(parentState);
        addReportPage.setparentZip(parentZip);
        addReportPage.setparentPhone(parentPhone);
        //employer information
        addReportPage.setOccupation(occupation);
        addReportPage.setEmployerName(employerName);
        addReportPage.setEmployerAddress(employerAddress);
        addReportPage.setEmployerCity(employerCity);
        addReportPage.setEmployerState(employerState);
        addReportPage.setEmployerZip(employerZip);
        addReportPage.setEmployerPhone(employerPhone);
        //move to next page
        addReportPage.clickNextBtn4();
        String title5 = addReportPage.getDistributionTitle();//move to next tab
        Assert.assertEquals(title5, "Gang Membership");

    }

    @When("^Provide info about gangMembership.Click nextBtn \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void provideGangMembershipInfo(String reasonForStop, String locationOfStop,
                                          String dispositionOfStop, String gangName, String howLong, String otherInformation, String beat) {
        addReportPage = new AddReportPage(driver);
        addReportPage.clickDistributionCheckboxes();
        addReportPage.setReasonForStop(reasonForStop);
        addReportPage.setlocationOfStop(locationOfStop);
        addReportPage.setdispositionOfStop(dispositionOfStop);
        addReportPage.setgangName(gangName);
        addReportPage.sethowLong(howLong);
        addReportPage.clickGangCriteriaCheckboxes();
        addReportPage.setOtherInformation(otherInformation);
        addReportPage.setBeat(beat);
        addReportPage.clickNextBtn5();
        String title6 = addReportPage.getVehicleTitle();
        Assert.assertEquals(title6, "Vehicle");
    }

    @When("^Provide Vehicle information and click nextBtn \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void provideVehicleInfo(String vehicleLicense, String vehicleMake, String vehicleColor) throws AWTException {
        addReportPage = new AddReportPage(driver);
        //vehicle information
        addReportPage.setvehicleLicense(vehicleLicense);
        addReportPage.setvehicleMake(vehicleMake);
        addReportPage.setvehicleColor(vehicleColor);
        addReportPage.clickNextBtn6();
        String title7 = addReportPage.getPhotosTitle();
        Assert.assertEquals(title7, "Photos");

        //add picture to report
        addReportPage.uploadImage();
        addReportPage.clickNextBtn7();

        String title8 = addReportPage.getReviewInfo();
        Assert.assertEquals(title8, "Preview");
    }

    @When("^Publish report$")
    public void publishReport() {
        addReportPage = new AddReportPage(driver);
        addReportPage.clickPublishReportBtn();
    }

    @Then("^Assert that report is published \"([^\"]*)\"\"([^\"]*)\"$")
    public void assertThatReportIsPublished(String lastName, String caseId) {
        addReportPage = new AddReportPage(driver);
        Pattern pattern = Pattern.compile(lastName);
        Matcher matcher = pattern.matcher(addReportPage.getAssertReportPosted());
        System.out.println("My string: " + addReportPage.getAssertReportPosted());
        System.out.println("Pattern i'm looking for (lastName and caseId): " + lastName + "," + caseId);
        //assert that report with last name x is published and visible on search report page
        Assert.assertTrue(matcher.find());

        driver.quit();

    }


}