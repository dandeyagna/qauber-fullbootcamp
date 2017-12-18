package downloadFiles;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDownloadTestExample {
    public static String downloadPath = "C:\\Users\\mcovi\\IdeaProjects";
    public static void main(String[] args) throws Exception {
        //WebDriver driver = new FirefoxDriver();
        File f = new File("C:\\Users\\mcovi\\IdeaProjects\\SampleXLSFile_19kb.xls");

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
        driver.get("http://www.sample-videos.com/download-sample-xls.php");

        driver.findElement(By.xpath("//*[@download='SampleXLSFile_19kb.xls']")).click();

        //Checking whether new file got downloaded
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
        //Set File Open &amp; Save preferences
        profile.setPreference("browser.helperApps.neverAsk.openFile","text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.closeWhenDone", false);
        return profile;
    }

}