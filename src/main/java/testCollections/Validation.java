package testCollections;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validation {
	WebDriver driver;

	@BeforeTest()
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		driver.get("http://fits.qauber.com/#/page/login");
	}
	@Test(groups = { "Login" })
	public void login() throws InterruptedException {
		By x = By.xpath(".//*[@id='exampleInputEmail1']");
		WebElement emailTextBox = driver.findElement(x);
		emailTextBox.sendKeys("amruthaa.bkk@gmail.com");

		By y = By.xpath(".//*[@id='exampleInputPassword1']");
		WebElement passTextBox = driver.findElement(y);
		passTextBox.sendKeys("Amruthaa");

		Thread.sleep(5000);

		By z = By.xpath("//button[text()='Login']");
		WebElement login = driver.findElement(z);
		login.click();

		WebElement validate = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
		String a = validate.getText();

		if (a.equals("amruthaa")) {
			System.out.println("You are on the Fits homepage now ...");
		} else {
			System.out.println("Sorry something went wrong ...");
		}
		
		Thread.sleep(10000);
	}

	@Test(description = "BC-506",dependsOnMethods={"login"})
	public void emailValid() throws AWTException, InterruptedException{
		
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		//WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		//eName.sendKeys("wavefits19");

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

	WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
	country.click();

	WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
	address1.sendKeys("2905,stenderway");

	WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
	address2.sendKeys("Suite 21");

	WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
	city.sendKeys("Santa clara");

	Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
	// drstate.selectByVisibleText("Texas");
	drstate.selectByIndex(10);

	WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
	zip.sendKeys("94089");

	WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
	phone.sendKeys("4084534567");
	WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
	email.sendKeys("@gmail.com");
	WebElement error = driver.findElement(By.xpath("//span[text()='Please enter a valid email address']"));
	String e = error.getText();
	Assert.assertEquals("Please enter a valid email address",e );
	

	}
	@Test(description="BC-500 blank spaces in zip will lead to validation error",dependsOnMethods={"login"})
	public void postal() throws InterruptedException, AWTException{
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("wavefit17");

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

			robot.delay(500);

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		// drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");
		zip.clear();
		
		WebElement postalcode = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[7]/span"));
		String verify = postalcode.getText();
		Assert.assertEquals(verify, "This field is required");
	}
	@Test(description="BC-499 blank spaces in state will lead to validation error",dependsOnMethods={"login"})
	public void state() throws InterruptedException, AWTException{
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("wavefit17");

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

			robot.delay(500);

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		drstate.selectByVisibleText("Select a state");
		//drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");
		WebElement next = driver.findElement(By.xpath("//button[@ class='btn btn-info btn-labeled'][2]"));

		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
			} catch (Exception e) {

			}
		}

		next.click();
		Thread.sleep(5000);
		WebElement states = driver.findElement(By.xpath("//div[6]/span"));
		String verify = states.getText();
		Assert.assertEquals(verify, "This field is required");
	}
	@Test(description="BC-497 entering blank spaces in Address1 will lead to validation error",dependsOnMethods={"login"})
	public void address1() throws InterruptedException, AWTException{
		
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("wavefit17");

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

			robot.delay(500);

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");
		address1.clear();

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		// drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");
		WebElement next = driver.findElement(By.xpath("//button[@ class='btn btn-info btn-labeled'][2]"));

		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
			} catch (Exception e) {

			}
		}

		next.click();
		Thread.sleep(5000);
		WebElement address = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[3]/span"));
		String verify = address.getText();
		Assert.assertEquals(verify, "This field is required");
	}
	@Test(description = "496",dependsOnMethods={"login"})
	public void country() throws InterruptedException, AWTException {
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

			robot.delay(500);

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		Select country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		country.selectByVisibleText("Select a country");
		
		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		// drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("4084534567");

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("amruthaa@gmail.com");

		WebElement notes = driver
				.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']"));
		notes.sendKeys("Adding entity to the organization");

		Thread.sleep(5000);

		WebElement next = driver.findElement(By.xpath("//button[@ class='btn btn-info btn-labeled'][2]"));

		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
			} catch (Exception e) {

			}
		}

		next.click();
		Thread.sleep(5000);
		WebElement country1 = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[2]/span"));
		String verify = country1.getText();
		Assert.assertEquals(verify, "This field is required");
	}
	@Test(description="BC-504 Phone number field should not accept letters/special characters",dependsOnMethods={"login"})
	public void phone() throws InterruptedException, AWTException{
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("wavefi");
		
		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

			robot.delay(500);

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		// drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");
		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("4084534567");
		
		
	}
	@Test(description="BC-495 blank spaces in EntityName will lead to validation error",dependsOnMethods={"login"})
	public void enName() throws InterruptedException, AWTException{
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("wavefit17");
		eName.clear();

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

			robot.delay(500);

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		// drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");
		WebElement name = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[1]/div[1]/div/span[2]"));
		String verify = name.getText();
		Assert.assertEquals(verify, "This field is required");

	}
}
