package downloadFiles;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class ChromeDriverDownloadTest {

    //This is just an ExampleDownloadReport
    //Chrome is deprecated and doesn't work

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:/Users/mcovi/OneDrive/Documente/drivers/chromedriver.exe");
            String downloadPath = "C:/Users/mcovi/OneDrive/QAuber/bootcamp";

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadPath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--test-type");
            options.addArguments("--disable-extensions"); // to disable browser
            // extension popup

            HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

            File f = new File("C:/Users/mcovi/OneDrive/QAuber/bootcamp/SampleXLSFile_19kb.xls");
            f.delete();

            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriver driver = new ChromeDriver(cap);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.get("http://www.sample-videos.com/download-sample-xls.php");

            driver.findElement(By.xpath("//*[@download='SampleXLSFile_19kb.xls']")).click();

            Thread.sleep(5000);

            if(f.exists()){
                System.out.println("File exists ... Test Passed !!!");
            }else{
                System.out.println("Test Failed !!!");
            }
        }


}
