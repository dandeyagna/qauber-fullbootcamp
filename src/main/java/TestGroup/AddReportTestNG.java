package TestGroup;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class AddReportTestNG {
        private WebDriver driver;

        public static final String USERNAME = "robsnoop1";
        public static final String AUTOMATE_KEY = "BpfqRmqbGaHYi82uNht2";
        public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

        public void testAddReport() throws InterruptedException {
                Thread.sleep(5000);
                WebElement addReport = driver.findElement(
                        By.xpath("//a[@title='Add Report']/span"));
                Thread.sleep(5000);
                addReport.click();

        }
        @BeforeTest
        public void loginBeforeClass() throws Exception {
               // System.setProperty("webdriver.chrome.driver", "C:/Users/ravi.eluri/Downloads/chromedriver_win32/chromedriver.exe");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "62.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");

                driver = new RemoteWebDriver(new URL(URL), caps);
              //  driver = new ChromeDriver();
                //driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
                driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        }
        @Test(priority = 0)
                public void login() throws InterruptedException {
                driver.get("http://fits.qauber.com/#/page/login");
                Thread.sleep(5000);
                WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
                emailTextBox.sendKeys("jyotsnas54a@gmail.com");
                WebElement passwordTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
                passwordTextBox.sendKeys("robsnoop");

                Thread.sleep(5000);

                WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
                login.click();

                Thread.sleep(5000);

                WebElement profile = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
                String a = profile.getText();
                Assert.assertEquals(a, "jyo");

        }


        @Test(description = "BC-446")
        public void selEntity() throws InterruptedException {
                testAddReport();
                WebElement radEnt = driver.findElement(By.xpath("//label[text()='dps1']/span"));
                //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radEnt);
                radEnt.click();
                WebElement next = driver.findElement(By.xpath("//div[@ng-show='wizard.active(1)']/ul/li/a"));
                Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
                if (cp.getBrowserName().equals("chrome")) {
                        try {
                                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
                        } catch (Exception e) {

                        }
                }
                next.click();
                Thread.sleep(10000);
        }
        @Test(dependsOnMethods = {"selEntity"})
        public void mandatoryFieldsInSubInfo() throws InterruptedException {
                WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
                lastName.sendKeys("abcedfg");

                WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
                firstName.sendKeys("uvwxyz");


        }
        @Test(description = "BC-454", dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selSuspectType() throws InterruptedException {
                WebElement suspectType = driver.findElement(By.xpath("//select[@ng-model='wizard.report.suspectType']"));
                Select susType = new Select(suspectType);
                susType.selectByVisibleText("Suspect");
                Thread.sleep(5000);

        }

        @Test(dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selMiddleName() throws InterruptedException {
                WebElement middleName = driver.findElement(By.xpath("//input[@name='middleName']"));
                middleName.sendKeys("lmnopq");

        }

        @Test(dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void middleName() throws InterruptedException {
                WebElement nickName = driver.findElement(By.xpath("//input[@name='Nickname']"));
                nickName.sendKeys("snoopy");
        }

        @Test(description = "BC-460", dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void ageField() throws InterruptedException {
                WebElement Age = driver.findElement(By.xpath("//input[@name = 'Age']"));
                Age.sendKeys("123");
        }

        @Test(description = "BC-463", dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selSex() throws InterruptedException {
                WebElement sex = driver.findElement(By.xpath("//select[@ng-model='wizard.report.sex']"));
                Select sexType = new Select(sex);
                Thread.sleep(5000);
                sexType.selectByVisibleText("F");
        }

        @Test(description = "BC-464", dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selRace() throws InterruptedException {
                WebElement race = driver.findElement(By.xpath("//select[@ng-model='wizard.report.race']"));
                Select raceType = new Select(race);
                Thread.sleep(5000);
                raceType.selectByVisibleText("Caucasian");
        }

        @Test(description = "BC-469", dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selBuild() throws InterruptedException {
                WebElement build = driver.findElement(By.xpath("//select[@ng-model='wizard.report.build']"));
                Select buildType = new Select(build);
                Thread.sleep(1000);
                buildType.selectByVisibleText("Pot Belly");
        }

        @Test(description = "BC-470",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selHairColor() throws InterruptedException {

                WebElement hairColor = driver.findElement(By.xpath("//select[@ng-model='wizard.report.hairColor']"));
                Select hairColorType = new Select(hairColor);
                Thread.sleep(1000);
                hairColorType.selectByVisibleText("Orange");
                Thread.sleep(1000);
        }

        @Test(description = "BC-471",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selHairLen() throws InterruptedException {

                WebElement hairLength = driver.findElement(By.xpath("//select[@ng-model='wizard.report.hairLength']"));
                Select hairLengthType = new Select(hairLength);
                Thread.sleep(1000);
                hairLengthType.selectByVisibleText("Shaved");
                Thread.sleep(1000);
        }

        @Test(description = "BC-472",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selHairStyle() throws InterruptedException {

                WebElement hairStyle = driver.findElement(By.xpath("//select[@ng-model='wizard.report.hairStyle']"));
                Select hairStyleType = new Select(hairStyle);
                Thread.sleep(1000);
                hairStyleType.selectByVisibleText("Bald");
                Thread.sleep(1000);
        }

        @Test(description = "BC-473",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selEyeColor() throws InterruptedException {

                WebElement eyeColor = driver.findElement(By.xpath("//select[@ng-model='wizard.report.eyeColor']"));
                Select eyeColorType = new Select(eyeColor);
                Thread.sleep(1000);
                eyeColorType.selectByVisibleText("Multicolor");
                Thread.sleep(1000);
        }

        @Test(description = "BC-474",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selComplexion() throws InterruptedException {

                WebElement complexion = driver.findElement(By.xpath("//select[@ng-model='wizard.report.complexion']"));
                Select complexionType = new Select(complexion);
                Thread.sleep(1000);
                complexionType.selectByVisibleText("Freckled");
                Thread.sleep(1000);
        }

        @Test(description = "BC-475",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selTeeth() throws InterruptedException {

                WebElement teeth = driver.findElement(By.xpath("//select[@ng-model='wizard.report.teeth']"));
                Select teethType = new Select(teeth);
                Thread.sleep(1000);
                teethType.selectByVisibleText("Silver");
                Thread.sleep(1000);
        }

        @Test(description = "BC-476",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void handPrefer() throws InterruptedException {

                WebElement handPreference = driver.findElement(By.xpath("//select[@ng-model='wizard.report.handPreference']"));
                Select handPrefype = new Select(handPreference);
                Thread.sleep(1000);
                handPrefype.selectByVisibleText("Ambidextrous");
                Thread.sleep(1000);
        }

        @Test(description = "BC-477",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void priLang() throws InterruptedException {

                WebElement primelang = driver.findElement(By.xpath("//input[@name='primary-language']"));
                primelang.sendKeys("english, french");
        }
        @Test(description = "BC-459,BC-458,BC-457", dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void calIcon() throws InterruptedException {

                WebElement selCalIcon = driver.findElement(By.xpath("//div[3]/div[2]/div/div/p/span/button[@type='button']"));
                selCalIcon.click();

                Thread.sleep(5000);
                WebElement yrSel = driver.findElement(By.xpath("//td[@ng-repeat='dt in row']/button[@tabindex='-1']/span[text()='2012']"));
                String x = yrSel.getText();
                Assert.assertEquals(x, "2012");
                System.out.println(x);
                yrSel.click();

                Thread.sleep(5000);
                WebElement monSel = driver.findElement(By.xpath("//td[@ng-repeat='dt in row']/button[@ng-click='select(dt.date)']/span[text()='August']"));
                Thread.sleep(5000);
                String y = monSel.getText();
                Assert.assertEquals(y, "August");
                System.out.println(y);
                Thread.sleep(5000);
                monSel.click();
                Thread.sleep(5000);
                WebElement dtSel = driver.findElement(By.xpath("//td[@ng-repeat='dt in row']/button[@ng-click='select(dt.date)']/span[text()='12']"));
                Thread.sleep(5000);
                String z = dtSel.getText();
                Assert.assertEquals(z, "12");
                System.out.println(z);
                Thread.sleep(5000);
                dtSel.click();
        }


        @Test(description = "BC-465",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void heightNum() throws InterruptedException{
                WebElement height = driver.findElement(By.xpath("//input[@name='Height']"));
                height.sendKeys("290");
        }

        @Test(description = "BC-467",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void weightNum() throws InterruptedException{
                WebElement weight = driver.findElement(By.xpath("//input[@name='Weight']"));
                weight.sendKeys("290");
        }

        @Test(description = "BC-479", dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void selCountry() throws InterruptedException{
                WebElement country = driver.findElement(By.xpath("//select[@ng-model='wizard.report.country']"));
                Select countryType = new Select(country);
                countryType.selectByVisibleText("Brazil");
        }

        @Test(description = "BC-478",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void streetAddress() throws InterruptedException{
                WebElement address = driver.findElement(By.xpath("//input[@name='street-address']"));
                address.sendKeys("2905 Stender Way");
        }

        @Test(description = "BC-481",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void stateName() throws InterruptedException{
                WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
                state.sendKeys("California");
        }
        @Test(description = "BC-482",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void zipNum() throws InterruptedException{
                WebElement numZip = driver.findElement(By.xpath("//input[@name='zip']"));
                numZip.sendKeys("98768");
        }
        @Test(dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void telePhone() throws InterruptedException{
                WebElement phoneNum = driver.findElement(By.xpath("//input[@name='phone']"));
                phoneNum.sendKeys("5566533450");
        }
        @Test(description = "BC-483",dependsOnMethods = {"mandatoryFieldsInSubInfo"})
        public void email() throws InterruptedException{
                WebElement emailId = driver.findElement(By.xpath("//input[@name='email']"));
                emailId.sendKeys("abc@email.com");
        }

        /*@Test(dependsOnMethods = {"login"})
        public void exportReport() throws InterruptedException{
                WebElement reports = driver.findElement(By.xpath("//span[text()='Reports']"));
                Thread.sleep(10000);
                String r = reports.getText();
                Assert.assertEquals(r, "Reports");
                Thread.sleep(10000);
                WebElement unchkPub = driver.findElement(By.xpath("//label[text()='Published On']/span"));
                Thread.sleep(10000);
                unchkPub.click();
                Thread.sleep(10000);
                WebElement exReLipdf = driver.findElement(By.xpath("//button[@ng-click='downloadAsPdf()']"));
                exReLipdf.click();
        }*/


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

