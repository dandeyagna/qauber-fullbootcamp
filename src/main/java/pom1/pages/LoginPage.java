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

public class LoginPage extends HomePage {
	
	
	@FindBy(xpath=".//*[@id='exampleInputEmail1']")
	WebElement usernameTextBox;
	@FindBy(xpath="//*[@id='exampleInputPassword1']")
	WebElement passwordTextBox;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath="//span[@class='text-danger']")
	WebElement errorInvalidEmailID;
	@FindBy(xpath="//span[@class='text-danger']")
	WebElement errorEmptyEmailID;
	@FindBy(xpath="//span[@class='mr-sm ng-binding']")
	WebElement profile;
	@FindBy(xpath="//div[@class='alert alert-danger text-center ng-binding']")
	WebElement errorInvalidPassword;
	

	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage(){
        super();
       PageFactory.initElements(driver, this);
    }
	
	@Given("^User is on Home Page$")
    public void user_is_on_Home_Page() {

        driver.get("http://fits.qauber.com");
	}
	
	
	 @When("^User enters Username as \"([^\"]*)\"$")
	public void typeUserName(String userName){
		usernameTextBox.sendKeys(userName);
		  
		
	}
	
	@When("^User enters Password as \"([^\"]*)\"$")
	public void typePassword(String password){
		passwordTextBox.sendKeys(password);
	}
	
	@When("^User clicks Login Button$")
	public void clickLoginButton() throws InterruptedException{
		Thread.sleep(4000);
		loginButton.click();
	}
	
	  @Then("^Message displayed Login Successfully$")
	    public void message_displayed_Login_Successfully() {

	          String a = profile.getText();

	        if (a.equals("Aditi")) {
	            System.out.println("Test Case passed ...");
	        } else {
	            System.out.println("Test Case Failed ...");
	        }
	        
	        driver.quit();
	  }
	 
	  @Then("^Error message displayed  for Invalid email id$")
	  public void validateErrorMessage_Invalid_Email(){
		  		String z = errorInvalidEmailID.getText();
			  Assert.assertEquals("Please enter a valid email address",z); 
			  driver.quit();
	  }
		  
	 
		
	  @Then("^Error message displayed for Empty email Id$")
	  public void validateErrorMessage_Empty_Email(){
			String d = errorEmptyEmailID.getText();
			Assert.assertEquals("This field is required", d);
			System.out.println("Test Case passed....");
			driver.quit();
	  }
		  
	 
 
	  
	  @Then("^Error message displayed for Invalid password$")
	  public void validateErrorMessage_InvalidPassword_Correct(){
		  String a = errorInvalidPassword.getText();
		Assert.assertEquals("Please make sure your email and password are correct.", a);
		System.out.println("Test Case passed....");
		driver.quit();
	  }
		
	  }
	  
 
	
	
			
	
