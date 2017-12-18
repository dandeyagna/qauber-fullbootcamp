package downloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ExampleDownloadReport {
    public static String downloadPath = "C:/Users/mcovi/IdeaProjects";
    public static void main(String[] args) throws Exception {
        //WebDriver driver = new FirefoxDriver();

        File f = new File("C:/Users/mcovi/IdeaProjects/SampleReport.pdf");

        //Deleting the file
        f.delete();
        //System.setProperty("webdriver.gecko.driver", "/Users/ydande/Downloads/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        FirefoxOptions option=new FirefoxOptions();
        option.setProfile(getFirefoxDriverProfile());
        //WebDriver driver =  new FirefoxDriver(capabilities);
        WebDriver driver = new FirefoxDriver(option);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://fits.qauber.com/#/page/login");
        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys("buquxahu@cars2.club");
        driver.findElement(By.xpath("//input[@name='account_password']")).sendKeys("kisulea");
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[contains(.,'Login')]")));
        driver.findElement(By.xpath("//input[@ng-model='ciSearchKey']")).sendKeys("780");
        driver.findElement(By.xpath("//label[text()='Published On']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-info btn-sm mt-sm ng-scope' and @title= 'View']")).click();
        executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[contains(.,'Download as PDF')]")));

        //Checking whether new file got downloaded
        Thread.sleep(3000);
        if(f.exists()){
            System.out.println("File exists .. Test Passed !!!");
        }else{
            System.out.println("Test Failed !!!");
        }

    }
    public static FirefoxProfile getFirefoxDriverProfile() throws Exception{
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        //Set downloadPath
        profile.setPreference("browser.download.dir", downloadPath);
        //Set File Open & Save preferences
        profile.setPreference("browser.helperApps.neverAsk.openFile","text/csv,application/x-msexcel,application/pdf,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.closeWhenDone", false);
        profile.setPreference("pdfjs.disabled", true);

        // Use this to disable  plugin for previewing PDFs in Firefox (if you have Adobe reader installed on your computer)
        profile.setPreference("plugin.scan.", "99.0");
        profile.setPreference("plugin.scan.plid.all", false);
        return profile;
    }
}
