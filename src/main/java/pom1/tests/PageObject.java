package pom1.tests;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom1.pages.AddEntityPage;
import pom1.pages.Basepage;
import pom1.pages.LoginPageObject;

public class PageObject {
	WebDriver driver;
	public AddEntityPage AddEntity;
	public LoginPageObject Login;

	@BeforeTest
	public void test() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		if (null == driver) {
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//WebDriverWait wait = new WebDriverWait(driver, 20);
		}
	}

	@Test(dataProviderClass = DataProviders.class, dataProvider = "loginCredential")
	public void test1(String username, String password) throws InterruptedException {
		Login = new LoginPageObject(driver);
		Login.user_is_on_Home_Page();
		Login.typeUserName(username);
		Login.typePassword(password);
		Login.clickLoginButton();
	}

	@Test(dependsOnMethods = "test1", dataProviderClass = DataProviders.class, dataProvider = "addingEntity")
	public void test2(String entityname, String address, String addresstwo, String cityname, String postalcode,
			String phonenumber, String emailId, String notes, String userName, String paypalEmailId, String paypalPass)
			throws Exception {

		AddEntity = new AddEntityPage(driver);
		AddEntity.clickEntity();
		AddEntity.clickAddEntity();
		AddEntity.typeEname(entityname);
		AddEntity.clickLogo();
		AddEntity.clickCountry();
		AddEntity.typeAddress1(address);
		AddEntity.typeAddress2(addresstwo);
		AddEntity.typeCity(cityname);
		AddEntity.clickState();
		AddEntity.typeZip(postalcode);
		AddEntity.typePhone(phonenumber);
		AddEntity.typeEmail(emailId);
		AddEntity.typeInfo(notes);
		AddEntity.clickNext();
		AddEntity.typeregularUserEmailId(userName);
		AddEntity.clicknextReg();
		AddEntity.clickconfirm();
		AddEntity.typeadminUserEmailId(userName);
		AddEntity.clicknextAdmin();
		AddEntity.clickconfirmAd();
		AddEntity.getSize();
		AddEntity.comple_with_the_paypal_account();
		AddEntity.paypalLogin(paypalEmailId);
		AddEntity.papPalPass(paypalPass);
		AddEntity.clickOnPaypalLogin();
		AddEntity.clickOnContinue();
		AddEntity.user_should_be_able_to_see_the_added_entity_on_the_entity_page();

	}
}
