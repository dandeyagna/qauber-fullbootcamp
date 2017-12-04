package testCollections;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTestNG {
 WebDriver driver;
 WebDriver driver1;	
 public static final String USERNAME = "amruthaabkk1";
 public static final String AUTOMATE_KEY = "CXgK8FsZicoyRYscPjsK";
 public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@BeforeTest()
	public void openBrowser() throws InterruptedException, MalformedURLException{
//	System.setProperty("webdriver.chrome.driver", "C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
//	System.setProperty("webdriver.chrome.driver1", "C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
		 DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("device", "iPhone 8 Plus");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "11.0");

		   
		    driver = new RemoteWebDriver(new URL(URL), caps);
	    driver1= new RemoteWebDriver(new URL(URL), caps);
//	 driver = new ChromeDriver();
//	 driver1 = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	driver1.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver1.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
}
	
	@Test(description="BC-507")
	public void reg1() throws InterruptedException{
		driver.get("http://fits.qauber.com/#/page/login");
		Thread.sleep(5000);
		//Thread.sleep(5000);
		WebElement button = driver.findElement(
				By.xpath("//a[text()='Register Now']"));
		button.click();
		

		driver.findElement(
				By.xpath("//input[@name='account_name']")).sendKeys("Reya");
		driver.findElement(
				By.xpath("//input[@name='account_email']")).sendKeys("seleniumfits@mailinator.com");
		driver.findElement(
				By.xpath(".//*[@id='id-password']")).sendKeys("automation");
		driver.findElement(
				By.xpath("//input[@name='account_password_confirm']")).sendKeys("automation");
		driver.findElement(
				By.xpath("//button[text()='Continue registration']")).click();
//		WebElement validate = driver.findElement(
//				By.xpath("//h4[text()='Company registration']"));
//		String a = validate.getText();
//		Assert.assertEquals(a,"Company registration");
		System.out.println("Succesfully done Resgistration step1");
	}
	
	@Test(dependsOnMethods={"reg1"},description="BC-508")
	public void regStep2() throws InterruptedException, AWTException{
		driver.findElement(
				By.xpath("//input[@name='name']")).sendKeys("Fits40");

		driver.findElement(
				By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

				try{
					
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


		/*Select drcountry = new Select(driver.findElement(
				By.xpath("//select[@name='country']/option[text()='Afghanistan']")));
		//drcountry.selectByVisibleText("Afghanistan");
		drcountry.selectByIndex(1);*/

		WebElement country = driver.findElement(
				By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(
				By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");


		WebElement address2= driver.findElement(
				By.xpath("//input[@ng-model='reg.company.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city= driver.findElement(
				By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");


		Select drstate = new Select(driver.findElement(
				By.xpath("//select[@name='state']")));
		//drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);


		WebElement zip= driver.findElement(
				By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");


		WebElement phone= driver.findElement(
				By.xpath("//input[@name='phone']"));
		phone.sendKeys("4084534567");

		WebElement email= driver.findElement(
				By.xpath("//input[@name='email']"));
		email.sendKeys("amruthaa@gmail.com");

		WebElement notes= driver.findElement(
				By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']"));
		notes.sendKeys("Adding entity to the organization");

		Thread.sleep(5000);


		WebElement confirm = driver.findElement(
				By.xpath(".//*[@id='registerConfirm']"));

		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
		    try {
		        ((JavascriptExecutor) driver).executeScript(
		                "arguments[0].scrollIntoView(true);", confirm);
		    } catch (Exception e) {

		    }
		}

		confirm.click();

		WebElement validate1 = driver.findElement(
				By.xpath("//div[text()='Registration successful.']"));
		
		String b = validate1.getText();
		Assert.assertEquals(b,"Registration successful.");
		System.out.println("Succesfully done Resgistration step2 ");
	}
	
	@Test(description="BC-509",dependsOnMethods={"regStep2"})
	public void regStep3() throws InterruptedException{
		driver1.get("https://www.mailinator.com/v2/inbox.jsp#");
		Thread.sleep(5000);
		
		driver1.findElement(
				By.xpath(".//*[@id='inbox_field']")).sendKeys("seleniumfits");
		driver1.findElement(
				By.xpath(".//*[@id='inbox_button']/i")).click();
		
		Thread.sleep(5000);
		
		driver1.findElement(
				By.xpath("//div[text()='Activate Your Account']")).click();
		Thread.sleep(5000);
		WebElement wb = driver1.findElement(By.xpath(".//*[@id='msgpane']/iframe"));
		driver1.switchTo().frame(wb);
		driver1.findElement(
				By.xpath("//a[text()='http://fits.qauber.com/#/page/activate']")).click();
	}
	
}