package WaveFITSCucumberTest;

import TestResources.PageResources;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestingIdentifiers_cucumberTest
{
    WebDriver driver;
    PageResources pageResources;


    @Given("^User is on the Home Page$")
    public void UserOpenedApplication() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/bindhu/Desktop/Geckodriver/chromedriver");
        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
        driver.get("http://fits.qauber.com/#/page/login");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        pageResources.getLoginpage().cucumberEmailId().sendKeys("cubo@nada.ltd");
        pageResources.getLoginpage().cucumberPassword().sendKeys("abcdefgh");
        Thread.sleep(5000);
        pageResources.getLoginpage().loginButton();
    }

    @When("^Click AddReportBtn, select entity and Provide personal information and click nextBtn\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\" and Select identifiers \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\" and Provide location of stop and Click nextBtn \"([^\"]*)\" and Publish report$")
    public void UserSelectsEntity(String caseid,String lastname,String firstname,String tattoos,String scars,String needlemarks,String tracks,String glasses,String mustache,String beard,String locationOfStop)throws InterruptedException
    {
        Thread.sleep(1000);
        pageResources.getAddReportsPage().AddingReports();
        pageResources.getAddingEntity().selectingEntity();
        pageResources.getAddingEntity().clickNextButton();
        pageResources.getCreatingSubjectInformation().caseID(caseid);
        pageResources.getCreatingSubjectInformation().lastName(lastname);
        pageResources.getCreatingSubjectInformation().FirstName(firstname);
        Thread.sleep(1000);
        pageResources.getCreatingSubjectInformation().clickNextButton();
        if(tattoos.length()>0)
        {
            pageResources.getIdentifiersPage().checkBoxTattoos();
            pageResources.getIdentifiersPage().insertTattoos(tattoos);
        }
        if(scars.length()>0)
        {
            pageResources.getIdentifiersPage().checkBoxScars();
            pageResources.getIdentifiersPage().insertScars(scars);
        }
        if(needlemarks.length()>0)
        {
            pageResources.getIdentifiersPage().checkNeedleMarks();
            pageResources.getIdentifiersPage().insertNeedleMarks(needlemarks);
        }
        if(tracks.length()>0)
        {
            pageResources.getIdentifiersPage().checkTracks();
            pageResources.getIdentifiersPage().insertTracks(tracks);
        }
        if(glasses.length()>0)
        {
            pageResources.getIdentifiersPage().checkGlasses();
            pageResources.getIdentifiersPage().insertGlasses(glasses);
        }
        if(mustache.length()>0)
        {
            Thread.sleep(500);
            pageResources.getIdentifiersPage().checkMustache();
            pageResources.getIdentifiersPage().insertMustache(mustache);
        }
        if(beard.length()>0)
        {
            pageResources.getIdentifiersPage().checkBeard();
            pageResources.getIdentifiersPage().insertBeard(beard);
        }
        pageResources.getIdentifiersPage().clickNextButton();
        Thread.sleep(1000);
        pageResources.getCreatingIDInformation().clickNextButton();
        pageResources.getCreatingDistribution().locationOfStop(locationOfStop);
        pageResources.getCreatingDistribution().clickNextButton();
        Thread.sleep(1000);
        pageResources.getVehicalDetails().clickNextButton();
        pageResources.getAddPhotos().clickNextButton();
        Thread.sleep(1000);
        pageResources.getCreatePublishReport().clickPublishReport();
    }
    @Then("^Assert Identifier is saved is published report\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void AssertingIdentifiers(String caseid,String tattoos,String scars,String needlemarks,String tracks,String glasses,String mustache,String beard) throws InterruptedException
    {
        pageResources.getReportsPage().clickOnReport();
        pageResources.getReportsPage().FindReport(caseid);
        String viewPageCaseId = pageResources.getViewReports().viewPageCaseId();
        System.out.println("For Case Id "+viewPageCaseId);
        if(tattoos.length()==0 && scars.length()==0 && needlemarks.length()==0 && tracks.length()==0 && glasses.length()==0 && mustache.length()==0 && beard.length()==0)
        {
            Assert.assertEquals(pageResources.getViewReports().tattoosVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().scarsVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().needleMarksVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().tracksVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().glassesVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().mustacheVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().beardVerified(),"");
            System.out.println("No Identifiers are saved");
        }
        if(tattoos.length()>0)
        {
            Thread.sleep(500);
            Assert.assertEquals(pageResources.getViewReports().tattoosVerified(),tattoos);
            System.out.println(tattoos+" is saved in Tattoos");
        }
        if(scars.length()>0)
        {
            Assert.assertEquals(pageResources.getViewReports().scarsVerified(),scars);
            System.out.println(scars+" is saved in Scars");
        }
        if(needlemarks.length()>0)
        {
            Assert.assertEquals(pageResources.getViewReports().needleMarksVerified(),needlemarks);
            System.out.println(needlemarks+" is saved in NeedleMarks");
        }
        if(tracks.length()>0)
        {
            Assert.assertEquals(pageResources.getViewReports().tracksVerified(),tracks);
            System.out.println(tracks+" is saved in Tracks");

        }
        if(glasses.length()>0)
        {
            Assert.assertEquals(pageResources.getViewReports().glassesVerified(),glasses);
            System.out.println(glasses+" is saved in Glasses");
        }
        if(mustache.length()>0)
        {
            Assert.assertEquals(pageResources.getViewReports().mustacheVerified(),mustache);
            System.out.println(mustache+" is saved in Mustache");
        }
        if(beard.length()>0)
        {
            Assert.assertEquals(pageResources.getViewReports().beardVerified(),beard);
            System.out.println(beard+" is saved in Beard");
        }
        pageResources.getLogOutPage().clickOnUserName();
        Thread.sleep(500);
        pageResources.getLogOutPage().clickOnLogOut();
        driver.quit();

    }

}

