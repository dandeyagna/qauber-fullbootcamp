package pom1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEntity extends HomePage {
	
	@FindBy(xpath="//a[@title='Entities']")
	WebElement entityPage;
	@FindBy(xpath="//button[text()='Add Entity']")
	WebElement addEntity;
   @FindBy(xpath="//input[@placeholder='Cool Name']")
   WebElement entityName;
    @FindBy(xpath="//input[@name='phone']")
    WebElement phoneNumber;
    @FindBy(xpath="//input[@name='email']")
    WebElement EmailID;
   @FindBy(xpath="//select[@name='country']")
   WebElement country;
    @FindBy(xpath="//input[@name='address1']")
    WebElement address1;
    @FindBy(xpath="//input[@name='city']")
    WebElement city;
    @FindBy(xpath="//select[@name='state']")
    WebElement state;
   @FindBy(xpath="//input[@name='zip']")
   WebElement zip;
    @FindBy(xpath="//button[@ class='btn btn-info btn-labeled'][2]")
    WebElement nextStep;
    @FindBy(xpath="//div[@class='bootstrap-tagsinput']/input")
    WebElement regUser;
    @FindBy(xpath="//button[@ng-click='$ctrl.nextStep()']")
    WebElement nextPage;
    @FindBy(xpath="//div[@class='form-group']//div//input")
    WebElement admUser;
    @FindBy(xpath="//button[text()='Done']")
    WebElement done;
    @FindBy(xpath="//button[@ng-click='confirm()']")
    WebElement confirm;
    @FindBy(xpath="//div[@class='slider-handle min-slider-handle round']")
    WebElement slider;
   @FindBy(xpath="//button[@ng-click='$ctrl.nextStep()']")
	WebElement finishButton;
	@FindBy(xpath="//input[@id='loadLogin']")
	WebElement paypalAccount;
	@FindBy(xpath="//input [@id='login_email']")
	WebElement paypalEmail;
	@FindBy(xpath="//input [@id='login_password']")
	WebElement paypalPassword;
	@FindBy(xpath="//input [@id='submitLogin']")
	WebElement submitLogin;
	@FindBy(xpath="//input [@id='continue']")
	WebElement agreePayment;
	@FindBy(xpath="//div[text()='Payment successful.']")
	WebElement paymentSuccessfull;

	public AddEntity(){
    super();
    PageFactory.initElements(driver, this);
}
	
	@When("^User Clicks on Entity$")
	public void click_Entity(){
		entityPage.click();
	}
	
	@When("^User Clicks on Add Entity")
	public void add_Entity(){
		addEntity.click();
	}
	
	@When("^User enters Entity name as \"([^\"]*)\"$")
	public void typeEntity_Name(String entity){
		entityName.sendKeys(entity);		
	}
	
	@When("^User enters phonenumber as \"([^\"]*)\"$")
	public void typePhoneNumber(String number){
		phoneNumber.sendKeys(number);
	}
	@When("^User enters email is as \"([^\"]*)\"$")
	public void typeEmailID(String Email){
		EmailID.sendKeys(Email);
		}

	@When("^User select country as \"([^\"]*)\"$")
	public void selectCountry(String USACountry){
		Select drpCountry = new Select(country);
        drpCountry.selectByVisibleText(USACountry);

	}

	@When("^User enters address1 as \"([^\"]*)\"$")
	public void typeAddress(String add){
		address1.sendKeys(add);
		

	}
	@When("^User enters city as \"([^\"]*)\"$")
	public void typeCity(String cityName){
		city.sendKeys(cityName);
	}

@When("^User select state as \"([^\"]*)\"$")
public void selectState(String CAstate){
	Select drpState = new Select(state);
    drpState.selectByVisibleText(CAstate);

}

@When("^User enters zipcode as \"([^\"]*)\"$")
public void typeZipCode(String zipCode){
	zip.sendKeys(zipCode);
}

@When("^User click on next step$")
public void clickNext() throws InterruptedException{
	Thread.sleep(10000);

    WebElement next = driver.findElement(By.xpath("//button[@ class='btn btn-info btn-labeled'][2]"));

		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
			} catch (Exception e) {

			}
		}

		next.click();
}
	@When("^User enters regular user name as \"([^\"]*)\"$")
	public void typeRegUser(String regName){
		regUser.sendKeys(regName);
	}
	
	@When("^User clicks on Next page$")
	public void clickNextPage() throws InterruptedException{
		//Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(nextPage)).click();
	}
	

@When("^User clicks on Done button$")
public void clickDoneButton(){
	wait.until(ExpectedConditions.elementToBeClickable(done)).click();

}
	@When("^User enters admUser as \"([^\"]*)\"$")
	public void typeadmUser(String admUserName){
		admUser.sendKeys(admUserName);
	}

@When("^User click on Confirm button$")
public void clickConfirmButton() throws InterruptedException{
	wait.until(ExpectedConditions.elementToBeClickable(confirm)).click();
	//Thread.sleep(10000);

}
	@When("^User select slider$")
	public void selectSlider() throws InterruptedException{
		Thread.sleep(5000);
		WebElement sliderBar = driver.findElement(By.xpath("//div[@class='slider slider-horizontal']"));
       org.openqa.selenium.Dimension sliderBarDemsion = sliderBar.getSize();
       int widthSliderBar = sliderBarDemsion.width;


       WebElement slider = driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
       Actions sliderAction = new Actions(driver);
       sliderAction.clickAndHold(slider);
       int x1 = getPixels(widthSliderBar,60);
       sliderAction.moveByOffset(x1, 0).perform();
	}

	public static int getPixels(int totalWidth, int percentage) {
		return (int) ((totalWidth * percentage) / 100);

	}
	
	@When("^User clicks on Finish button$")
	public void clickFinish(){
		wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
	}
	@When("^User navigate to Paypalaccount$")
	public void naviagetPaypalAccount(){
		wait.until(ExpectedConditions.elementToBeClickable(paypalAccount)).click();

	}
	@When("^User clicks on paypalID as \"([^\"]*)\"$")
	public void typePaypalID(String paypalID){
		paypalEmail.sendKeys(paypalID);;

	}

@When("^User clicks on paypal password as \"([^\"]*)\"$")
public void typePaypalPassword(String paypalPwd){
	paypalPassword.sendKeys(paypalPwd);

}
	@When("^User clicks on Submitlogin button$")
	public void clickSubmitLoginButton(){
		submitLogin.click();
	}
	@When("^User clicks on Agreepayment$")
	public void clickAgreepayment(){
		agreePayment.click();

	}
	@Then("^Message dispayed Payment Successfull\\.$")
	public void paymentSuccessfull(){
		WebElement paymentSuccessfull = driver.findElement(By.xpath("//div[text()='Payment successful.']"));	
		String paymentSuccessMessage = paymentSuccessfull.getText();
		Assert.assertEquals(paymentSuccessMessage , "Payment successful.");
	}
	
	
}