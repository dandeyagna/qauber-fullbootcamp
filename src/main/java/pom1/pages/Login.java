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

public class Login {

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
	public WebDriver driver;
	
	//public WebDriverWait wait = new WebDriverWait(driver, 20);
	
	public Login(WebDriver driver){
		
			this.driver = driver;
			PageFactory.initElements(driver, this);
    }
	
	
    public void user_is_on_Home_Page() {

        driver.get("http://fits.qauber.com");
	}
	
	
	
	public void typeUserName(String userName){
		usernameTextBox.sendKeys(userName);
		  
		
	}
	
	
	public void typePassword(String password){
		passwordTextBox.sendKeys(password);
	}
	
	
	public void clickLoginButton() throws InterruptedException{
		Thread.sleep(4000);
	
		//wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
	
	  
	    public void message_displayed_Login_Successfully() {

	          String a = profile.getText();

	        if (a.equals("Aditi")) {
	            System.out.println("Test Case passed ...");
	        } else {
	            System.out.println("Test Case Failed ...");
	        }
	        
	      	  }
	 
	  
	  public void validateErrorMessage_Invalid_Email(){
		  		String z = errorInvalidEmailID.getText();
			  Assert.assertEquals("Please enter a valid email address",z); 
			 
	  }
		  
	 
		
	 
	  public void validateErrorMessage_Empty_Email(){
			String d = errorEmptyEmailID.getText();
			Assert.assertEquals("This field is required", d);
			System.out.println("Test Case passed....");
			
	  }
		  
	 
 
	  
	 
	  public void validateErrorMessage_InvalidPassword_Correct(){
		  String a = errorInvalidPassword.getText();
		Assert.assertEquals("Please make sure your email and password are correct.", a);
		System.out.println("Test Case passed....");
		
	  }
		
	  
	  
 
	
	
			
	

}
