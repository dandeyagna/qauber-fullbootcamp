package pom1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends Basepage {
	

	@FindBy(xpath = ".//*[@id='exampleInputEmail1']")
	WebElement usernameTextBox;
	@FindBy(xpath = ".//*[@id='exampleInputPassword1']")
	WebElement passwordTextBox;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//span[@class='mr-sm ng-binding']")
	WebElement profile;
	

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Login() {
		super();
		PageFactory.initElements(driver, this);
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {

		driver.get("http://fits.qauber.com");

	}

	@When("^User enters Username as \"([^\"]*)\"$")
	public void typeUserName(String username) {
		usernameTextBox.sendKeys(username);
	}

	@When("^User enters Password as \"([^\"]*)\"$")
	public void typePassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	@When("^User clicks Login Button$")
	public void clickLoginButton() throws InterruptedException {
		Thread.sleep(3000);
		loginButton.click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() {

		String validate = profile.getText();
		Assert.assertEquals(validate, "amruthaa");
		System.out.println("User is on the login page");
		
	
	}

}