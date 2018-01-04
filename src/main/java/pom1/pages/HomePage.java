package pom1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	protected static WebDriver driver;

	public HomePage(){
        System.setProperty("webdriver.chrome.driver", "/Users/aditisale/Downloads/chromedriver");
        if(null==driver){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
}
}