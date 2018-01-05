package pom1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageObject {

	@FindBy(xpath = ".//*[@id='exampleInputEmail1']")
	WebElement usernameTextBox;
	@FindBy(xpath = ".//*[@id='exampleInputPassword1']")
	WebElement passwordTextBox;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//span[@class='mr-sm ng-binding']")
	WebElement profile;
	
	WebDriver driver; 
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public LoginPageObject() {
//		super();
//		PageFactory.initElements(driver, this);
//	}

	public void user_is_on_Home_Page() {

		driver.get("http://fits.qauber.com");

	}

	public void typeUserName(String username) {
		usernameTextBox.sendKeys(username);
	}

	public void typePassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void clickLoginButton() {
wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	public void message_displayed_Login_Successfully() {

		String validate = profile.getText();
		Assert.assertEquals(validate, "amruthaa");
		System.out.println("User is on the login page");
		
	
	}

}
