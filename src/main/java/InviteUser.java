import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InviteUser {
	public String baseUrl = "http://fits.qauber.com/#/page/login";
	String driverPath = "/Users/aditisale/Downloads/chromedriver";
	public WebDriver driver;

	@BeforeTest
	public void Setup() {
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		driver.get(baseUrl);
	}

	@Test(groups = {
			"Login page" }, description = "User should be able to login into the FITS with valid email id and password")
	public void test1() throws InterruptedException {

		WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
		emailTextBox.sendKeys("reshmaaher@gmail.com");

		WebElement passwordTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
		passwordTextBox.sendKeys("Iltarget3");

		Thread.sleep(5000);

		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();

	}

	@Test(groups = {
			"Invite Users" }, description = "BC-518, BC-510 SA should invite Regular User with valid  email id")

	public void test2() throws InterruptedException {
		String email = "ll" + System.currentTimeMillis() + "@malinator.com";
		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));

		user.click();
		System.out.println("Clicked Users list");
		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();
		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys(email);

		WebElement sendInvite = driver.findElement(By.xpath("//button[@class='btn btn-primary mr']"));
		sendInvite.click();
		Thread.sleep(10000);

		// System.out.println(email);

		int count = 1;

		WebElement pagination = driver.findElement(By.xpath("//a[text()='›']"));

		while (pagination.isDisplayed()) {

			boolean exist = false;

			List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));
			for (WebElement e : allElement) {

				if (e.getText().equals(email)) {
					exist = true;
					System.out.println(email + " Email id is present in user list");
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

		}
	}

	@Test(dependsOnMethods = { "test1" }, groups = {
			"Invite Users" }, description = "BC-519, BC-511 SA should not invite Regular User with invalid  email id")
	public void test3() throws InterruptedException {
		Thread.sleep(10000);
		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));
		user.click();

		System.out.println("Clicked Users list");
		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();
		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys("---$@gmail.com");
		Thread.sleep(10000);

		WebElement ErrorEmailId = driver.findElement(By.xpath("//span[text()='Please enter a valid email address']"));
		String g = ErrorEmailId.getText();
		Assert.assertEquals("Please enter a valid email address", g);

		WebElement cancelTab = driver.findElement(By.xpath("//button[text()='Cancel']"));
		cancelTab.click();
	}

	@Test(groups = { "Invite Users" }, dependsOnMethods = {
			"test1" }, description = "BC-512, BC-520 SA should not invite Regular User with empty email id")
	public void test4() throws InterruptedException {

		Thread.sleep(10000);

		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));
		user.click();

		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();
		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys("");

		WebElement sendInvite = driver.findElement(By.xpath("//button[@class='btn btn-primary mr']"));
		sendInvite.click();
		Thread.sleep(10000);

		WebElement ErrorEmailId = driver.findElement(By.xpath("//span[text()='This field is required']"));
		String g = ErrorEmailId.getText();
		Assert.assertEquals("This field is required", g);

		Thread.sleep(10000);
		WebElement cancelTab = driver.findElement(By.xpath("//button[text()='Cancel']"));
		cancelTab.click();

	}

	@Test(groups = { "Invite Users" }, description = "BC-513 SA should not invite Regular User with empty email id")
	public void test5() throws InterruptedException {
		Thread.sleep(10000);

		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));
		user.click();

		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();
		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys("reshmaaher@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

		WebElement sendInvite = driver.findElement(By.xpath("//button[@class='btn btn-primary mr']"));
		sendInvite.click();
		Thread.sleep(10000);

		WebElement ErrorEmailId = driver.findElement(By.xpath("//span[text()='Please enter a valid email address']"));
		String g = ErrorEmailId.getText();
		Assert.assertEquals("Please enter a valid email address", g);

		Thread.sleep(10000);
		
		WebElement cancelTab = driver.findElement(By.xpath("//button[text()='Cancel']"));
		cancelTab.click();
	}

	@AfterTest
	public void logOut() {
		// driver.close();
		// WebElement logOutButton =
		// driver.findElement(By.xpath("//button[@class='btn btn-labeled
		// btn-primary btn-sm' ]"));
		// logOutButton.click();
	}
}