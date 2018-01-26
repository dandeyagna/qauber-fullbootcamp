package pom1.tests;
import pom1.pages.Login;
import pom1.pages.LoginPage;
import pom1.pages.UserPage;
import pom1.pages.Users;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;



public class InviteUsersTest {
	WebDriver driver;
	Login loginPage;
	Users user;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/aditisale/Downloads/chromedriver");

		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
	
	}

	@Test
	public void test1() throws InterruptedException {
		String emailLogin = "reshmaaher@gmail.com";
		String password = "Iltarget3";
		driver.get("http://fits.qauber.com/#/page/login");
		Thread.sleep(4000);
		loginPage = new Login(driver);
		loginPage.typeUserName(emailLogin);
		loginPage.typePassword(password);
		loginPage.clickLoginButton();
		Thread.sleep(5000);
		
	}
	@Test(description = "BC-518, BC-510", dependsOnMethods= {"test1"})
	public void test2() throws InterruptedException{
		user = new Users(driver);
		user.clickUserList();
		user.clickInviteuserButton();
		String email = "ll" + System.currentTimeMillis() + "@malinator.com";
		user.typeEmailId(email);
		user.clickInviteButton();
		Thread.sleep(10000);
		user.verifyEmailIdPresent(email);
	
		Thread.sleep(10000);
	
	
			}
	
	
	@Test(description ="BC-519, BC-511" ,dependsOnMethods= {"test1"})
	public void test3() throws InterruptedException{
		
		Thread.sleep(10000);
		user.clickUserList();
		user.clickInviteuserButton();
		String invalidEmail = "ll" + System.currentTimeMillis() + "@malinator.com";
		user.typeEmailId("---$@gmail.com");
		Thread.sleep(10000);
		user.typeEmailIdD(invalidEmail);
		user.closeTab();
		
	}
	
	@Test(description="BC-512, BC-520",dependsOnMethods= {"test1"})
	
	public void test4() throws InterruptedException{
		Thread.sleep(10000);
		user.clickUserList();	
		user.clickInviteuserButton();
		user.typeEmailId("");
		String emptyEmail = "" + System.currentTimeMillis() + "@malinator.com";
		user.clickInviteButton();
		user.typeEmptyEmailId(emptyEmail);
		user.closeTab();
		
		
	}

	
}