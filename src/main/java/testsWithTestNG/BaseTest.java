package testsWithTestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private LoginPage loginPage;
    private String url;

    @BeforeClass(groups = {"regression"})
    public void baseBeforeClass() {
        driver = new FirefoxDriver();
        url = "http://fits.qauber.com/#/page/login";
        //driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(priority = 0, enabled = true,groups = {"regression"})
    public void assertLogo() {

        loginPage = new LoginPage(driver);
        assertTrue(loginPage.getLogo().isDisplayed());
    }
    /*
    @AfterMethod

    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\mcovi\\IdeaProjects\\learnJenkins\\src\\main\\java\\screenShots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));

        }
    }*/

    @AfterClass(groups = {"regression"})
    public void baseAfterClass() {

        driver.quit();
    }

}
