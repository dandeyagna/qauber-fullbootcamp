package Tests;

import Pages.AddReportPage;
import Pages.MainNavigationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddReport extends TestLogin {
    private MainNavigationPage mainNavigationPage;
    private AddReportPage addReportPage;
    @BeforeClass
    public void addReportBeforeClass(){
        mainNavigationPage=new MainNavigationPage(driver);
        addReportPage = new AddReportPage(driver);
    }
    @Test(dependsOnMethods = "testLogin")
    public void testAddReport(){
        mainNavigationPage.clickAddReportLink();
        String title = addReportPage.getHeaderText();
        Assert.assertEquals(title, "Field Interview Card");
        addReportPage.clickEntityNameRBtn();
        addReportPage.clickNextBtn();
        addReportPage.setCaseId("caseId");
        String title2 =addReportPage.getSubjectInformationTitle();
        Assert.assertEquals(title2, "Subject Information");
        String title3 =addReportPage.getIdentifiersTitle();
        Assert.assertEquals(title3, "Identifiers");
        String title4 = addReportPage.getIdInformationTitle();
        Assert.assertEquals(title4, "Id Information");
        String title5 = addReportPage.getDistributionTitle();
        Assert.assertEquals(title5, "Distribution");
        String title6 = addReportPage.getVehicleTitle();
        Assert.assertEquals(title6, "Vehicle");
        String title7 = addReportPage.getPhotosTitle();
        Assert.assertEquals(title7, "Photos");
        String title8 = addReportPage.getReviewInfo();
        Assert.assertEquals(title8, "Preview");
    }
}
