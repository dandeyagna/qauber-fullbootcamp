package pom1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEntityPage extends Basepage {
	
	@FindBy(xpath = "//span[text()='Entities']")
	WebElement Entity;
	@FindBy(xpath = "//button[text()='Add Entity']")
	WebElement addEntity;
	@FindBy(xpath = "//input[@name='name']")
	WebElement eName;
	@FindBy(xpath = "//button[@class='upload btn btn-labeled btn-primary']")
	WebElement addLogo;
	@FindBy(xpath = "//select[@name='country']/option[text()='United States']")
	WebElement country;
	@FindBy(xpath = "//input[@name='address1']")
	WebElement address1;
	@FindBy(xpath = "//input[@ng-model='$ctrl.org.address2']")
	WebElement address2;
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	@FindBy(xpath = "//select[@name='state']/option[text()='Florida']")
	WebElement state;
	@FindBy(xpath = "//input[@name='zip']")
	WebElement zip;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']")
	WebElement info;
	@FindBy(xpath = "//button[@ class='btn btn-info btn-labeled'][2]")
	WebElement nextButton;
	@FindBy(xpath = "//div[@class='bootstrap-tagsinput']/input")
	WebElement regularUserEmailId;
	@FindBy(xpath = "//button[@class='btn btn-info btn-labeled'][2]")
	WebElement nextReg;
	@FindBy(xpath = "//button[text()='Done']")
	WebElement confirm;
	@FindBy(xpath = "//div[@class='form-group']/div/input")
	WebElement adminUserEmailId;
	@FindBy(xpath = "//button[@class='btn btn-info btn-labeled'][2]")
	WebElement nextAdmin;
	@FindBy(xpath = "//button[text()='Done']")
	WebElement confirmAd;
	@FindBy(xpath = "//div[@class='slider slider-horizontal']")
	WebElement sliderbar;
	@FindBy(xpath = "//div[@class='slider-handle min-slider-handle round']")
	WebElement slider;
	@FindBy(xpath = "//button[@class='btn btn-info btn-labeled'][2]")
	WebElement finishSubs;
	@FindBy(xpath = "//span[@class='rightarrow']")
	WebElement rightArrow;
	@FindBy(xpath = ".//*[@id='login_email']")
	WebElement paypalEmail;
	@FindBy(xpath = ".//*[@id='login_password']")
	WebElement paypalPassword;
	@FindBy(xpath = ".//*[@id='submitLogin']")
	WebElement clickLogin;
	@FindBy(xpath = ".//*[@id='continue']")
	WebElement clickContinue; 
	@FindBy(xpath = "//span[text()='Please enter a valid email address']")
	WebElement emailValid; 
	@FindBy(xpath = "//input[@name='zip']/../span[text()='This field is required']")
	WebElement zipValid; 
	@FindBy(xpath = "//label[text()='Entity name *']/../span[text()='This field is required']")
	WebElement eNameValid; 
	@FindBy(xpath = "//label[text()='Address 1 *']/../span[text()='This field is required']")
	WebElement addressOneValid; 
	@FindBy(xpath = "//select[@name='country']")
	WebElement selectCountry; 
	@FindBy(xpath = "//label[text()='Country *']/../span[text()='This field is required']")
	WebElement countryValid; 
	@FindBy(xpath = "//select[@name='state']")
	WebElement selectState; 
	@FindBy(xpath = "//label[text()='State *']/../span[text()='This field is required']")
	WebElement stateValid; 
	@FindBy(xpath = "//a[text()='›']")
	WebElement nextPage; 
	@FindBy(xpath = "//table[@class='table table-bordered']//a")
	List<WebElement> listOfEntities; 
	
	public AddEntityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public AddEntityPage() {
//		super();
//		PageFactory.initElements(driver, this);
//	}

	@When("^User clicks on 'Entities'$")
	public void clickEntity() {
		wait.until(ExpectedConditions.elementToBeClickable(Entity)).click();
	}

	@When("^clicks on 'Add entity'$")
	public void clickAddEntity() {
		addEntity.click();
	}

	@When("^Enter Entity name as \"([^\"]*)\"$")
	public void typeEname(String entityname) {
		eName.sendKeys(entityname);
	}

	@When("^Select Entity logo$")
	public void clickLogo() throws AWTException {
		addLogo.click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

			robot.delay(500);

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e1) {

			e1.printStackTrace();

		}

	}

	@When("^Select country$")
	public void clickCountry() {
		country.click();
	}

	@When("^Enter AddressOne as \"([^\"]*)\"$")
	public void typeAddress1(String address) {
		address1.sendKeys(address);
	}

	@When("^Enter AddressTwo as \"([^\"]*)\"$")
	public void typeAddress2(String addresstwo) {
		address2.sendKeys(addresstwo);
	}

	@When("^Enter City as \"([^\"]*)\"$")
	public void typeCity(String cityname) {
		city.sendKeys(cityname);
	}

	@When("^Select state$")
	public void clickState() {
		state.click();
	}

	@When("^Enter postal code as \"([^\"]*)\"$")
	public void typeZip(String postalcode) {
		zip.sendKeys(postalcode);
	}

	@When("^Enter Phone as \"([^\"]*)\"$")
	public void typePhone(String phonenumber) {
		phone.sendKeys(phonenumber);
	}

	@When("^Enter Email as \"([^\"]*)\"$")
	public void typeEmail(String emailId) {
		email.sendKeys(emailId);
	}

	@When("^Enter notes as \"([^\"]*)\"$")
	public void typeInfo(String notes) {
		info.sendKeys(notes);
	}

	@When("^Click on next step$")
	public void clickNext() throws InterruptedException {
		Thread.sleep(5000);
		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
			} catch (Exception e) {

			}
		}
		nextButton.click();
	}

	@When("^Type regular user email as \"([^\"]*)\"$")
	public void typeregularUserEmailId(String userName) {
		regularUserEmailId.sendKeys(userName);
	}

	@When("^click on done$")
	public void clicknextAdmin() throws InterruptedException {
		Thread.sleep(5000);
		nextReg.click();
	}

	@When("^click on next step in the regularUser page$")
	public void clickconfirmAd() throws InterruptedException {
		Thread.sleep(5000);
		confirm.click();
	}

	@When("^Type admin user email as \"([^\"]*)\"$")
	public void typeadminUserEmailId(String userName) throws InterruptedException {
		adminUserEmailId.sendKeys(userName);
	}

	@When("^click on done in admin page$")
	public void clicknextReg() throws InterruptedException {
		Thread.sleep(5000);
		nextAdmin.click();
	}

	@When("^click on next step in the admin page$")
	public void clickconfirm() throws InterruptedException {
		Thread.sleep(5000);
		confirmAd.click();
	}

	@Then("^Select the subscription$")
	public void getSize() throws InterruptedException {
		Thread.sleep(5000);
		Dimension sliderBarDemsion = sliderbar.getSize();
		int widthSliderBar = sliderBarDemsion.width;
		Actions sliderAction = new Actions(driver);
		sliderAction.clickAndHold(slider);
		int x1 = getPixels(widthSliderBar, 60);
		sliderAction.moveByOffset(x1, 0).perform();
		finishSubs.click();
	}

	private int getPixels(int totalWidth, int percentage) {
		return (int) ((totalWidth * percentage) / 100);
	}
	@Then("^complete with the paypal account$")
	public void comple_with_the_paypal_account() {
		wait.until(ExpectedConditions.elementToBeClickable(rightArrow)).click();
	}
	@Then("^User enters paypal email as \"([^\"]*)\"$")
	public void paypalLogin(String paypalEmailId) {
		paypalEmail.sendKeys(paypalEmailId);
	}
	@Then("^User enters paypal pass as \"([^\"]*)\"$")
	public void papPalPass(String paypalPass) {
		paypalPassword.sendKeys(paypalPass);
	}
	@Then("^User clicks on paypal login button$")
	public void clickOnPaypalLogin() {
		clickLogin.click();
	}
	@Then("^clicks on continue$")
	public void clickOnContinue() {
		clickContinue.click();
	}
	@Then("^User should be able to see the added entity on the entity page$")
	public void user_should_be_able_to_see_the_added_entity_on_the_entity_page() throws InterruptedException {
		Thread.sleep(5000);
		WebElement page = driver.findElement(By.xpath("//a[@ng-click='selectPage(page + 1, $event)']"));
		Capabilities cp1 = ((RemoteWebDriver) driver).getCapabilities();
		if (cp1.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page);
			} catch (Exception g) {

			}
		}

		int count = 1;

		WebElement pagination = driver.findElement(By.xpath("//a[text()='›']"));

		while (pagination.isDisplayed()) {
			
			boolean exist = false;

			List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));
			for (WebElement e : allElement) {
				String value = "hellohi1";
				if (e.getText().equals(value)) {
					exist = true;
					System.out.println(value + " Entity is present");
					

				}
				
				//Assert.assertEquals(exist, true, "Expected email id is not present");
					}
		if(exist==true){
		break;
		}
		count++;
		WebElement page1 = driver.findElement(By.xpath("//a[text()='" + count + "']"));
		page1.click();

	}
	}
	@Then("^User should get a error message when user enters invalid email format$")
	public void emailValidation(){
		String valid = emailValid.getText();
		Assert.assertEquals("Please enter a valid email address",valid );
	}
	@Then("^Leave the postal code field empty$")
	public void postalCode(){
		zip.clear();
	}
	@Then("^User should get a error message in Postal code field$")
	public void postalCodeValidation(){
		String verify = zipValid.getText();
		Assert.assertEquals(verify, "This field is required");
	}
	@Then("^Leave the entity name field empty$")
	public void entityName(){
		eName.clear();
	}
	@Then("^User should get a error message in Entity name field$")
	public void entityNameValidation(){
		String validEntityName = eNameValid.getText();
		Assert.assertEquals(validEntityName, "This field is required");
	}
	@Then("^Leave the AddressOne field empty$")
	public void addressOne(){
		address1.clear();
	}
	@Then("^User should get a error message in AddressOne field$")
	public void addressOneValidation(){
		String validAddressOne = addressOneValid.getText();
		Assert.assertEquals(validAddressOne, "This field is required");
	}
	@Then("^Select country as Select a country$")
	public void country(){
		Select select = new Select(selectCountry);
		select.selectByVisibleText("Select a country");
	}
	@Then("^User should get a error message when not selecting the country field$")
	public void countryValidation(){
		String validCountry = countryValid.getText();
		Assert.assertEquals(validCountry, "This field is required");
	}
	@Then("^Select state as Select a state$")
	public void state(){
		Select select = new Select(selectState);
		select.selectByVisibleText("Select a state");
	}
	@Then("^User should get a error message when not selecting the state field$")
	public void stateValidation(){
		String validState = stateValid.getText();
		Assert.assertEquals(validState, "This field is required");
	}
	@Then("^again user click on Entities$")
	public void clickOnEntities() throws InterruptedException{
		Thread.sleep(3000);
		Entity.click();
	}
	@Then("^SAU should be able to see the entity on the entities page without completion of the payment as not subscribed$")
	public void notSubscribed(){
		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextPage);
			} catch (Exception g) {

			}
		}
		boolean exists = false;
		while (nextPage.isEnabled()) {
			List<WebElement> allElement =listOfEntities;
			for (WebElement f : allElement) {
				String value = "seleniumfitt12";
				System.out.println(f.getText());
				if (f.getAttribute("text").equals(value)) {
					exists = true;
					break;
					//Assert.assertEquals(f.getText(), value);
					
				}

			}
			if(exists){
				break;
			}

			nextPage.click();

		}
if(exists){
	System.out.println("Pass");

}

	}
	
	
	
}
