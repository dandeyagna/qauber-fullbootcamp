import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AddreportTest {
    WebDriver dr;


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AddEntity_reportPage getAddEntityReportPage() {
        return addEntityReportPage;
    }

    public SubjectInformation getSubjectInformation() {
        return subjectInformation;
    }

    public Identifiers getIdentifiers() {
        return identifiers;
    }

    public Id_information getId_information() {
        return id_information;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Photos getPhotos() {
        return photos;
    }



    LoginPage loginPage;// <-object
    AddEntity_reportPage addEntityReportPage;
    SubjectInformation subjectInformation;
    Identifiers identifiers;
    Id_information id_information;
    Distribution distribution;
    Vehicle vehicle;
    Photos photos;







    public Previewpage getPreviewpage() {
        return previewpage;
    }

    Previewpage previewpage;

    @BeforeClass
    public void setup() throws InterruptedException {
        dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        dr.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        dr.get("http://fits.qauber.com/#/page/login");
        //dr.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        //dr.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(3000);
        loginPage = new LoginPage(dr);
        loginPage.usernamefield("matovbeck@gmail.com");
        loginPage.Password("qwerty1234");
        loginPage.loginButton();
    }
    @Test
    public void addreport() throws InterruptedException {
        loginPage = new LoginPage(dr);
        addEntityReportPage = new AddEntity_reportPage(dr);
        subjectInformation = new SubjectInformation(dr);
        identifiers = new Identifiers(dr);
        id_information = new Id_information(dr);
        distribution = new Distribution(dr);
        vehicle = new Vehicle(dr);
        photos = new Photos(dr);
        previewpage = new Previewpage(dr);

        Thread.sleep(5000);
        // Starting the actual test
        WebElement addreportlink = dr.findElement(By.xpath("//span[contains(text(),'Add Report')]"));
        addreportlink.click();
        Thread.sleep(3000);

        addEntityReportPage.get_entity(1).click();
        addEntityReportPage.gotosubject_information();
        Thread.sleep(3000);

        String lastname="Bond";
        String firstname="Dan";
        subjectInformation.getLastName().sendKeys(lastname);
        subjectInformation.getFirstName().sendKeys("Dan");
        subjectInformation.gotoidentifiers_information();
        identifiers.gotoid_information();
        Thread.sleep(3000);
        //id_information.ScrollUp();
         id_information.ScrollDown();
        Thread.sleep(3000);

        distribution.ScrollDown();
        Thread.sleep(3000);
        distribution.locationofStop().sendKeys("San Jose");
        distribution.ScrollUp();
        Thread.sleep(4000);

        WebElement previewbutton = dr.findElement(By.xpath("//h4/div[@class='fa fa-check-square size']"));
        previewbutton.click();
        Thread.sleep(3000);
        distribution.ScrollDown();
        Thread.sleep(3000);

        WebElement elementlast = dr.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']"));
        int y= elementlast.getLocation().getY();
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("window.scrollTo(0,"+y+")");
                previewpage.gotopublishreport();
                elementlast.click();
        Thread.sleep(5000);

        WebElement lastnamefield = dr.findElement(By.xpath("//input[@ng-model='slnSearchKey']"));
        lastnamefield.sendKeys("Bond");
        Thread.sleep(3000);
        // Verify If the report with that last name is shon in the Report information in the first row

        WebElement firstnamefield = dr.findElement(By.xpath("//input[@ng-model='sfnSearchKey']"));
        firstnamefield.sendKeys("Dan");
        Thread.sleep(3000);

        String caseid="98765";
        WebElement caseidfield = dr.findElement(By.xpath("//input[@ng-model='ciSearchKey']"));
        caseidfield.sendKeys("98765");
        Thread.sleep(3000);

        String suspecttype = "suspect";
        WebElement susp= dr.findElement(By.xpath("//select[@ng-model='stSearchKey']"));
        susp.sendKeys("suspectype");
        Thread.sleep(3000);







        String firstrowtext = dr.findElement(By.xpath("//td[1]")).getText();
        Boolean checkstatus = firstrowtext.contains(lastname);
        try{

            Assert.assertTrue(checkstatus==true);
            System.out.println("The Test is Pass");
            System.out.println("The last name matches");
        }catch(Throwable throwable){
            Assert.fail("The last name entered is not shown in the reports");
        }

        String secondrowtext = dr.findElement(By.xpath("//td[1]")).getText();
        Boolean checkstatus2 = secondrowtext.contains(firstname);
        try{
            Assert.assertTrue(checkstatus2==true);
            System.out.println("The second test is passed");
            System.out.println("The first name matches");
        }catch (Throwable throwable){
            Assert.fail("The first name is not shown in the reports");
        }

        String caseidtext = dr.findElement(By.xpath("//td[1]")).getText();
        Boolean checkstatus3 = caseidtext.contains(caseid);
        try{
            Assert.assertTrue(checkstatus3==true);
            System.out.println("Third TC passed");
            System.out.println("Case id matches");
        }catch(Throwable throwable){
            Assert.fail("Case id isn't found");
        }

        String suspecttypetext =dr.findElement(By.xpath("//td[1]")).getText();
        Boolean checkstatus4 = suspecttypetext.contains(suspecttype);
        try{
            Assert.assertTrue(checkstatus4==true);
            System.out.println("Forth TC passed");
            System.out.println("Suspect type matches");
        }catch(Throwable throwable){
            Assert.fail("Suspect type isn't found");
        }



    }


}
