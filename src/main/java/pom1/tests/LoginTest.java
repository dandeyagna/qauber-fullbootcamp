package pom1.tests;


import pom1.pages.Login;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTest {
	WebDriver driver;
	public Login loginPage;


	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/aditisale/Downloads/chromedriver");

		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.get("http://fits.qauber.com");
		
	}

	@Test(dataProvider="giveUserNeAndPasswords", enabled= false)
	public void test1(String emailLogin, String password) throws InterruptedException {
		
        loginPage = new Login(driver);

		Thread.sleep(4000);
		loginPage.typeUserName(emailLogin);
		loginPage.typePassword(password);
		loginPage.clickLoginButton();
		Thread.sleep(5000);
		//driver.quit();
		
		
		}
	@Test(dataProvider="giveInvalidEmailID", enabled= false)
	public void test2(String emailLogin,String password) throws InterruptedException {
	
        loginPage = new Login(driver);

		Thread.sleep(4000);
		loginPage.typeUserName(emailLogin);
		loginPage.validateErrorMessage_Invalid_Email();
		
		
		
	}
	@Test(dataProvider="giveEmptydEmailID", enabled= false)
	public void test3(String emailLogin,String password) throws InterruptedException {
		
        loginPage = new Login(driver);

		Thread.sleep(4000);
		loginPage.typeUserName(emailLogin);
		loginPage.clickLoginButton();
		loginPage.validateErrorMessage_Empty_Email();
		
	}
	
	@Test(dataProvider="giveInvalidPassword", enabled= true)
	public void test4(String emailLogin,String password) throws InterruptedException {
		
        loginPage = new Login(driver);

		Thread.sleep(4000);
		loginPage.typeUserName(emailLogin);
		loginPage.typePassword(password);
		loginPage.clickLoginButton();
		loginPage.validateErrorMessage_InvalidPassword_Correct();
	}
	
	
	@DataProvider
	public Object[][] giveUserNeAndPasswords() throws Exception{
		Object[][] testObjectArray = {{"ravi@mailinator.com","Iltarget3"},
		{"arch@mailinator.com","Iltarget3"}
		};
		return testObjectArray;
	}
	@DataProvider
	public Object[][] giveInvalidEmailID() throws Exception{
		Object[][] testObjectArray = {{"_____.com","Iltarget3"}};
		
		return testObjectArray;
	}
	@DataProvider
	public Object[][] giveEmptydEmailID() throws Exception{
		Object[][] testObjectArray = {{"","Iltarget3"}};
		
		return testObjectArray;
}
	@DataProvider
	public Object[][] giveInvalidPassword() throws Exception{
		Object[][] testObjectArray = {{"reshmaaher@gmail.com","**())"}};
		
		return testObjectArray;
}
	}
