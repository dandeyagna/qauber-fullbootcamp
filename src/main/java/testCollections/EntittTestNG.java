package testCollections;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EntittTestNG {
	WebDriver driver;

	@BeforeTest()
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		driver.get("http://fits.qauber.com/#/page/login");
		
	}
	@Test
	public void login() throws InterruptedException{
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
		
	}
	

	@Test(dependsOnMethods={"login"})
	public void step1_addEntity() throws InterruptedException, AWTException {
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("hellohi5");

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
	}
	@Test(dependsOnMethods={"step1_addEntity"})
	public void step2_addEntity() throws InterruptedException{
		WebElement regularUserEmailId = driver.findElement(By.xpath("//div[@class='bootstrap-tagsinput']/input"));
		regularUserEmailId.sendKeys(" selenium@mailinator.com ");
		Thread.sleep(5000);
		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		next1.click();
		Thread.sleep(5000);

		WebElement confirm = driver.findElement(By.xpath("//button[text()='Done']"));
		confirm.click();
	}

	@Test(dependsOnMethods={"step2_addEntity"})
	public void step3_addEntity() throws InterruptedException{
		WebElement adminUserEmailId = driver.findElement(By.xpath("//div[@class='form-group']/div/input"));
		adminUserEmailId.sendKeys(" selenium1@mailinator.com ");

		Thread.sleep(5000);

		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement confirmAd = driver.findElement(By.xpath("//button[text()='Done']"));
		confirmAd.click();

	}
	@Test(groups = { "functional" },dependsOnMethods={"step3_addEntity"},description = "BC-501 Adding Entity")
	public void addEntity() throws InterruptedException, AWTException {
		
		Thread.sleep(5000);

		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();

		Thread.sleep(5000);
		WebElement page = driver.findElement(By.xpath("//a[@ng-click='selectPage(page + 1, $event)']"));
		Capabilities cp1 = ((RemoteWebDriver) driver).getCapabilities();
		if (cp1.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page);
			} catch (Exception g) {

			}
		}
		page.click();
		while( page.isDisplayed() != false){
			List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));
			for (WebElement f : allElement) {
				String value = "hellohi1";
				if (f.getAttribute("text").equals(value)) {
					System.out.println("Pass");
					
				}
				
				}
			break;
		}

	}

	@Test(dependsOnMethods = {"step1_addEntity" },description="BC-489",enabled=false)
	public void withutRegUserAdminUser() throws InterruptedException {
		Thread.sleep(5000);
		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		next1.click();
		Thread.sleep(5000);
		
		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();
	}
	@Test(dependsOnMethods = { "step1_addEntity" },description="BC-491")
	public void withoutRegUser() throws InterruptedException{
		Thread.sleep(5000);
		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		next1.click();

		Thread.sleep(5000);
		WebElement adminUserEmailId = driver.findElement(By.xpath("//div[@class='form-group']/div/input"));
		adminUserEmailId.sendKeys(" selenium1@mailinator.com ");

		Thread.sleep(5000);

		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement confirmAd = driver.findElement(By.xpath("//button[text()='Done']"));
		confirmAd.click();
		
		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();
	}
	@Test(dependsOnMethods = { "step2_addEntity" },description="BC-492",enabled=false)
	public void withoutAdminUser() throws InterruptedException{
		Thread.sleep(5000);
		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();
	}
	@Test(description = "BC-503",dependsOnMethods={"login"})
	public void changeLogo() throws InterruptedException, Exception{
		WebElement entity = driver.findElement(
			By.xpath("//span[text()='Entities']"));
				
		entity.click();

		WebElement addentity = driver.findElement(
				By.xpath("//button[text()='Add Entity']"));
		addentity.click();
		
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
		
				Thread.sleep(5000);
				
			    WebElement change = driver.findElement(
			    		By.xpath("//span[text()='Change']"));
			    String validate1 = change.getText();
			    if(validate1.equals("Change")) {
			    	driver.findElement(
			    			By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
			    	String fileLocation1 = "C:\\Users\\user\\Desktop\\company.png";

			    	StringSelection filepath1 = new StringSelection(fileLocation1);

			    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);

			    	Robot robot1 = new Robot();

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
			    			Thread.sleep(5000);

			    			
			    			boolean image = driver.findElement(
			    					By.xpath("//div[text()='5.8 kB | company.png']")).isDisplayed();
			    			
			    			if(image == true) {
			    				System.out.println("Image displayed");
			    			}else {
			    				System.out.println("Image not displayed");
			    			}

			    }
	}
	
	@Test(description = "BC-493 Adding subscriptipon package",dependsOnMethods={"step3_addEntity"},enabled=false)
	public void subscription() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		WebElement sliderBar = driver.findElement(By.xpath("//div[@class='slider slider-horizontal']"));
        Dimension sliderBarDemsion = sliderBar.getSize();
        int widthSliderBar = sliderBarDemsion.width;


        WebElement slider = driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
        Actions sliderAction = new Actions(driver);
        sliderAction.clickAndHold(slider);
        int x1 = getPixels(widthSliderBar,60);
        sliderAction.moveByOffset(x1, 0).perform();

		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();

		Thread.sleep(5000);
		WebElement page = driver.findElement(By.xpath("//a[@ng-click='selectPage(page + 1, $event)']"));
		Capabilities cp1 = ((RemoteWebDriver) driver).getCapabilities();
		if (cp1.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page);
			} catch (Exception g) {

			}
		}

		int count = 1;

		WebElement pagination = driver.findElement(By.xpath("//a[text()='›']"));

		while (pagination.isDisplayed()) {
			
			boolean exist = false;

			List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));
			for (WebElement e : allElement) {
				String value = "hellohi1";
				if (e.getText().equals(value)) {
					exist = true;
					System.out.println(value + " Entity is present");
					

				}
				
				//Assert.assertEquals(exist, true, "Expected email id is not present");
					}
		if(exist==true){
		break;
		}
		count++;
		WebElement page1 = driver.findElement(By.xpath("//a[text()='" + count + "']"));
		page1.click();

	}

	}
	
	 public static int getPixels(int totalWidth,int percentage){
        return (int)((totalWidth*percentage)/100);
	}
	 @Test(description="BC-502 Delete Logo",dependsOnMethods={"login"})
	 public void delete() throws InterruptedException, AWTException{
		 WebElement entity = driver.findElement(
					By.xpath("//span[text()='Entities']"));
			entity.click();

			WebElement addentity = driver.findElement(
					By.xpath("//button[text()='Add Entity']"));
			addentity.click();
			
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
			
					Thread.sleep(5000);

					
			boolean deleteButton = driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-default ml-sm']")).isEnabled();
			if(deleteButton == true) {
				driver.findElement(
						By.xpath("//button[@class='upload btn btn-labeled btn-default ml-sm']")).click();
			}else {
				System.out.println("Delete button is disabled since there is no image uploaded");
			}
		
	 }

	@AfterTest(description = "Application logged out successfully")
	public void logout() throws InterruptedException {
		WebElement profile = driver.findElement(By.xpath("//em[@class='fa fa-caret-down']"));
		profile.click();

		Thread.sleep(5000);
		WebElement logout = driver.findElement(By.xpath("//button[@class='btn btn-labeled btn-primary btn-sm']"));
		logout.click();

		WebElement assertion = driver.findElement(By.xpath("//p[text()='SIGN IN TO CONTINUE.']"));
		String b = assertion.getText();

		if (b.equals("SIGN IN TO CONTINUE.")) {
			System.out.println("Test Case passed ...");
		} else {
			System.out.println("Test Case Failed ...");
		}

		driver.quit();
	}
}
