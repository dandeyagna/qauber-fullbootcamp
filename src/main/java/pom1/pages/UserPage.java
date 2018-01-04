package pom1.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserPage extends HomePage {
	
	
	@FindBy(xpath="//a[@title='Users']")
	WebElement user;
	@FindBy(xpath="//button[@class='pull-right btn btn-info btn-sm']")
	WebElement inviteUserButton;
	@FindBy(xpath="//input[@name='email']")
	WebElement userEmailId;
	
	@FindBy(xpath="//button[@class='btn btn-primary mr']")
	WebElement sendInviteButton;
	@FindBy(xpath="//table[@class='table table-bordered']//a")
	WebElement emailIDLink;
	@FindBy(xpath="//a[text()='›']")
	WebElement pagination;
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelTab;
	@FindBy(xpath="//span[text()='Please enter a valid email address']")
	WebElement ErrorInvalidEmailId;
	@FindBy(xpath="//span[text()='This field is required']")
	WebElement ErrorEmptyEmailID;		
	
	
	
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
    
	
	@When("^User clicks user list$")
	public void clickUserList() throws InterruptedException{
		Thread.sleep(3000);
		user.click();
	}
	
	@When("^User click Send Invite button$")
	public void clickInviteuserButton(){
		inviteUserButton.click();
		
	}
	@When("^User enters email id as \"([^\"]*)\"$")
	public void typeEmailId(String emailID){
		userEmailId.sendKeys(emailID);
	}
	
	@When("^User click on InviteButton$")
	public void clickInviteButton(){
		sendInviteButton.click();
		
	}
	
	@Then("^Error message displayed for Invalid email \"([^\"]*)\"$$")
	public void typeEmailIdD(String emailID){
		
		String g =ErrorInvalidEmailId.getText();
		Assert.assertEquals("Please enter a valid email address", g);
		
	}
	

	@Then("^Error message displayed for empty email \"([^\"]*)\"$$")
	public void typeEmptyEmailId(String emailID){
		
		String g = ErrorEmptyEmailID.getText();
		Assert.assertEquals("This field is required", g);
		driver.quit();
	}
	
	public void clearEmailID(String emailID){
		userEmailId.clear();
		
	}
	public void closeTab(){
		cancelTab.click();
		
	}
	@Then("^Username \"([^\"]*)\" displayed in User list$")
	public void verifyEmailIdPresent(String emailID){
	
		
		int count = 1;

		WebElement pagination = driver.findElement(By.xpath("//a[text()='›']"));
		

		while (pagination.isDisplayed()) {

			boolean exist = false;

			List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));
			for (WebElement e : allElement) {
				System.out.println("It is running..");
				if (e.getText().equals(emailID)) {
					exist = true;
					System.out.println(emailID + " Email id is present in user list");
					System.out.println(e.getText());

				}
			}
			if (exist == true) {
				break;

			}
			count++;
			WebElement page = driver.findElement(By.xpath("//a[text()='" + count + "']"));
			page.click();
			
			driver.quit();
		}
		
	}
	}


	
	