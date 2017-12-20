package WaveFITSTestNG;


import TestResources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import DataProvider.SourceDataProvider;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestingIdentifiers1 {
    WebDriver driver;
    PageResources pageResources;
    @BeforeTest
    public void openApplication() throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/Users/bindhu/Desktop/Geckodriver/chromedriver");
        driver = new ChromeDriver();
        pageResources=new PageResources(driver);

    }
    @Test(priority = 0,dataProviderClass = SourceDataProvider.class,dataProvider = "loggingIn")
    public void loginToApplication(String enterEmailId,String enterPassword) throws InterruptedException {
        driver.get("http://fits.qauber.com/#/page/login");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        pageResources.getLoginpage().userEmailId(enterEmailId);
        pageResources.getLoginpage().userPassword(enterPassword);
        Thread.sleep(5000);
        pageResources.getLoginpage().loginButton();
    }
    @Test(dataProviderClass = SourceDataProvider.class,dataProvider = "insertingIdentifierData")
    public void selectingIdentifier(String caseId,String lastName,String firstName,String Tattoos,String Scars,String NeedleMarks,String Tracks,String Glasses,String Mustache,String Beard,String Location) throws InterruptedException {
        List<String> words = new ArrayList<String>();
        pageResources.getAddReportsPage().AddingReports();
        pageResources.getAddingEntity().selectingEntity();
        pageResources.getAddingEntity().clickNextButton();
        Thread.sleep(500);
        pageResources.getCreatingSubjectInformation().caseID(caseId);
        pageResources.getCreatingSubjectInformation().lastName(lastName);
        pageResources.getCreatingSubjectInformation().FirstName(firstName);
        pageResources.getCreatingSubjectInformation().clickNextButton();
        Thread.sleep(500);
        if(Tattoos.length()>0)
        {
            pageResources.getIdentifiersPage().checkBoxTattoos();
            pageResources.getIdentifiersPage().insertTattoos(Tattoos);
            words.add("Tattoos");
        }
        if(Scars.length()>0)
        {
            pageResources.getIdentifiersPage().checkBoxScars();
            pageResources.getIdentifiersPage().insertScars(Scars);
            words.add("Scars");
        }
        if(NeedleMarks.length()>0)
        {
            pageResources.getIdentifiersPage().checkNeedleMarks();
            pageResources.getIdentifiersPage().insertNeedleMarks(NeedleMarks);
            words.add("NeedleMarks");
        }
        if(Tracks.length()>0)
        {
            pageResources.getIdentifiersPage().checkTracks();
            pageResources.getIdentifiersPage().insertTracks(Tracks);
            words.add("Tracks");
        }
        if(Glasses.length()>0)
        {
            pageResources.getIdentifiersPage().checkGlasses();
            pageResources.getIdentifiersPage().insertGlasses(Glasses);
            words.add("Glasses");
        }
        if(Mustache.length()>0)
        {
            pageResources.getIdentifiersPage().checkMustache();
            pageResources.getIdentifiersPage().insertMustache(Mustache);
            words.add("Mustache");
        }
        if(Beard.length()>0)
        {
            pageResources.getIdentifiersPage().checkBeard();
            pageResources.getIdentifiersPage().insertBeard(Beard);
            words.add("Beard");
        }
        pageResources.getIdentifiersPage().clickNextButton();
        Thread.sleep(500);
        pageResources.getCreatingIDInformation().clickNextButton();
        pageResources.getCreatingDistribution().locationOfStop(Location);
        Thread.sleep(500);
        pageResources.getCreatingDistribution().clickNextButton();
        Thread.sleep(500);
        pageResources.getVehicalDetails().clickNextButton();
        Thread.sleep(500);
        pageResources.getAddPhotos().clickNextButton();
        Thread.sleep(500);
        pageResources.getCreatePublishReport().clickPublishReport();
        pageResources.getReportsPage().clickOnReport();
        pageResources.getReportsPage().FindReport(caseId);
        String viewPageCaseId = pageResources.getViewReports().viewPageCaseId();
        System.out.println("For Case Id "+viewPageCaseId);
        if(words.size()==0){
            Assert.assertEquals(pageResources.getViewReports().tattoosVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().scarsVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().needleMarksVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().tracksVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().glassesVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().mustacheVerified(),"");
            Assert.assertEquals(pageResources.getViewReports().beardVerified(),"");
            System.out.println("No Identifiers are saved");
        }
        for(String word:words){
            if(word.equals("Tattoos"))
            {
                Thread.sleep(500);
                Assert.assertEquals(pageResources.getViewReports().tattoosVerified(),Tattoos);
                System.out.println(Tattoos+" is saved in Tattoos");
            }
            if(word.equals("Scars"))
            {
                Assert.assertEquals(pageResources.getViewReports().scarsVerified(),Scars);
                System.out.println(Scars+" is saved in Scars");
            }
            if(word.equals("NeedleMarks"))
            {
                Assert.assertEquals(pageResources.getViewReports().needleMarksVerified(),NeedleMarks);
                System.out.println(NeedleMarks+" is saved in NeedleMarks");
            }
            if(word.equals("Tracks"))
            {
                Assert.assertEquals(pageResources.getViewReports().tracksVerified(),Tracks);
                System.out.println(Tracks+" is saved in Tracks");

            }
            if(word.equals("Glasses"))
            {
                Assert.assertEquals(pageResources.getViewReports().glassesVerified(),Glasses);
                System.out.println(Glasses+" is saved in Glasses");
            }
            if(word.equals("Mustache"))
            {
                Assert.assertEquals(pageResources.getViewReports().mustacheVerified(),Mustache);
                System.out.println(Mustache+" is saved in Mustache");

            }
            if(word.equals("Beard"))
            {
                Assert.assertEquals(pageResources.getViewReports().beardVerified(),Beard);
                System.out.println(Beard+" is saved in Beard");
            }

        }

    }
    @AfterTest
    public void CloseApplication() throws InterruptedException {
        pageResources.getLogOutPage().clickOnUserName();
        Thread.sleep(500);
        pageResources.getLogOutPage().clickOnLogOut();
        driver.quit();

    }



}
