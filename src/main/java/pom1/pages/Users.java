package pom1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Users {


		
		
		@FindBy(xpath="//a[@title='Users']")
		WebElement user;
		@FindBy(xpath="//button[@class='pull-right btn btn-info btn-sm']")
		WebElement inviteUserButton;
		@FindBy(xpath="//input[@name='email']")
		WebElement userEmailId;
		
		@FindBy(xpath="//button[@class='btn btn-primary mr']")
		WebElement sendInviteButton;
		@FindBy(xpath="//table[@class='table table-bordered']//a")
		List<WebElement> emailIDLink;
		@FindBy(xpath="//a[text()='›']")
		WebElement pagination;
		@FindBy(xpath="//button[text()='Cancel']")
		WebElement cancelTab;
		@FindBy(xpath="//span[text()='Please enter a valid email address']")
		WebElement ErrorInvalidEmailId;
		@FindBy(xpath="//span[text()='This field is required']")
		WebElement ErrorEmptyEmailID;	
		@FindBy(xpath="//a[text()=']")
		WebElement pageLink;
		public WebDriver driver;
		
		public Users(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void clickUserList() throws InterruptedException{
			Thread.sleep(3000);
			user.click();
		}
		
		public void clickInviteuserButton(){
			inviteUserButton.click();
			
		}
		public void typeEmailId(String emailID){
			userEmailId.sendKeys(emailID);
		}
		
		public void clickInviteButton(){
			sendInviteButton.click();
			
		}
		
		public void typeEmailIdD(String emailID){
			
			String g =ErrorInvalidEmailId.getText();
			Assert.assertEquals("Please enter a valid email address", g);
			
		}
		

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
		public void verifyEmailIdPresent(String emailID){
		
			int count = 1;

			//WebElement pagination = driver.findElement(By.xpath("//a[text()='›']"));

			while (pagination.isDisplayed()) {

				boolean exist = false;

				List<WebElement> allElement = emailIDLink;
				for (WebElement e : allElement) {

					if (e.getText().equals(emailID)) {
						exist = true;
						System.out.println(emailID + " Email id is present in user list");
						System.out.println(e.getText());

					}

					// Assert.assertEquals(exist, true, "Expected email id is not
					// present");
				}
				if (exist == true) {
					break;

				}
				count++;
			
				WebElement page = driver.findElement(By.xpath("//a[text()='" + count + "']"));
				page.click();

			
				//driver.quit();
			}
		}
	}

		
		
	
		

