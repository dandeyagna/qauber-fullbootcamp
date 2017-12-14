package TestGroup;

import Pages.AddReport;
import Pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddReportTestNG {
        private WebDriver driver;
        public AddReport addReportTest;

        public void testAddReport() throws InterruptedException {
                Thread.sleep(5000);
                WebElement addReport = driver.findElement(
                        By.xpath("//a[@title='Add Report']/span"));
                Thread.sleep(5000);
                addReport.click();

        }
        @BeforeTest
        public void loginBeforeClass() throws Exception {
                System.setProperty("webdriver.chrome.driver", "C:/Users/ravi.eluri/Downloads/chromedriver_win32/chromedriver.exe");

                driver = new ChromeDriver();
             //   driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
                driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        }
        @Test(priority = 0)
                public void login() throws InterruptedException {
                String emailLogin = "jyotsnas54a@gmail.com";
                String password = "robsnoop";

                driver.get("http://fits.qauber.com/#/page/login");
                Thread.sleep(5000);
                LoginPage loginPage = new LoginPage(driver);
                loginPage.typeUserName(emailLogin);
                loginPage.typePassWord(password);
                loginPage.clickLoginButton();
                Thread.sleep(5000);
                // create page object model for below web element "Profile"
                WebElement profile = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
                String a = profile.getText();
                Assert.assertEquals(a, "jyo");
        }
        @Test(description = "BC-446") // testcase to select department "EC" and click on Next button
        public void selEntity() throws InterruptedException {
                testAddReport();
                addReportTest = new AddReport(driver);
                addReportTest.addReportDept();
                addReportTest.addReportEntityNext();
        }
        @Test(dependsOnMethods = {"selEntity"})// testcase to enter caseID and click on Next button
        public void caseIdFieldInSubInfo() throws InterruptedException {
                String caseNum = "R1094";
                addReportTest.typeCaseId(caseNum);
                addReportTest.subInfoNext(); // Click Next button for Subject Information
                Thread.sleep(5000);

                //create page object model for below web element "Reports" and "Published On"
                WebElement reports = driver.findElement(By.xpath("//span[text()='Reports']"));
                String r = reports.getText();
                Assert.assertEquals(r, "Reports");
                reports.click();
                Thread.sleep(5000);
                WebElement unchkPub = driver.findElement(By.xpath("//label[text()='Published On']/span"));
                Thread.sleep(5000);
                unchkPub.click();
                Thread.sleep(5000);

                int count = 1;
                WebElement pagination = driver.findElement(By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']/.."));
                Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
                if (cp.getBrowserName().equals("chrome")) {
                        try {
                                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pagination);
                        } catch (Exception e) {

                        }
                }
                String b;
                while (true) {
                        boolean exist = false;
                        List<WebElement> allElement = driver.findElements(By.xpath("//em[@title='Case ID']/../span"));
                        for (WebElement e : allElement) {
                                b = e.getText();
                                if (b.equals(caseNum)) {
                                        Thread.sleep(5000);
                                        WebElement editCaseId = driver.findElement(By.xpath("//span[text()='" + b + "']/../../div[5]/a[1]"));
                                        //((JavascriptExecutor) driver).executeScript("scroll(0,400)");
                                        Thread.sleep(5000);
                                        editCaseId.click();
                                        exist = true;
                                }
                        }
                        if (exist == true) {
                                break;
                        }
                        String attributeValue = pagination.getAttribute("class").toString();
                        System.out.println(attributeValue);
                        if (attributeValue.equals("ng-scope")) {
                                count++;
                                WebElement page = driver.findElement(By.xpath("//a[text()='" + count + "']"));
                                page.click();
                        } else {
                                break;
                        }
                }
                Thread.sleep(5000);
                addReportTest.addReportEntity();
                Thread.sleep(5000);
                addReportTest.addReportEntityNext();
                String validation = addReportTest.validation().getText();
                System.out.println(validation);
                Assert.assertEquals(caseNum, validation);
        }

        @AfterTest
        public void logOutAfterClass() throws InterruptedException {

                WebElement profile = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
                profile.click();
                Thread.sleep(5000);
                WebElement logout = driver.findElement(By.xpath("//button[@ng-click='app.logout()']"));
                String b = logout.getText();

                if (b.equals("Sign Out")) {
                        System.out.println("Test Case passed ...");
                } else {
                        System.out.println("Test Case Failed ...");
                }

                logout.click();
                Thread.sleep(5000);
                WebElement signInPg = driver.findElement(By.xpath("//p[@class='text-center pv']"));
                String c = signInPg.getText();
                if (c.equals("SIGN IN TO CONTINUE.")) {
                        System.out.println("Test Case passed ...");
                } else {
                        System.out.println("Test Case Failed ...");
                }

        }

}

