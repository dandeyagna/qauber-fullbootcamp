package testsWithTestNG;

import pages.MainNavigationPage;
import pages.SearchReportPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchReportTest extends LoginTest {

    //different types of test cases for searching report
    //1) Search by case id
    //2) Search by first name and last name
    //3) Search by date
    //4) search by text content
    private MainNavigationPage mainNavigationPage;
    private SearchReportPage searchReportPage;

    @Test(dependsOnMethods = "testLogin")
    public void searchByNameTest() throws InterruptedException {
        //2. search by first/last name
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickReportsLink();
        searchReportPage = new SearchReportPage(driver);
        searchReportPage.setLnSearchKey("iafiuho");//lname = iafiuho
        searchReportPage.setFnSearchKey("zmowbr");//fname = zmowbr
        searchReportPage.clickPublishedCheckBox();
        searchReportPage.clickView();
        String x = searchReportPage.getValidateLastName();
        System.out.println(x);
        Assert.assertEquals(x, "iafiuho");//assert that last name is same with what i search
        Thread.sleep(4000);
    }

    @Test(priority = 2)
    public void searchByCaseIdTest() throws InterruptedException {
        //1) Search by case id
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickReportsLink();
        searchReportPage = new SearchReportPage(driver);
        searchReportPage.setCiSearchKey("780");
        searchReportPage.clickPublishedCheckBox();
        searchReportPage.clickView();
        String x = searchReportPage.getValidateCaseId();
        System.out.println("This is what i get: " + x + " And this is what i expect: 780 caseId");
        Assert.assertEquals(x, "780");
        // mainNavigationPage.clickReportsLink();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void searchByContentTextTest() throws InterruptedException {
        //4) search by text content
        String textContent = "vlUlaBmEgZpuONvYxtRnhCduNmGiDxtkniUIWSuzQDOstsMUOQkDMruIfJZqgPXOHZvJaAfdYZRmIEAZEntubamllAZRDCTIgJsoIMCNpWplQPJsUTgwhVfqzPBBF";
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickReportsLink();
        searchReportPage = new SearchReportPage(driver);
        searchReportPage.clickPublishedCheckBox();
        searchReportPage.setCtSearchKey(textContent);
        searchReportPage.clickView();
        String x = searchReportPage.getValidateTextContent();
        System.out.println(x);
        Assert.assertEquals(x, textContent);
        Thread.sleep(4000);
    }

    @Test(priority = 4, enabled = false)
    public void searchByDateTest() {
        //3) Search by date

        //this test need to be updated
        String date = "12/04/2017";
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickReportsLink();
        searchReportPage = new SearchReportPage(driver);
        searchReportPage.setOpenedSearchFrom();


    }

}
