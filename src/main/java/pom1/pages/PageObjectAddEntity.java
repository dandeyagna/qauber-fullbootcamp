package pom1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PageObjectAddEntity{
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
	WebDriver driver; 
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public PageObjectAddEntity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public PageObjectAddEntity() {
		super();
		PageFactory.initElements(driver, this);
	}
	public void clickEntity() {
		Entity.click();
	}

	public void clickAddEntity() {
		addEntity.click();
	}

	public void typeEname(String entityname) {
		eName.sendKeys(entityname);
	}

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

	public void clickCountry() {
		country.click();
	}

	public void typeAddress1(String address) {
		address1.sendKeys(address);
	}

	public void typeAddress2(String addresstwo) {
		address2.sendKeys(addresstwo);
	}

	public void typeCity(String cityname) {
		city.sendKeys(cityname);
	}

	public void clickState() {
		state.click();
	}

	public void typeZip(String postalcode) {
		zip.sendKeys(postalcode);
	}

	public void typePhone(String phonenumber) {
		phone.sendKeys(phonenumber);
	}

	public void typeEmail(String emailId) {
		email.sendKeys(emailId);
	}

	public void typeInfo(String notes) {
		info.sendKeys(notes);
	}

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

	public void typeregularUserEmailId(String userName) {
		regularUserEmailId.sendKeys(userName);
	}

	public void clicknextAdmin() throws InterruptedException {
		Thread.sleep(5000);
		nextReg.click();
	}

	public void clickconfirmAd() throws InterruptedException {
		Thread.sleep(5000);
		confirm.click();
	}

	public void typeadminUserEmailId(String userName1) throws InterruptedException {
		adminUserEmailId.sendKeys(userName1);
	}

	public void clicknextReg() throws InterruptedException {
		Thread.sleep(5000);
		nextAdmin.click();
	}

	public void clickconfirm() throws InterruptedException {
		Thread.sleep(5000);
		confirmAd.click();
	}

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
	public void comple_with_the_paypal_account() {
		wait.until(ExpectedConditions.elementToBeClickable(rightArrow)).click();
	}
	public void paypalLogin(String paypalEmailId) {
		paypalEmail.sendKeys(paypalEmailId);
	}
	public void papPalPass(String paypalPass) {
		paypalPassword.sendKeys(paypalPass);
	}
	public void clickOnPaypalLogin() {
		clickLogin.click();
	}
	public void clickOnContinue() {
		clickContinue.click();
	}
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
	public void emailValidation(){
		String valid = emailValid.getText();
		Assert.assertEquals("Please enter a valid email address",valid );
	}
	public void postalCode(){
		zip.clear();
	}
	public void postalCodeValidation(){
		String verify = zipValid.getText();
		Assert.assertEquals(verify, "This field is required");
	}
	public void entityName(){
		eName.clear();
	}
	public void entityNameValidation(){
		String validEntityName = eNameValid.getText();
		Assert.assertEquals(validEntityName, "This field is required");
	}
	public void addressOne(){
		address1.clear();
	}
	public void addressOneValidation(){
		String validAddressOne = addressOneValid.getText();
		Assert.assertEquals(validAddressOne, "This field is required");
	}
	public void country(){
		Select select = new Select(selectCountry);
		select.selectByVisibleText("Select a country");
	}
	public void countryValidation(){
		String validCountry = countryValid.getText();
		Assert.assertEquals(validCountry, "This field is required");
	}
	public void state(){
		Select select = new Select(selectState);
		select.selectByVisibleText("Select a state");
	}
	public void stateValidation(){
		String validState = stateValid.getText();
		Assert.assertEquals(validState, "This field is required");
	}
	public void clickOnEntities() throws InterruptedException{
		Thread.sleep(3000);
		Entity.click();
	}
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



