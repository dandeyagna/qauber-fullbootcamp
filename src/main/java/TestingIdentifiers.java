package WAVE_FITS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestingIdentifiers {

    WebDriver driver;
    Helper helper;

    public void beforeTestcase() throws InterruptedException {
        helper.selectingEntity();
        helper.creatingSubjectInfo();
    }
    public void AfterTestCase() throws InterruptedException {
        helper.creatingIdInfo();
        helper.creatingDistribution();
        helper.creatingVehicle();
        Thread.sleep(500);
        helper.addPhoto();
        helper.publishReport();
    }
    @BeforeTest
    public void openApplication() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/bindhu/Desktop/Geckodriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

    }
    @Test(priority = 0)
    public void loginToApplication() throws InterruptedException {
        helper = new Helper(driver);
        helper.login("cubo@nada.ltd","abcdefgh");
    }

    @Test(groups = {"Testcase1"},dependsOnMethods = {"loginToApplication"},description = "user is unable to write without checking Identifiers")
    public void testCase1() throws InterruptedException {
        beforeTestcase();
        helper.testCase1();
        AfterTestCase();
    }
    @Test(groups = {"TestCase2"},dependsOnMethods = {"testCase1"},description = "user can select Tattoos in Identifiers")
    public void testCase2() throws InterruptedException {
        beforeTestcase();
        helper.testCase2();
        AfterTestCase();
    }
    @Test(groups={"TestCase3"},dependsOnMethods = {"testCase2"},description = "user can select Scars in Identifiers")
    public void testCase3() throws InterruptedException {
        beforeTestcase();
        helper.testCase3();
        AfterTestCase();
    }
    @Test(groups={"TestCase4"},dependsOnMethods = {"testCase3"},description = "user can select Scars in Identifiers")
    public void testCase4() throws InterruptedException {
        beforeTestcase();
        helper.testCase4();
        AfterTestCase();
    }
    @Test(groups={"TestCase5"},dependsOnMethods = {"testCase4"},description = "user can select Needle Marks in Identifiers")
    public void testCase5() throws InterruptedException {
        beforeTestcase();
        helper.testCase5();
        AfterTestCase();
    }
    @Test(groups={"TestCase6"},dependsOnMethods = {"testCase5"},description = "user can select Tracks in Identifiers")
    public void testCase6() throws InterruptedException {
        beforeTestcase();
        helper.testCase6();
        AfterTestCase();
    }
    @Test(groups={"TestCase7"},dependsOnMethods = {"testCase6"},description = "user can select Glasses in Identifiers")
    public void testCase7() throws InterruptedException {
        beforeTestcase();
        helper.testCase7();
        AfterTestCase();
    }
    @Test(groups={"TestCase8"},dependsOnMethods = {"testCase7"},description = "user can select Mustache in Identifiers")
    public void testCase8() throws InterruptedException {
        beforeTestcase();
        helper.testCase8();
        AfterTestCase();
    }
    @Test(groups = {"TestCase9"},dependsOnMethods = {"testCase8"},description = "user can select Beard in Identifiers")
    public void testCase9() throws InterruptedException {
        beforeTestcase();
        helper.testCase9();
        AfterTestCase();
    }
    @Test(groups = {"TestCase10"},dependsOnMethods = {"testCase9"},description = "user can select more then two Identifiers")
    public void testCase10() throws InterruptedException {
        beforeTestcase();
        helper.testCase10();
        AfterTestCase();
    }
    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
